package xyz.nucleoid.extras.lobby.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.DispenserBlockEntity;
import net.minecraft.block.entity.DropperBlockEntity;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPointerImpl;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class InfiniteDropperBlock extends InfiniteDispenserBlock {
    private static final DispenserBehavior BEHAVIOR = new ItemDispenserBehavior();

    public InfiniteDropperBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected DispenserBehavior getBehaviorForItem(ItemStack stack) {
        return BEHAVIOR;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DropperBlockEntity(pos, state);
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return Blocks.DROPPER;
    }

    protected void dispense(ServerWorld world, BlockPos pos) {
        BlockPointerImpl blockPointerImpl = new BlockPointerImpl(world, pos);
        DispenserBlockEntity dispenserBlockEntity = blockPointerImpl.getBlockEntity();
        int i = dispenserBlockEntity.chooseNonEmptySlot(world.random);
        if (i < 0) {
            world.syncWorldEvent(1001, pos, 0);
        } else {
            ItemStack itemStack = dispenserBlockEntity.getStack(i);
            if (!itemStack.isEmpty()) {
                Direction direction = world.getBlockState(pos).get(FACING);
                Inventory inventory = HopperBlockEntity.getInventoryAt(world, pos.offset(direction));
                if (inventory == null) {
                    BEHAVIOR.dispense(blockPointerImpl, itemStack.copy());
                } else {
                    HopperBlockEntity.transfer(dispenserBlockEntity, inventory, itemStack.copyWithCount(1), direction.getOpposite());
                }
            }
        }
    }
}
