package xyz.nucleoid.extras.eventschedule;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static net.minecraft.server.command.CommandManager.literal;

public class EventSchedule {
    public static EventSchedule instance = new EventSchedule();

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().setLenient().disableHtmlEscaping().create();
    @SerializedName("current")
    public EventInfo currentEvent = null;
    public List<EventInfo> events = new ArrayList<>();


    @Nullable
    public EventInfo get(int i) {
        return i < events.size() && i >= 0 ? events.get(i) : null;
    }

    public void update() {
        var unix = System.currentTimeMillis() / 1000;

        events.removeIf(x -> (x.date + x.duration) < unix);

        if (currentEvent != null && currentEvent.duration != -1 && currentEvent.duration + currentEvent.date < unix) {
            currentEvent = null;
        }

        if (currentEvent == null && !events.isEmpty()) {
            var event = events.get(0);
            if (event.date <= unix) {
                currentEvent = event;
                events.remove(0);
            }
        }
    }

    public void add(String name, long date, int duration) {
       events.removeIf(x -> x.name.equals(name));
       if (currentEvent != null && currentEvent.name.equals(name)) {
           currentEvent = null;
       }
       events.add(new EventInfo(name, date, duration));
       events.sort(Comparator.comparing(EventInfo::name));
       update();
    }

    public void remove(String name) {
        events.removeIf(x -> x.name.equals(name));
        if (currentEvent != null && currentEvent.name.equals(name)) {
            currentEvent = null;
        }
        update();
    }

    public void finishCurrent() {
        currentEvent = null;
        update();
    }


    public static void load() {
        var file = FabricLoader.getInstance().getConfigDir().resolve("event_schedule.json");
        if (Files.exists(file)) {
            try {
                var x = GSON.fromJson(Files.readString(file), EventSchedule.class);
                if (x != null) {
                    instance = x;
                    x.update();
                    save();
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        } else {
            save();
        }
    }

    public static void save() {
        var file = FabricLoader.getInstance().getConfigDir().resolve("event_schedule.json");
        try {
            Files.writeString(file, GSON.toJson(instance));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void createCommands(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(
            literal("event_schedule")
                .requires(x -> x.hasPermissionLevel(2))
                .then(literal("skip").executes(ctx -> {
                    instance.finishCurrent();
                    return 0;
                }))
        );
    }
}
