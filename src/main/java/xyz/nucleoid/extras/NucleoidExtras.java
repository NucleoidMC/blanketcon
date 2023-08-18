package xyz.nucleoid.extras;

import eu.pb4.playerdata.api.PlayerDataApi;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.nucleoid.extras.eventschedule.EventSchedule;
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
        ServerLifecycleEvents.SERVER_STARTED.register((x) -> EventSchedule.load());
        ServerLifecycleEvents.START_DATA_PACK_RELOAD.register((a, b) -> EventSchedule.load());
        ServerLifecycleEvents.SERVER_STOPPING.register((a) -> EventSchedule.save());
        CommandRegistrationCallback.EVENT.register(EventSchedule::createCommands);
    }

    private static void onServerTick(MinecraftServer server) {
        ServerChangePortalBackend.tick(server);

        if (server.getTicks() % 20 == 0) {
            EventSchedule.instance.update();
        }
    }

    public static Identifier identifier(String path) {
        return new Identifier(ID, path);
    }
}
