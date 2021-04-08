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

public class KitchenSink extends BaseHorizontalBlock {

	private static final VoxelShape SHAPE = Stream.of(
			Block.box(7, 6, 6, 9, 7, 8),
			Block.box(0, 0, 0, 1, 13, 16),
			Block.box(15, 0, 0, 16, 13, 16),
			Block.box(1, 0, 0, 15, 13, 2),
			Block.box(1, 6, 12, 15, 13, 14),
			Block.box(13, 6, 2, 15, 13, 12),
			Block.box(1, 6, 2, 3, 13, 12),
			Block.box(1, 5, 2, 15, 6, 12),
			Block.box(1, 0, 14, 15, 13, 16),
			Block.box(7, 13, 13, 9, 16, 14),
			Block.box(7, 15, 9, 9, 16, 13),
			Block.box(11, 13, 13, 13, 15, 14),
			Block.box(3, 13, 13, 5, 15, 14)
	).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

	public KitchenSink(Properties properties) {
		super(properties);
		runCalculation(SHAPE);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
	}
}
