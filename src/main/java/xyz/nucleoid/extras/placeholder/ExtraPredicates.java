package xyz.nucleoid.extras.placeholder;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import eu.pb4.placeholders.api.PlaceholderContext;
import eu.pb4.placeholders.api.PlaceholderResult;
import eu.pb4.placeholders.api.Placeholders;
import eu.pb4.predicate.api.MinecraftPredicate;
import eu.pb4.predicate.api.PredicateRegistry;
import eu.pb4.predicate.api.PredicateResult;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.extras.NucleoidExtras;
import xyz.nucleoid.plasmid.game.manager.GameSpaceManager;

import static xyz.nucleoid.extras.NucleoidExtras.identifier;


public class ExtraPredicates {
    public static void register() {
        PredicateRegistry.register(identifier("is_game"),
            MinecraftPredicate.simpleCodec(identifier("is_game"), (ctx) -> {
                if (ctx.hasWorld()) {
                    var game = GameSpaceManager.get().byWorld(ctx.world());
                    if (game != null) {
                        return PredicateResult.ofSuccess();
                    }
                }
                return PredicateResult.ofFailure();
            })
        );

        PredicateRegistry.register(identifier("game_type_id"),
            MinecraftPredicate.simpleCodec(identifier("game_type_id"), (ctx) -> {
                if (ctx.hasWorld()) {
                    var game = GameSpaceManager.get().byWorld(ctx.world());
                    if (game != null) {
                        return PredicateResult.ofSuccess(game.getMetadata().sourceConfig().type().id().toString());
                    }
                }
                return PredicateResult.ofFailure();
            })
        );
    }
}
