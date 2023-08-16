package xyz.nucleoid.extras.lobby.block;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

public class FastPathBlock extends Block implements PolymerBlock {
    public static final UUID FAST_PATH_BOOST_ID = UUID.fromString("59365952-48a1-4fd6-a083-c8da69f1b2c4");
    public static final EntityAttributeModifier FAST_PATH_BOOST = new EntityAttributeModifier(FAST_PATH_BOOST_ID, "FastPath", 1.05f, EntityAttributeModifier.Operation.MULTIPLY_BASE);

    public FastPathBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return Blocks.DIRT_PATH;
    }
}
