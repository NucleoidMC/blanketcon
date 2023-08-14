package xyz.nucleoid.extras.lobby.block.tater;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import xyz.nucleoid.extras.lobby.NEBlocks;

public class DaylightDetectorTaterBlockEntity extends BlockEntity {
	public DaylightDetectorTaterBlockEntity(BlockPos pos, BlockState state) {
		super(NEBlocks.DAYLIGHT_DETECTOR_TATER_ENTITY, pos, state);
	}
}
