package xyz.nucleoid.extras.lobby;

import eu.pb4.polymer.core.api.block.PolymerHeadBlock;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import xyz.nucleoid.extras.NucleoidExtras;
import xyz.nucleoid.extras.lobby.block.tater.TinyPotatoBlock;
import xyz.nucleoid.extras.lobby.item.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class NEItems {
    private static final List<Item> TATERS = new ArrayList<>();

    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
        .displayName(Text.translatable("text.nucleoid_extras.name"))
        .icon(() -> new ItemStack(NEItems.NUCLEOID_LOGO))
        .entries((context, entries) -> {
            entries.add(NEItems.QUICK_ARMOR_STAND);
            entries.add(NEItems.END_PORTAL);
            entries.add(NEItems.END_GATEWAY);
            entries.add(NEItems.SAFE_TNT);
            entries.add(NEItems.FAST_PATH);
            entries.add(NEItems.GOLD_LAUNCH_PAD);
            entries.add(NEItems.IRON_LAUNCH_PAD);
            entries.add(NEItems.INFINITE_DISPENSER);
            entries.add(NEItems.INFINITE_DROPPER);
            entries.add(NEItems.SNAKE_BLOCK);
            entries.add(NEItems.FAST_SNAKE_BLOCK);
            entries.add(NEItems.BLACK_CONCRETE_POWDER);
            entries.add(NEItems.BLUE_CONCRETE_POWDER);
            entries.add(NEItems.BROWN_CONCRETE_POWDER);
            entries.add(NEItems.CYAN_CONCRETE_POWDER);
            entries.add(NEItems.GREEN_CONCRETE_POWDER);
            entries.add(NEItems.GRAY_CONCRETE_POWDER);
            entries.add(NEItems.LIGHT_BLUE_CONCRETE_POWDER);
            entries.add(NEItems.LIGHT_GRAY_CONCRETE_POWDER);
            entries.add(NEItems.LIME_CONCRETE_POWDER);
            entries.add(NEItems.MAGENTA_CONCRETE_POWDER);
            entries.add(NEItems.ORANGE_CONCRETE_POWDER);
            entries.add(NEItems.PINK_CONCRETE_POWDER);
            entries.add(NEItems.PURPLE_CONCRETE_POWDER);
            entries.add(NEItems.RED_CONCRETE_POWDER);
            entries.add(NEItems.WHITE_CONCRETE_POWDER);
            entries.add(NEItems.YELLOW_CONCRETE_POWDER);
            entries.add(NEItems.GAME_PORTAL_OPENER);
            entries.add(NEItems.TATER_BOX);
            TaterBoxItem.addToItemGroup(entries);
            TATERS.forEach(entries::add);
        })
        .build();

    public static final Item NUCLEOID_LOGO = createHead(NEBlocks.NUCLEOID_LOGO);
    public static final Item NUCLE_PAST_LOGO = createHead(NEBlocks.NUCLE_PAST_LOGO);

    public static final Item END_PORTAL = createSimple(NEBlocks.END_PORTAL, Items.BLACK_CARPET);
    public static final Item END_GATEWAY = createSimple(NEBlocks.END_GATEWAY, Items.BLACK_WOOL);
    public static final Item SAFE_TNT = createSimple(NEBlocks.SAFE_TNT, Items.TNT);
    public static final Item FAST_PATH = createSimple(NEBlocks.FAST_PATH, Items.DIRT_PATH);

    public static final Item GOLD_LAUNCH_PAD = createSimple(NEBlocks.GOLD_LAUNCH_PAD, Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
    public static final Item IRON_LAUNCH_PAD = createSimple(NEBlocks.IRON_LAUNCH_PAD, Items.HEAVY_WEIGHTED_PRESSURE_PLATE);

    public static final Item INFINITE_DISPENSER = createSimple(NEBlocks.INFINITE_DISPENSER, Items.DISPENSER);
    public static final Item INFINITE_DROPPER = createSimple(NEBlocks.INFINITE_DROPPER, Items.DROPPER);
    public static final Item SNAKE_BLOCK = createSimple(NEBlocks.SNAKE_BLOCK, Items.LIME_CONCRETE);
    public static final Item FAST_SNAKE_BLOCK = createSimple(NEBlocks.FAST_SNAKE_BLOCK, Items.LIGHT_BLUE_CONCRETE);

    public static final Item BLACK_CONCRETE_POWDER = createSimple(NEBlocks.BLACK_CONCRETE_POWDER, Items.BLACK_CONCRETE_POWDER);
    public static final Item BLUE_CONCRETE_POWDER = createSimple(NEBlocks.BLUE_CONCRETE_POWDER, Items.BLUE_CONCRETE_POWDER);
    public static final Item BROWN_CONCRETE_POWDER = createSimple(NEBlocks.BROWN_CONCRETE_POWDER, Items.BROWN_CONCRETE_POWDER);
    public static final Item CYAN_CONCRETE_POWDER = createSimple(NEBlocks.CYAN_CONCRETE_POWDER, Items.CYAN_CONCRETE_POWDER);
    public static final Item GREEN_CONCRETE_POWDER = createSimple(NEBlocks.GREEN_CONCRETE_POWDER, Items.GREEN_CONCRETE_POWDER);
    public static final Item GRAY_CONCRETE_POWDER = createSimple(NEBlocks.GRAY_CONCRETE_POWDER, Items.GRAY_CONCRETE_POWDER);
    public static final Item LIGHT_BLUE_CONCRETE_POWDER = createSimple(NEBlocks.LIGHT_BLUE_CONCRETE_POWDER, Items.LIGHT_BLUE_CONCRETE_POWDER);
    public static final Item LIGHT_GRAY_CONCRETE_POWDER = createSimple(NEBlocks.LIGHT_GRAY_CONCRETE_POWDER, Items.LIGHT_GRAY_CONCRETE_POWDER);
    public static final Item LIME_CONCRETE_POWDER = createSimple(NEBlocks.LIME_CONCRETE_POWDER, Items.LIME_CONCRETE_POWDER);
    public static final Item MAGENTA_CONCRETE_POWDER = createSimple(NEBlocks.MAGENTA_CONCRETE_POWDER, Items.MAGENTA_CONCRETE_POWDER);
    public static final Item ORANGE_CONCRETE_POWDER = createSimple(NEBlocks.ORANGE_CONCRETE_POWDER, Items.ORANGE_CONCRETE_POWDER);
    public static final Item PINK_CONCRETE_POWDER = createSimple(NEBlocks.PINK_CONCRETE_POWDER, Items.PINK_CONCRETE_POWDER);
    public static final Item PURPLE_CONCRETE_POWDER = createSimple(NEBlocks.PURPLE_CONCRETE_POWDER, Items.PURPLE_CONCRETE_POWDER);
    public static final Item RED_CONCRETE_POWDER = createSimple(NEBlocks.RED_CONCRETE_POWDER, Items.RED_CONCRETE_POWDER);
    public static final Item WHITE_CONCRETE_POWDER = createSimple(NEBlocks.WHITE_CONCRETE_POWDER, Items.WHITE_CONCRETE_POWDER);
    public static final Item YELLOW_CONCRETE_POWDER = createSimple(NEBlocks.YELLOW_CONCRETE_POWDER, Items.YELLOW_CONCRETE_POWDER);

    public static final Item TINY_POTATO = createHead(NEBlocks.TINY_POTATO);
    public static final Item BOTANICAL_TINY_POTATO = createHead(NEBlocks.BOTANICAL_TINY_POTATO);
    public static final Item IRRITATER = createHead(NEBlocks.IRRITATER);
    public static final Item SAD_TATER = createHead(NEBlocks.SAD_TATER);
    public static final Item FLOWERING_AZALEA_TATER = createHead(NEBlocks.FLOWERING_AZALEA_TATER);
    public static final Item STONE_TATER = createHead(NEBlocks.STONE_TATER);
    public static final Item CALCITE_TATER = createHead(NEBlocks.CALCITE_TATER);
    public static final Item AMETHYST_TATER = createHead(NEBlocks.AMETHYST_TATER);
    public static final Item PACKED_ICE_TATER = createHead(NEBlocks.PACKED_ICE_TATER);
    public static final Item FLAME_TATER = createHead(NEBlocks.FLAME_TATER);
    public static final Item PUZZLE_CUBE_TATER = createHead(NEBlocks.PUZZLE_CUBE_TATER);
    public static final Item LUCKY_TATER = createHead(NEBlocks.LUCKY_TATER);
    public static final Item DICE_TATER = createHead(NEBlocks.DICE_TATER);
    public static final Item TRANS_TATER = createHead(NEBlocks.TRANS_TATER);
    public static final Item ASEXUAL_TATER = createHead(NEBlocks.ASEXUAL_TATER);
    public static final Item BI_TATER = createHead(NEBlocks.BI_TATER);
    public static final Item GAY_TATER = createHead(NEBlocks.GAY_TATER);
    public static final Item LESBIAN_TATER = createHead(NEBlocks.LESBIAN_TATER);
    public static final Item NONBINARY_TATER = createHead(NEBlocks.NONBINARY_TATER);
    public static final Item PAN_TATER = createHead(NEBlocks.PAN_TATER);
    public static final Item WARDEN_TATER = createHead(NEBlocks.WARDEN_TATER);
    public static final Item TATEROID = createHead(NEBlocks.TATEROID);
    public static final Item RED_TATEROID = createHead(NEBlocks.RED_TATEROID);
    public static final Item ORANGE_TATEROID = createHead(NEBlocks.ORANGE_TATEROID);
    public static final Item YELLOW_TATEROID = createHead(NEBlocks.YELLOW_TATEROID);
    public static final Item GREEN_TATEROID = createHead(NEBlocks.GREEN_TATEROID);
    public static final Item BLUE_TATEROID = createHead(NEBlocks.BLUE_TATEROID);
    public static final Item PURPLE_TATEROID = createHead(NEBlocks.PURPLE_TATEROID);
    public static final Item GENDERFLUID_TATER = createHead(NEBlocks.GENDERFLUID_TATER);
    public static final Item DEMISEXUAL_TATER = createHead(NEBlocks.DEMISEXUAL_TATER);

    public static final Item CREEPER_TATER = createHead(NEBlocks.CREEPER_TATER);

    public static final Item WHITE_TATER = createHead(NEBlocks.WHITE_TATER);
    public static final Item ORANGE_TATER = createHead(NEBlocks.ORANGE_TATER);
    public static final Item MAGENTA_TATER = createHead(NEBlocks.MAGENTA_TATER);
    public static final Item LIGHT_BLUE_TATER = createHead(NEBlocks.LIGHT_BLUE_TATER);
    public static final Item YELLOW_TATER = createHead(NEBlocks.YELLOW_TATER);
    public static final Item LIME_TATER = createHead(NEBlocks.LIME_TATER);
    public static final Item PINK_TATER = createHead(NEBlocks.PINK_TATER);
    public static final Item GRAY_TATER = createHead(NEBlocks.GRAY_TATER);
    public static final Item LIGHT_GRAY_TATER = createHead(NEBlocks.LIGHT_GRAY_TATER);
    public static final Item CYAN_TATER = createHead(NEBlocks.CYAN_TATER);
    public static final Item PURPLE_TATER = createHead(NEBlocks.PURPLE_TATER);
    public static final Item BLUE_TATER = createHead(NEBlocks.BLUE_TATER);
    public static final Item BROWN_TATER = createHead(NEBlocks.BROWN_TATER);
    public static final Item GREEN_TATER = createHead(NEBlocks.GREEN_TATER);
    public static final Item RED_TATER = createHead(NEBlocks.RED_TATER);
    public static final Item BLACK_TATER = createHead(NEBlocks.BLACK_TATER);

    public static final Item COAL_TATER = createHead(NEBlocks.COAL_TATER);
    public static final Item DIAMOND_TATER = createHead(NEBlocks.DIAMOND_TATER);
    public static final Item EMERALD_TATER = createHead(NEBlocks.EMERALD_TATER);
    public static final Item GOLD_TATER = createHead(NEBlocks.GOLD_TATER);
    public static final Item IRON_TATER = createHead(NEBlocks.IRON_TATER);
    public static final Item LAPIS_TATER = createHead(NEBlocks.LAPIS_TATER);
    public static final Item NETHERITE_TATER = createHead(NEBlocks.NETHERITE_TATER);
    public static final Item QUARTZ_TATER = createHead(NEBlocks.QUARTZ_TATER);
    public static final Item REDSTONE_TATER = createHead(NEBlocks.REDSTONE_TATER);

    public static final Item COPPER_TATER = createHead(NEBlocks.COPPER_TATER);

    public static final Item CAKE_TATER = createHead(NEBlocks.CAKE_TATER);
    public static final Item PUMPKIN_TATER = createHead(NEBlocks.PUMPKIN_TATER);
    public static final Item JACK_O_TATER = createHead(NEBlocks.JACK_O_TATER);
    public static final Item SCULK_TATER = createHead(NEBlocks.SCULK_TATER);
    public static final Item SLIME_TATER = createHead(NEBlocks.SLIME_TATER);
    public static final Item SNOWMAN_TATER = createHead(NEBlocks.SNOWMAN_TATER);


    public static final Item ANGRY_BEE_TATER = createHead(NEBlocks.ANGRY_BEE_TATER);
    public static final Item BEE_TATER = createHead(NEBlocks.BEE_TATER);
    public static final Item FOX_TATER = createHead(NEBlocks.FOX_TATER);
    public static final Item MOOBLOOM_TATER = createHead(NEBlocks.MOOBLOOM_TATER);
    public static final Item MUDDY_PIG_TATER = createHead(NEBlocks.MUDDY_PIG_TATER);
    public static final Item PUFFERTATER = createHead(NEBlocks.PUFFERTATER);
    public static final Item RUBY_TATER = createHead(NEBlocks.RUBY_TATER);
    public static final Item SANDSTONE_TATER = createHead(NEBlocks.SANDSTONE_TATER);
    public static final Item SNOW_FOX_TATER = createHead(NEBlocks.SNOW_FOX_TATER);

    public static final Item AZALEA_TATER = createHead(NEBlocks.AZALEA_TATER);
    public static final Item FLOWER_POT_TATER = createHead(NEBlocks.FLOWER_POT_TATER);
    public static final Item JUKEBOX_TATER = createHead(NEBlocks.JUKEBOX_TATER);
    public static final Item LANTERN_TATER = createHead(NEBlocks.LANTERN_TATER);
    public static final Item LUCY_AXOLOTL_TATER = createHead(NEBlocks.LUCY_AXOLOTL_TATER);
    public static final Item WILD_AXOLOTL_TATER = createHead(NEBlocks.WILD_AXOLOTL_TATER);
    public static final Item GOLD_AXOLOTL_TATER = createHead(NEBlocks.GOLD_AXOLOTL_TATER);
    public static final Item CYAN_AXOLOTL_TATER = createHead(NEBlocks.CYAN_AXOLOTL_TATER);
    public static final Item BLUE_AXOLOTL_TATER = createHead(NEBlocks.BLUE_AXOLOTL_TATER);

    public static final Item CORRUPTATER = createHead(NEBlocks.CORRUPTATER);

    public static final Item TATER_BOX = new TaterBoxItem(new Item.Settings().maxDamage(0));
    public static final Item QUICK_ARMOR_STAND = new QuickArmorStandItem(new Item.Settings());
    public static final Item GAME_PORTAL_OPENER = new GamePortalOpenerItem(new Item.Settings().maxCount(1));

    private static Item createHead(Block head) {
        if (head instanceof TinyPotatoBlock tinyPotatoBlock) {
            return new LobbyHeadItem(head, new Item.Settings(), tinyPotatoBlock.getItemTexture());
        } else if (head instanceof PolymerHeadBlock headBlock) {
            return new LobbyHeadItem(head, new Item.Settings(), headBlock.getPolymerSkinValue(head.getDefaultState(), BlockPos.ORIGIN, null));
        }

        return createSimple(head, Items.STONE);
    }

    private static Item createSimple(Block block, Item virtual) {
        return new LobbyBlockItem(block, new Item.Settings(), virtual);
    }

    public static void register() {
        register("end_portal", END_PORTAL);
        register("end_gateway", END_GATEWAY);
        register("safe_tnt", SAFE_TNT);
        register("fast_path", FAST_PATH);
        register("gold_launch_pad", GOLD_LAUNCH_PAD);
        register("iron_launch_pad", IRON_LAUNCH_PAD);
        register("infinite_dispenser", INFINITE_DISPENSER);
        register("infinite_dropper", INFINITE_DROPPER);
        register("snake_block", SNAKE_BLOCK);
        register("fast_snake_block", FAST_SNAKE_BLOCK);

        register("black_concrete_powder", BLACK_CONCRETE_POWDER);
        register("blue_concrete_powder", BLUE_CONCRETE_POWDER);
        register("brown_concrete_powder", BROWN_CONCRETE_POWDER);
        register("cyan_concrete_powder", CYAN_CONCRETE_POWDER);
        register("green_concrete_powder", GREEN_CONCRETE_POWDER);
        register("gray_concrete_powder", GRAY_CONCRETE_POWDER);
        register("light_blue_concrete_powder", LIGHT_BLUE_CONCRETE_POWDER);
        register("light_gray_concrete_powder", LIGHT_GRAY_CONCRETE_POWDER);
        register("lime_concrete_powder", LIME_CONCRETE_POWDER);
        register("magenta_concrete_powder", MAGENTA_CONCRETE_POWDER);
        register("orange_concrete_powder", ORANGE_CONCRETE_POWDER);
        register("pink_concrete_powder", PINK_CONCRETE_POWDER);
        register("purple_concrete_powder", PURPLE_CONCRETE_POWDER);
        register("red_concrete_powder", RED_CONCRETE_POWDER);
        register("white_concrete_powder", WHITE_CONCRETE_POWDER);
        register("yellow_concrete_powder", YELLOW_CONCRETE_POWDER);
        registerTater("nucleoid_logo", NUCLEOID_LOGO);
        registerTater("nucle_past_logo", NUCLE_PAST_LOGO);

        registerTater("tiny_potato", TINY_POTATO);
        registerTater("botanical_potato", BOTANICAL_TINY_POTATO);
        registerTater("irritater", IRRITATER);
        registerTater("sad_tater", SAD_TATER);
        registerTater("flowering_azalea_tater", FLOWERING_AZALEA_TATER);
        registerTater("stone_tater", STONE_TATER);
        registerTater("calcite_tater", CALCITE_TATER);
        registerTater("amethyst_tater", AMETHYST_TATER);
        registerTater("packed_ice_tater", PACKED_ICE_TATER);
        registerTater("flame_tater", FLAME_TATER);

        registerTater("puzzle_cube_tater", PUZZLE_CUBE_TATER);
        registerTater("lucky_tater", LUCKY_TATER);

        registerTater("dice_tater", DICE_TATER);
        registerTater("trans_tater", TRANS_TATER);
        registerTater("asexual_tater", ASEXUAL_TATER);
        registerTater("bi_tater", BI_TATER);
        registerTater("gay_tater", GAY_TATER);
        registerTater("lesbian_tater", LESBIAN_TATER);
        registerTater("nonbinary_tater", NONBINARY_TATER);
        registerTater("pan_tater", PAN_TATER);
        registerTater("warden_tater", WARDEN_TATER);
        registerTater("tateroid", TATEROID);
        registerTater("red_tateroid", RED_TATEROID);
        registerTater("orange_tateroid", ORANGE_TATEROID);
        registerTater("yellow_tateroid", YELLOW_TATEROID);
        registerTater("green_tateroid", GREEN_TATEROID);
        registerTater("blue_tateroid", BLUE_TATEROID);
        registerTater("purple_tateroid", PURPLE_TATEROID);
        registerTater("genderfluid_tater", GENDERFLUID_TATER);
        registerTater("demisexual_tater", DEMISEXUAL_TATER);

        registerTater("creeper_tater", CREEPER_TATER);

        registerTater("white_tater", WHITE_TATER);
        registerTater("orange_tater", ORANGE_TATER);
        registerTater("magenta_tater", MAGENTA_TATER);
        registerTater("light_blue_tater", LIGHT_BLUE_TATER);
        registerTater("yellow_tater", YELLOW_TATER);
        registerTater("lime_tater", LIME_TATER);
        registerTater("pink_tater", PINK_TATER);
        registerTater("gray_tater", GRAY_TATER);
        registerTater("light_gray_tater", LIGHT_GRAY_TATER);
        registerTater("cyan_tater", CYAN_TATER);
        registerTater("purple_tater", PURPLE_TATER);
        registerTater("blue_tater", BLUE_TATER);
        registerTater("brown_tater", BROWN_TATER);
        registerTater("green_tater", GREEN_TATER);
        registerTater("red_tater", RED_TATER);
        registerTater("black_tater", BLACK_TATER);

        registerTater("coal_tater", COAL_TATER);
        registerTater("diamond_tater", DIAMOND_TATER);
        registerTater("emerald_tater", EMERALD_TATER);
        registerTater("gold_tater", GOLD_TATER);
        registerTater("iron_tater", IRON_TATER);
        registerTater("lapis_tater", LAPIS_TATER);
        registerTater("netherite_tater", NETHERITE_TATER);
        registerTater("quartz_tater", QUARTZ_TATER);
        registerTater("redstone_tater", REDSTONE_TATER);

        registerTater("copper_tater", COPPER_TATER);

        registerTater("cake_tater", CAKE_TATER);
        registerTater("pumpkin_tater", PUMPKIN_TATER);
        registerTater("jack_o_tater", JACK_O_TATER);
        registerTater("sculk_tater", SCULK_TATER);
        registerTater("slime_tater", SLIME_TATER);
        registerTater("snowman_tater", SNOWMAN_TATER);
        registerTater("angry_bee_tater", ANGRY_BEE_TATER);
        registerTater("bee_tater", BEE_TATER);
        registerTater("fox_tater", FOX_TATER);
        registerTater("moobloom_tater", MOOBLOOM_TATER);
        registerTater("muddy_pig_tater", MUDDY_PIG_TATER);
        registerTater("puffertater", PUFFERTATER);
        registerTater("ruby_tater", RUBY_TATER);
        registerTater("sandstone_tater", SANDSTONE_TATER);
        registerTater("snow_fox_tater", SNOW_FOX_TATER);

        registerTater("azalea_tater", AZALEA_TATER);
        registerTater("flower_pot_tater", FLOWER_POT_TATER);
        registerTater("jukebox_tater", JUKEBOX_TATER);
        registerTater("lantern_tater", LANTERN_TATER);

        registerTater("lucy_axolotl_tater", LUCY_AXOLOTL_TATER);
        registerTater("wild_axolotl_tater", WILD_AXOLOTL_TATER);
        registerTater("gold_axolotl_tater", GOLD_AXOLOTL_TATER);
        registerTater("cyan_axolotl_tater", CYAN_AXOLOTL_TATER);
        registerTater("blue_axolotl_tater", BLUE_AXOLOTL_TATER);

        registerTater("corruptater", CORRUPTATER);

        register("tater_box", TATER_BOX);
        register("quick_armor_stand", QUICK_ARMOR_STAND);
        register("game_portal_opener", GAME_PORTAL_OPENER);

        PolymerItemGroupUtils.registerPolymerItemGroup(NucleoidExtras.identifier("general"), ITEM_GROUP);

        ServerPlayConnectionEvents.JOIN.register(NEItems::onPlayerJoin);

        UseEntityCallback.EVENT.register(NEItems::onUseEntity);
    }

    private static boolean tryOfferStack(ServerPlayNetworkHandler handler, Item item, Consumer<ItemStack> consumer) {
        var inventory = handler.getPlayer().getInventory();

        if (inventory.containsAny(Collections.singleton(item))) {
            return false;
        }

        var stack = new ItemStack(item);
        consumer.accept(stack);

        handler.getPlayer().getInventory().offer(stack, true);
        return true;
    }

    private static boolean tryOfferStack(ServerPlayNetworkHandler handler, Item item) {
        return tryOfferStack(handler, item, stack -> {});
    }

    private static void onPlayerJoin(ServerPlayNetworkHandler handler, PacketSender packetSender, MinecraftServer server) {

    }

    private static ActionResult onUseEntity(PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
        if (!player.getWorld().isClient() && hitResult != null) {
            ItemStack stack = player.getStackInHand(hand);
            if (stack.getItem() instanceof TaterBoxItem taterBox) {
                Vec3d hitPos = hitResult.getPos().subtract(entity.getPos());
                ActionResult result = taterBox.tryAdd(entity, hitPos, stack, player);

                return result.isAccepted() ? result : ActionResult.FAIL;
            }
        }

        return ActionResult.PASS;
    }

    private static <T extends Item> T registerTater(String id, T item) {
        register(id, item);
        TATERS.add(item);
        return item;
    }

    private static <T extends Item> T register(String id, T item) {
        return Registry.register(Registries.ITEM, NucleoidExtras.identifier(id), item);
    }
}
