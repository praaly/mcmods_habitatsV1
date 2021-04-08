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
			Block.box(13, 0, 2, 16, 14, 16),
			Block.box(0, 0, 2, 3, 14, 16),
			Block.box(0, 14, 0, 3, 16, 16),
			Block.box(3, 0, 2, 13, 14, 3),
			Block.box(3, 0, 14, 13, 14, 16),
			Block.box(13, 14, 0, 16, 16, 16),
			Block.box(3, 14, 0, 13, 16, 4),
			Block.box(3, 14, 13, 13, 16, 16),
			Block.box(3, 14, 4, 4, 16, 13),
			Block.box(12, 14, 4, 13, 16, 13),
			Block.box(3, 4, 13, 13, 14, 14),
			Block.box(3, 4, 3, 13, 14, 4),
			Block.box(3, 5, 3, 13, 7, 13),
			Block.box(4, 16, 14, 5, 18, 16),
			Block.box(11, 16, 14, 12, 18, 16),
			Block.box(7, 16, 14, 9, 20, 16),
			Block.box(7, 19, 11, 9, 20, 14),
			Block.box(7, 1, 8, 9, 2, 14),
			Block.box(7, 2, 8, 9, 5, 9)
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
