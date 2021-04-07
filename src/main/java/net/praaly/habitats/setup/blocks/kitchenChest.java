package net.praaly.habitats.setup.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import net.praaly.habitats.setup.blocks.BaseHorizontalBlock;

public class kitchenChest extends BaseHorizontalBlock {

	private static final VoxelShape SHAPE = Stream.of(
			Block.box(0, 0, 1, 3, 16, 13),
			Block.box(13, 0, 1, 16, 16, 13),
			Block.box(3, 0, 1, 13, 3, 13),
			Block.box(3, 13, 1, 13, 16, 13),
			Block.box(0, 0, 0, 16, 16, 1),
			Block.box(0, 0, 15, 16, 0, 16),
			Block.box(0, 0, 13, 16, 16, 15),
			Block.box(14, 5, 15, 15, 11, 16)
	).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

	public kitchenChest(Properties properties) {
		super(properties);
		runCalculation(SHAPE);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
	}
}
