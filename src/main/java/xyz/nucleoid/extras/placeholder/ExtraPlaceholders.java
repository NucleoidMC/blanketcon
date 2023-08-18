package xyz.nucleoid.extras.placeholder;

import eu.pb4.placeholders.api.PlaceholderContext;
import eu.pb4.placeholders.api.PlaceholderResult;
import eu.pb4.placeholders.api.Placeholders;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.extras.NucleoidExtras;
import xyz.nucleoid.extras.eventschedule.EventSchedule;
import xyz.nucleoid.plasmid.game.manager.GameSpaceManager;

public class ExtraPlaceholders {
    public static void register() {
        Placeholders.register(NucleoidExtras.identifier("location"), ExtraPlaceholders::locationDifference);
        Placeholders.register(NucleoidExtras.identifier("event"), ExtraPlaceholders::eventInfo);
        Placeholders.register(NucleoidExtras.identifier("event_current"), ExtraPlaceholders::eventCurrent);
    }

    private static PlaceholderResult eventInfo(PlaceholderContext placeholderContext, String s) {
        int id = 0;
        try {
            id = Integer.parseInt(s);
        } catch (Throwable e) {
        }

        var type = EventSchedule.instance.get(id);

        if (type == null) {
            return PlaceholderResult.value(Text.literal("--- No Events! ---").formatted(Formatting.YELLOW));
        } else {
            return PlaceholderResult.value(Text.empty()
                .append(Text.literal(type.name).formatted(Formatting.GOLD))
                .append(Text.literal(" [").formatted(Formatting.GRAY))
                .append(Text.literal(getDurationText(type.date)).formatted(Formatting.YELLOW))
                .append(Text.literal("]").formatted(Formatting.GRAY))
            );
        }
    }

    private static PlaceholderResult eventCurrent(PlaceholderContext placeholderContext, String s) {
        var type = EventSchedule.instance.currentEvent;

        if (type == null) {
            return PlaceholderResult.value(Text.literal("--- No Event! ---").formatted(Formatting.YELLOW));
        } else {
            var next = EventSchedule.instance.get(0);
            return PlaceholderResult.value(Text.empty()
                .append(Text.literal(type.name).formatted(Formatting.BLUE))
                .append(Text.literal(" [").formatted(Formatting.GRAY))
                .append(Text.literal(next == null && type.duration == -1 ? " +- Forever -+ " : getDurationText(type.duration == -1 ? next.duration : type.date + type.duration)).formatted(Formatting.AQUA))
                .append(Text.literal("]").formatted(Formatting.GRAY))
            );
        }
    }

    private static PlaceholderResult locationDifference(PlaceholderContext context, @Nullable String s) {
        if (context.hasWorld()) {
            return PlaceholderResult.value(MutableText.of(new GameTextContent(GameSpaceManager.get().byWorld(context.world()))));
        }

        return PlaceholderResult.value(Text.empty());
    }

    public static String getDurationText(long input) {
            long x = Math.abs(System.currentTimeMillis() / 1000 - input);

            long seconds = x % 60;
            long minutes = (x / 60) % 60;
            if (seconds > 5) {
                minutes += 1;
            }
            long hours = (x / (60 * 60));

            if (hours == 1) {
                hours = 0;
                minutes += 60;
            }

            StringBuilder builder = new StringBuilder();

            if (hours > 0) {
                builder.append(hours).append(" hours");
            } else {
                builder.append(minutes).append(" minutes");
            }
            return builder.toString();
        }
}
