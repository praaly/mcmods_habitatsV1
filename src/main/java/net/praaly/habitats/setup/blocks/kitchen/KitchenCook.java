package net.praaly.habitats.setup.blocks.kitchen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.praaly.habitats.setup.blocks.BaseHorizontalBlock;

import java.util.stream.Stream;

public class KitchenCook extends BaseHorizontalBlock {

	private static final VoxelShape SHAPE = Stream.of(
			Block.box(1, 0, 2, 15, 14, 16),
			Block.box(4, 2, 1, 12, 11, 2),
			Block.box(1, 14, 14, 15, 16, 16),
			Block.box(3, 14, 9, 7, 15, 12),
			Block.box(9, 14, 4, 13, 15, 7),
			Block.box(3, 14, 4, 7, 15, 7),
			Block.box(9, 14, 9, 13, 15, 12)
	).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

	public KitchenCook(Properties properties) {
		super(properties);
		runCalculation(SHAPE);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
	}
}
