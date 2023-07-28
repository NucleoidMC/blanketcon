package xyz.nucleoid.extras.lobby;

import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import eu.pb4.polymer.core.api.block.SimplePolymerBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;
import xyz.nucleoid.extras.NucleoidExtras;
import xyz.nucleoid.extras.lobby.block.*;
import xyz.nucleoid.extras.lobby.block.tater.*;

import java.util.Comparator;

public class NEBlocks {
    public static final Block NUCLEOID_LOGO = createTaterBlock(ParticleTypes.GLOW_SQUID_INK, "bac7400dfcb9a387361a3ad7c296943eb841a9bda13ad89558e2d6efebf167bc");

    public static final Block END_PORTAL = createSimple(Blocks.END_PORTAL);
    public static final Block END_GATEWAY = new VirtualEndGatewayBlock(AbstractBlock.Settings.create().pistonBehavior(PistonBehavior.BLOCK).strength(100).noCollision());
    public static final Block SAFE_TNT = createSimple(Blocks.TNT);

    public static final Block BLACK_CONCRETE_POWDER = createSimple(Blocks.BLACK_CONCRETE_POWDER);
    public static final Block BLUE_CONCRETE_POWDER = createSimple(Blocks.BLUE_CONCRETE_POWDER);
    public static final Block BROWN_CONCRETE_POWDER = createSimple(Blocks.BROWN_CONCRETE_POWDER);
    public static final Block CYAN_CONCRETE_POWDER = createSimple(Blocks.CYAN_CONCRETE_POWDER);
    public static final Block GREEN_CONCRETE_POWDER = createSimple(Blocks.GREEN_CONCRETE_POWDER);
    public static final Block GRAY_CONCRETE_POWDER = createSimple(Blocks.GRAY_CONCRETE_POWDER);
    public static final Block LIGHT_BLUE_CONCRETE_POWDER = createSimple(Blocks.LIGHT_BLUE_CONCRETE_POWDER);
    public static final Block LIGHT_GRAY_CONCRETE_POWDER = createSimple(Blocks.LIGHT_GRAY_CONCRETE_POWDER);
    public static final Block LIME_CONCRETE_POWDER = createSimple(Blocks.LIME_CONCRETE_POWDER);
    public static final Block MAGENTA_CONCRETE_POWDER = createSimple(Blocks.MAGENTA_CONCRETE_POWDER);
    public static final Block ORANGE_CONCRETE_POWDER = createSimple(Blocks.ORANGE_CONCRETE_POWDER);
    public static final Block PINK_CONCRETE_POWDER = createSimple(Blocks.PINK_CONCRETE_POWDER);
    public static final Block PURPLE_CONCRETE_POWDER = createSimple(Blocks.PURPLE_CONCRETE_POWDER);
    public static final Block RED_CONCRETE_POWDER = createSimple(Blocks.RED_CONCRETE_POWDER);
    public static final Block WHITE_CONCRETE_POWDER = createSimple(Blocks.WHITE_CONCRETE_POWDER);
    public static final Block YELLOW_CONCRETE_POWDER = createSimple(Blocks.YELLOW_CONCRETE_POWDER);

    public static final Block GOLD_LAUNCH_PAD = new LaunchPadBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE).strength(100).noCollision(), Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);
    public static final Block IRON_LAUNCH_PAD = new LaunchPadBlock(AbstractBlock.Settings.copy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE).strength(100).noCollision(), Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);

    public static final Block INFINITE_DISPENSER = new InfiniteDispenserBlock(AbstractBlock.Settings.copy(Blocks.DISPENSER).strength(100));
    public static final Block INFINITE_DROPPER = new InfiniteDropperBlock(AbstractBlock.Settings.copy(Blocks.DROPPER).strength(100));

    public static final Block SNAKE_BLOCK = new SnakeBlock(AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE).strength(100), Blocks.LIME_CONCRETE, 8, 7);
    public static final Block FAST_SNAKE_BLOCK = new SnakeBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE).strength(100), Blocks.LIGHT_BLUE_CONCRETE, 4, 7);

    public static final Block NUCLE_PAST_LOGO = createTaterBlock(new DustParticleEffect(Vec3d.unpackRgb(0x52C471).toVector3f(), 1), "65ed3e4d6ec42bd84d2b5e452087d454aac141a978540f6d200bd8aa863d4db8");

    public static final Block TINY_POTATO = createTaterBlock(ParticleTypes.HEART, "573514a23245f15dbad5fb4e622163020864cce4c15d56de3adb90fa5a7137fd");
    public static final Block BOTANICAL_TINY_POTATO = createBotanicTaterBlock(ParticleTypes.HEART,
        "39e878c52870c640b5985c67df70059120b61b26c77a5cf86042c04c13477d7b",
        "582f367eabffc9ecd8ab870c9f5f5c8b43215d5eb922cfb193aed70fcf694e92"
    );
    public static final Block IRRITATER = createTaterBlock(ParticleTypes.ANGRY_VILLAGER, "14b2cbfe1fd4d3123461081ad460acb6c0345bed3f3ce96d475b5f58f7b9030b");
    public static final Block SAD_TATER = createTaterBlock(ParticleTypes.FALLING_WATER, "7915f5ab6a3af5fd8e043bc98a5466acfc5d57c30dc9a1d2e4a32f7bfa1d35bf");
    public static final Block FLOWERING_AZALEA_TATER = createTaterBlock(Blocks.FLOWERING_AZALEA_LEAVES, "ab6c05d3be9369c69984513f281932622bca807008def997222a6d4f8cb71d83");
    public static final Block PUZZLE_CUBE_TATER = createTaterBlock(ParticleTypes.FIREWORK, "41f8da5c342e799bfae154c16627b6190923eae27735ef7ffbdeb1a121c8811b");
    public static final Block LUCKY_TATER = createLuckyTaterBlock("7417598f8d30dd3582ce723a1303abeeca9ac6a96438967b7f4c043fe3562ebb", "a590c5d7d05cd4ad1747b7b4e265dc97a07b054175e1f25b488c2de021075329");
    public static final Block FLIPPED_TATER = createTaterBlock(ParticleTypes.DAMAGE_INDICATOR, "9c1e33c4b7e6cb58e699aeb7ae412329f35cb443e50743c8896ed36dfb6a3588");
    public static final Block BACKWARD_TATER = createTaterBlock(ParticleTypes.HEART, "c3d2eefca5fa2e0cc710fe067f4a7114df0f430eeaaa1d9c373e4c91c9ed0ea4");
    public static final Block UPWARD_TATER = createTaterBlock(ParticleTypes.HEART, "60860143fea936066220eae3a31cdfe5aa9b4e525e194aa965c02272a01cb5c8");

    public static final Block TRANS_TATER = createColorPatternTaterBlock(new Vector3f[]{
        Vec3d.unpackRgb(0xEE90AD).toVector3f(), // pink
        Vec3d.unpackRgb(0x3CB0DA).toVector3f(), // blue
        Vec3d.unpackRgb(0xCFD5D6).toVector3f(), // white
    }, "f77dbc809b254449023fac0dd4e0d9100b5c4407748be089f0e00c7ef7ab764");
    public static final Block ASEXUAL_TATER = createColorPatternTaterBlock(new Vector3f[]{
        Vec3d.unpackRgb(0x16161B).toVector3f(), // black
        Vec3d.unpackRgb(0x3F4548).toVector3f(), // gray
        Vec3d.unpackRgb(0xCFD5D6).toVector3f(), // white
        Vec3d.unpackRgb(0x7B2BAD).toVector3f(), // purple
    }, "3902887dc55d4f736d0b566ad812f256113aaa4a318ffb865623fb5a677aef32");
    public static final Block BI_TATER = createColorPatternTaterBlock(new Vector3f[]{
        Vec3d.unpackRgb(0xBE46B5).toVector3f(), // pink
        Vec3d.unpackRgb(0x7B2BAD).toVector3f(), // purple
        Vec3d.unpackRgb(0x353A9E).toVector3f(), // blue
    }, "4526a72ca5be42920cd310280c03e2c9e9a70c55aa9cc1a0c48396d556f1c75d");
    public static final Block GAY_TATER = createColorPatternTaterBlock(new Vector3f[]{
        Vec3d.unpackRgb(0xA12823).toVector3f(), // red
        Vec3d.unpackRgb(0xF17716).toVector3f(), // orange
        Vec3d.unpackRgb(0xF9C629).toVector3f(), // yellow
        Vec3d.unpackRgb(0x556E1C).toVector3f(), // green
        Vec3d.unpackRgb(0x353A9E).toVector3f(), // blue
        Vec3d.unpackRgb(0x7B2BAD).toVector3f(), // purple
    }, "f9f446f29396ff444d0ef4f53a70c28afb69e5d1da037c03c277d23917dacded");
    public static final Block LESBIAN_TATER = createColorPatternTaterBlock(new Vector3f[]{
        Vec3d.unpackRgb(0xA12823).toVector3f(), // red
        Vec3d.unpackRgb(0xF17716).toVector3f(), // orange
        Vec3d.unpackRgb(0xEAEDED).toVector3f(), // white
        Vec3d.unpackRgb(0xEE90AD).toVector3f(), // pink
        Vec3d.unpackRgb(0xBE46B5).toVector3f(), // magenta
    }, "44492740f40c19c3e52871cdf6cbd585e980fc7b50cb0fc949bfbe44032a7db7");
    public static final Block NONBINARY_TATER = createColorPatternTaterBlock(new Vector3f[]{
        Vec3d.unpackRgb(0xF9C629).toVector3f(), // yellow
        Vec3d.unpackRgb(0x16161B).toVector3f(), // black
        Vec3d.unpackRgb(0xCFD5D6).toVector3f(), // white
        Vec3d.unpackRgb(0x7B2BAD).toVector3f(), // purple
    }, "10854e473bc7a0a6956cb12df8026de9fc00fae40c0502a3182908bbb50c9aa5");
    public static final Block PAN_TATER = createColorPatternTaterBlock(new Vector3f[]{
        Vec3d.unpackRgb(0xFA318C).toVector3f(), // pink
        Vec3d.unpackRgb(0xFDD73B).toVector3f(), // yellow
        Vec3d.unpackRgb(0x2394F9).toVector3f(), // blue
    }, "3f761be18f070a016e4f61d37ec13b23032a552dcdb70a67f855c3ab2fae54e0");
    public static final Block GENDERFLUID_TATER = createColorPatternTaterBlock(new Vector3f[]{
        Vec3d.unpackRgb(0xBE46B5).toVector3f(), // pink
        Vec3d.unpackRgb(0xCFD5D6).toVector3f(), // white
        Vec3d.unpackRgb(0x7B2BAD).toVector3f(), // purple
        Vec3d.unpackRgb(0x16161B).toVector3f(), // black
        Vec3d.unpackRgb(0x2394F9).toVector3f(), // blue
    }, "ba066cdd8d48501eb51eea1e3e417c25ef51a04284714baad5ab5de5cd4221b8");
    public static final Block DEMISEXUAL_TATER = createColorPatternTaterBlock(new Vector3f[]{
        Vec3d.unpackRgb(0x16161B).toVector3f(), // black
        Vec3d.unpackRgb(0xCFD5D6).toVector3f(), // white
        Vec3d.unpackRgb(0x7B2BAD).toVector3f(), // purple
        Vec3d.unpackRgb(0x3F4548).toVector3f(), // gray
    }, "32b7cd2c5d70cab476ce951e2c520c9b3579250ad900164d6c2321c7f43d6dc7");

    public static final Block WARDEN_TATER = createWardenTaterBlock("52e411aa1501c72d99d738cb38e250a395c6604b8bccc9f29d7f26e9cacd8d6f");
    public static final Block DICE_TATER = createDiceTaterBlock();
    public static final Block TATEROID = createTateroidBlock(SoundEvents.BLOCK_NOTE_BLOCK_BELL, -1, "8d531d40d09efd3a9a585b55e66a9a6f04c73af84d94d7c565549bf27b8b26bd");
    public static final Block RED_TATEROID = createTateroidBlock(SoundEvents.BLOCK_NOTE_BLOCK_GUITAR, 7 / 24d, "2be51b227360ab65776725a91cded84b56f6920eec0d6fb5a57d5f1ada147aa6");
    public static final Block ORANGE_TATEROID = createTateroidBlock(SoundEvents.BLOCK_NOTE_BLOCK_BASEDRUM, 4 / 24d, "c5362e308822cf1c436a4ba6d0c3976139c98621c7aa2a96be99c73e97708efc");
    public static final Block YELLOW_TATEROID = createTateroidBlock(SoundEvents.BLOCK_NOTE_BLOCK_CHIME, 2.5 / 24d, "fef74a6c7cb45d3c4bae134e6ec41fd7517f7eabe2c74dc76a51b39c63c38bc2");
    public static final Block GREEN_TATEROID = createTateroidBlock(SoundEvents.BLOCK_NOTE_BLOCK_BIT, 21 / 24d, "57bb692499560f0393314a9f1ec11425b360e43c1ddb560de261cd04b8cc8e69");
    public static final Block BLUE_TATEROID = createTateroidBlock(SoundEvents.BLOCK_NOTE_BLOCK_XYLOPHONE, 17 / 24d, "89ad5aecfb9ab6f36261e0c462acecf2078e7e575d9373bacc0503224c44250e");
    public static final Block PURPLE_TATEROID = createTateroidBlock(SoundEvents.BLOCK_NOTE_BLOCK_FLUTE, 11 / 24d, "d16a37512cb7ca372af5f37f9bd95d4603c4fa44be4143fb26aaa324e681c9b0");

    public static final Block WHITE_TATER = createColorTaterBlock(DyeColor.WHITE, "73dab052d33ee467ba7fac9aa0e316db962e3e7ac6dbbff236667439e340392c");
    public static final Block ORANGE_TATER = createColorTaterBlock(DyeColor.ORANGE, "75b88126dbd4e860608965c044d0060ac03c26ebea1b652643fe03734ea1b12b");
    public static final Block MAGENTA_TATER = createColorTaterBlock(DyeColor.MAGENTA, "bef4cf40f02bc129e34f660ce3923387894b8f0814fc58c09726629fa7b1db64");
    public static final Block LIGHT_BLUE_TATER = createColorTaterBlock(DyeColor.LIGHT_BLUE, "e6f7e4641fa4ee4ba926ebae4669f22f276051b3629f8d89ce015a95c1137fb2");
    public static final Block YELLOW_TATER = createColorTaterBlock(DyeColor.YELLOW, "5956df3e88f01cdd26d1caa07fab723c3a3db319ba167a3bed287d461635f1b9");
    public static final Block LIME_TATER = createColorTaterBlock(DyeColor.LIME, "16671f4c7ce8e46099f367fc05c5b61089c887f4145aff2077a1a7d3631dd063");
    public static final Block PINK_TATER = createColorTaterBlock(DyeColor.PINK, "b3efebba4906f9f260aae83fee73012370521726fadf0101498197d7143a64df");
    public static final Block GRAY_TATER = createColorTaterBlock(DyeColor.GRAY, "7e491b6282eca12c9edcddfb3baf6e5fb0549c89d39088567415616c92dfd5f0");
    public static final Block LIGHT_GRAY_TATER = createColorTaterBlock(DyeColor.LIGHT_GRAY, "b5df73cc026043d09c54cb15d0923e314503e1d513026b59a5317b31da4c5289");
    public static final Block CYAN_TATER = createColorTaterBlock(DyeColor.CYAN, "4eb39032053a3f2e5bd1d19bfacd25b524b19cd0e70a5a92a61ac884904ecb54");
    public static final Block PURPLE_TATER = createColorTaterBlock(DyeColor.PURPLE, "ab69ffa68135001e8714c78617e5a1a0177827cbbd866eb984f524f023f87fe5");
    public static final Block BLUE_TATER = createColorTaterBlock(DyeColor.BLUE, "618be72e94291de1cc3e3d2e2fa8bbd79422cdcb0cb70cedde7dc9c1bbef5fb5");
    public static final Block BROWN_TATER = createColorTaterBlock(DyeColor.BROWN, "df942f7c24f4c10353da974a938ad75f9a7ccdca232a99de870c5691d75fd70c");
    public static final Block GREEN_TATER = createColorTaterBlock(DyeColor.GREEN, "fab98a4c69e817771fec17c08c7e031952c05a52015dcecb09c93576745c71e2");
    public static final Block RED_TATER = createColorTaterBlock(DyeColor.RED, "51e4bf6f7a029567d598fff73c3c76e0cdea956a7fff5ea7279ea4bf40c968c2");
    public static final Block BLACK_TATER = createColorTaterBlock(DyeColor.BLACK, "57a7caa44cedff925d23cd5d3f62bc06e83d3485551dcc4f9db2da7d9f8a9694");

    public static final Block COAL_TATER = createTaterBlock(Blocks.COAL_BLOCK, "7eb25d3f8fcf48673ad0b171ea37154b43d57f6ab04d8ffb546fc606b8505bf4");
    public static final Block DIAMOND_TATER = createTaterBlock(Blocks.DIAMOND_BLOCK, "a399c9d599e0d9dc6a480e85f4dbecc45b318814026895ac8150fd2e2fa2599e");
    public static final Block EMERALD_TATER = createTaterBlock(ParticleTypes.HAPPY_VILLAGER, "cd76730df726b8ee9d72a3a478457d313626133de1d76c26cfc6af8e80e9c476");
    public static final Block GOLD_TATER = createTaterBlock(Blocks.GOLD_BLOCK, "180a7cc71153b89a536c148d2f1012d6772a7d3ba8321f922a6de46773c35af9");
    public static final Block IRON_TATER = createTaterBlock(Blocks.IRON_BLOCK, "174858c976f0274ebce3f3ffcef653609f29d37e0cc9cad25e586864b806cb23");
    public static final Block LAPIS_TATER = createTaterBlock(Blocks.LAPIS_BLOCK, "58d5cbda5c5046bf0b0f0d447c2fcc5e468707b6a4837c083af8e109aba9ce1c");
    public static final Block NETHERITE_TATER = createTaterBlock(Blocks.NETHERITE_BLOCK, "664dce4fade8e5f352001eff6900d9d4b142935ebed303106539f7ad0193621f");
    public static final Block QUARTZ_TATER = createTaterBlock(Blocks.QUARTZ_BLOCK, "7e7b4561d09d1a726fec3607706c9e3c77e8fc9b8c7e9c3637ca80ea0c86be21");
    public static final Block REDSTONE_TATER = createRedstoneTaterBlock(new DustParticleEffect(DustParticleEffect.RED, 1), "c47dd2536f5a5eb2bdb1ea4389d3af8ca2fd9d5d2c97c660fc5bf4d970c974de");

    public static final Block COPPER_TATER = createTaterBlock(ParticleTypes.SCRAPE, "18207c7cf4007222691750b0783d6959261ddf72980483f7c9fcf96c2cba85b1");

    public static final Block CAKE_TATER = createTaterBlock(Blocks.CAKE, "6d46fd58fd566bc0a90f8bc921daf0d9920591a5b153e64a80bb6d54dfb415b9");
    public static final Block PUMPKIN_TATER = createTaterBlock(Blocks.PUMPKIN, "21004377d30b55fd2f176e50e431ba88bd9eb8f353b103a67098a3fcbc12119d");
    public static final Block JACK_O_TATER = createTaterBlock(Blocks.JACK_O_LANTERN, "16772b77233f9d9035436287861b206ac13112d552a6c8e9754b26486b1e5bd");
    public static final Block SCULK_TATER = createTaterBlock(ParticleTypes.SOUL, "4265450388096aeb3d228c3b99f6ec64ea4a1a846c9903c7d9db1c309e27469b");
    public static final Block SLIME_TATER = createTaterBlock(Blocks.SLIME_BLOCK, "16747a7e1605794debfbb43befda2ce986075b3969e0b247ddd7bc6cdaa56a51");
    public static final Block SNOWMAN_TATER = createTaterBlock(ParticleTypes.SNOWFLAKE, "89ceb42efcfc372cbb26f817e1707a16864af16e0e37c793db05b16cd1f82ac");

    public static final Block TNTATER = createTaterBlock(ParticleTypes.EXPLOSION, "440d175ded62ff7b3cf9de979196e7b95da8a25e9e888c4bed06f5c011dc54a8", 10);
    public static final Block WOOL_TATER = createTaterBlock(Blocks.WHITE_WOOL, "ed564fa98b7e8e3abf41779bfe759ca0a3191c8aa70f2eef0af139ba1102e27e");

    public static final Block BEE_TATER = createTaterBlock(ParticleTypes.FALLING_HONEY, "80480b902bb32e2b145bb5262629ad7a920d3600365d3101936efc35aad830bd");
    public static final Block BLAZE_TATER = createTaterBlock(ParticleTypes.FLAME, "85e678d6edab035d25841cfb4c90b631a7242e9d4cf6bcf00f168b8bf7cd290d");
    public static final Block EYE_OF_ENDER_TATER = createTaterBlock(ParticleTypes.REVERSE_PORTAL, "36fc9fc2b0ab94a11303e3efb8b2534662e5d11ac8a9b9310b588a512eaab55e");
    public static final Block FOX_TATER = createTaterBlock(ParticleTypes.HEART, "d0d40bc2aa788d6f9d0e3fcde50714f3f47d5db64f3d6a11b2c3fad2b65ba1ea");
    public static final Block PUFFERTATER = createTaterBlock(ParticleTypes.DRIPPING_WATER, "4d777aa416424b7bb713c158117f7392a74ebd1fe49eff6fa2c4b1192720eb48");
    public static final Block RUBY_TATER = createTaterBlock(ParticleTypes.HAPPY_VILLAGER, "becb1ee95fba3f868fc36c126e5962244ac4bf64cd35b117871e62590a1660ed");

    public static final Block AZALEA_TATER = createTaterBlock(Blocks.AZALEA_LEAVES, "dc836641ecb40e775f85f4c71b219120e43080e03b8c84a7f60f1ba8127f2931");

    public static final Block JUKEBOX_TATER = createTaterBlock(ParticleTypes.NOTE, "75f6f61e3a9035a758174979ca664b26e47ca9b273f324f0921b5ad58bdb5835");
    public static final Block LANTERN_TATER = createTaterBlock(ParticleTypes.FLASH, "16c275f657bac1363333abf1db0d18bfabf087fbf3df356ec7f41258bc16b76d", 20);

    public static final Block ALLAY_TATER = createTaterBlock(ParticleTypes.HEART, "36911b99859c6627cba710041a7ce4ab17791e5c9278a85c75c1596dd1c789bb");
    public static final Block CORRUPTATER = new CorruptaterBlock(createTaterBlockSettings(), 2);

    public static final BlockEntityType<LaunchPadBlockEntity> LAUNCH_PAD_ENTITY = FabricBlockEntityTypeBuilder.create(LaunchPadBlockEntity::new, GOLD_LAUNCH_PAD, IRON_LAUNCH_PAD).build();
    public static final BlockEntityType<TateroidBlockEntity> TATEROID_ENTITY = FabricBlockEntityTypeBuilder.create(TateroidBlockEntity::new, TATEROID, RED_TATEROID, ORANGE_TATEROID, YELLOW_TATEROID, GREEN_TATEROID, BLUE_TATEROID, PURPLE_TATEROID).build();

    private static Block createSimple(Block virtual) {
        return new SimplePolymerBlock(AbstractBlock.Settings.copy(virtual).strength(100), virtual);
    }

    private static AbstractBlock.Settings createTaterBlockSettings() {
        return AbstractBlock.Settings.create().mapColor(MapColor.PALE_GREEN).strength(100);
    }

    private static Block createBotanicTaterBlock(ParticleEffect effect, String textureUp, String textureDown) {
        return new BotanicalPotatoBlock(createTaterBlockSettings(), textureUp, textureDown, effect, 2);
    }

    private static Block createTaterBlock(ParticleEffect effect, String texture) {
        return new CubicPotatoBlock(createTaterBlockSettings(), effect, texture);
    }

    private static Block createTaterBlock(Block particleBlock, String texture) {
        return new CubicPotatoBlock(createTaterBlockSettings(), particleBlock, texture);
    }

    private static Block createTaterBlock(Item particleItem, String texture) {
        return new CubicPotatoBlock(createTaterBlockSettings(), particleItem, texture);
    }

    private static Block createTaterBlock(ParticleEffect effect, String texture, int particleRate) {
        return new CubicPotatoBlock(createTaterBlockSettings(), effect, texture, particleRate);
    }
  
    private static Block createColorPatternTaterBlock(Vector3f[] pattern, String texture) {
        return new ColorPatternTaterBlock(createTaterBlockSettings(), pattern, texture);
    }

    private static Block createLuckyTaterBlock(String texture, String cooldownTexture) {
        return new LuckyTaterBlock(createTaterBlockSettings(), texture, cooldownTexture);
    }

    private static Block createWardenTaterBlock(String texture) {
        return new WardenTaterBlock(createTaterBlockSettings(), texture);
    }

    private static Block createDiceTaterBlock() {
        return new DiceTaterBlock(createTaterBlockSettings());
    }

    private static Block createTateroidBlock(RegistryEntry<SoundEvent> defaultSound, double particleColor, String texture) {
        return new TateroidBlock(createTaterBlockSettings(), defaultSound, particleColor, texture);
    }

    private static Block createColorTaterBlock(DyeColor color, String texture) {
        return new ColorTaterBlock(createTaterBlockSettings(), color, texture);
    }

    private static Block createRedstoneTaterBlock(ParticleEffect effect, String texture) {
        return new RedstoneTaterBlock(createTaterBlockSettings(), effect, texture);
    }

    public static void register() {
        register("nucleoid_logo", NUCLEOID_LOGO);
        register("nucle_past_logo", NUCLE_PAST_LOGO);

        register("end_portal", END_PORTAL);
        register("end_gateway", END_GATEWAY);
        register("safe_tnt", SAFE_TNT);
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

        register("tiny_potato", TINY_POTATO);
        register("botanical_potato", BOTANICAL_TINY_POTATO);
        register("irritater", IRRITATER);
        register("sad_tater", SAD_TATER);
        register("flowering_azalea_tater", FLOWERING_AZALEA_TATER);
        register("puzzle_cube_tater", PUZZLE_CUBE_TATER);
        register("lucky_tater", LUCKY_TATER);
        register("trans_tater", TRANS_TATER);
        register("asexual_tater", ASEXUAL_TATER);
        register("bi_tater", BI_TATER);
        register("gay_tater", GAY_TATER);
        register("lesbian_tater", LESBIAN_TATER);
        register("nonbinary_tater", NONBINARY_TATER);
        register("pan_tater", PAN_TATER);
        register("flipped_tater", FLIPPED_TATER);
        register("backward_tater", BACKWARD_TATER);
        register("upward_tater", UPWARD_TATER);
        register("genderfluid_tater", GENDERFLUID_TATER);
        register("demisexual_tater", DEMISEXUAL_TATER);

        register("warden_tater", WARDEN_TATER);
        register("dice_tater", DICE_TATER);
        register("tateroid", TATEROID);
        register("red_tateroid", RED_TATEROID);
        register("orange_tateroid", ORANGE_TATEROID);
        register("yellow_tateroid", YELLOW_TATEROID);
        register("green_tateroid", GREEN_TATEROID);
        register("blue_tateroid", BLUE_TATEROID);
        register("purple_tateroid", PURPLE_TATEROID);

        register("white_tater", WHITE_TATER);
        register("orange_tater", ORANGE_TATER);
        register("magenta_tater", MAGENTA_TATER);
        register("light_blue_tater", LIGHT_BLUE_TATER);
        register("yellow_tater", YELLOW_TATER);
        register("lime_tater", LIME_TATER);
        register("pink_tater", PINK_TATER);
        register("gray_tater", GRAY_TATER);
        register("light_gray_tater", LIGHT_GRAY_TATER);
        register("cyan_tater", CYAN_TATER);
        register("purple_tater", PURPLE_TATER);
        register("blue_tater", BLUE_TATER);
        register("brown_tater", BROWN_TATER);
        register("green_tater", GREEN_TATER);
        register("red_tater", RED_TATER);
        register("black_tater", BLACK_TATER);

        register("coal_tater", COAL_TATER);
        register("diamond_tater", DIAMOND_TATER);
        register("emerald_tater", EMERALD_TATER);
        register("gold_tater", GOLD_TATER);
        register("iron_tater", IRON_TATER);
        register("lapis_tater", LAPIS_TATER);
        register("netherite_tater", NETHERITE_TATER);
        register("quartz_tater", QUARTZ_TATER);
        register("redstone_tater", REDSTONE_TATER);
        
        register("copper_tater", COPPER_TATER);

        register("cake_tater", CAKE_TATER);
        register("pumpkin_tater", PUMPKIN_TATER);
        register("jack_o_tater", JACK_O_TATER);
        register("sculk_tater", SCULK_TATER);
        register("slime_tater", SLIME_TATER);
        register("snowman_tater", SNOWMAN_TATER);

        register("tntater", TNTATER);
        register("wool_tater", WOOL_TATER);

        register("bee_tater", BEE_TATER);
        register("blaze_tater", BLAZE_TATER);
        register("eye_of_ender_tater", EYE_OF_ENDER_TATER);
        register("fox_tater", FOX_TATER);
        register("puffertater", PUFFERTATER);
        register("ruby_tater", RUBY_TATER);

        register("azalea_tater", AZALEA_TATER);
        register("jukebox_tater", JUKEBOX_TATER);
        register("lantern_tater", LANTERN_TATER);

        register("allay_tater", ALLAY_TATER);

        register("corruptater", CORRUPTATER);

        registerBlockEntity("launch_pad", LAUNCH_PAD_ENTITY);
        registerBlockEntity("tateroid", TATEROID_ENTITY);

        TinyPotatoBlock.TATERS.sort(Comparator.comparing(x -> Registries.BLOCK.getId(x).getPath()));
    }

    private static <T extends Block> T register(String id, T block) {
        return Registry.register(Registries.BLOCK, NucleoidExtras.identifier(id), block);
    }

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String id, BlockEntityType<T> type) {
        Registry.register(Registries.BLOCK_ENTITY_TYPE, NucleoidExtras.identifier(id), type);
        PolymerBlockUtils.registerBlockEntity(type);
        return type;
    }
}
