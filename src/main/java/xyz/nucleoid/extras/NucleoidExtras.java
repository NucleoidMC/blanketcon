package xyz.nucleoid.extras;

import eu.pb4.playerdata.api.PlayerDataApi;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.nucleoid.extras.game_portal.ExtrasGamePortals;
import xyz.nucleoid.extras.game_portal.ServerChangePortalBackend;
import xyz.nucleoid.extras.lobby.*;
import xyz.nucleoid.extras.placeholder.ExtraPlaceholders;
import xyz.nucleoid.extras.placeholder.ExtraPredicates;

public final class NucleoidExtras implements ModInitializer {
    public static final String ID = "nucleoid_extras";
    public static final Logger LOGGER = LogManager.getLogger(NucleoidExtras.class);

    @Override
    public void onInitialize() {
        NEBlocks.register();
        NEItems.register();
        NEEntities.register();
        
        ExtraPlaceholders.register();
        ExtraPredicates.register();
        ExtrasGamePortals.register();

        PlayerDataApi.register(PlayerLobbyState.STORAGE);

        ServerTickEvents.END_SERVER_TICK.register(NucleoidExtras::onServerTick);
        ServerChangePortalBackend.register();
    }

    private static void onServerTick(MinecraftServer server) {
        ServerChangePortalBackend.tick(server);
    }

    public static Identifier identifier(String path) {
        return new Identifier(ID, path);
    }
}
