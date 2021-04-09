package net.praaly.habitats.setup.blocks.kitchen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.praaly.habitats.setup.blocks.BaseHorizontalBlock;
import net.praaly.habitats.setup.blocks.GenericContainerTile;
import net.praaly.habitats.setup.inventory.GenericStorageContainer;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class KitchenFridge extends BaseHorizontalBlock {

	private static final VoxelShape SHAPE = Stream.of(
			Block.box(12, 9, 1, 13, 10, 2),
			Block.box(1, 0, 2, 15, 16, 16),
			Block.box(1, 16, 2, 15, 32, 16),
			Block.box(12, 20, 0, 13, 28, 1),
			Block.box(12, 27, 1, 13, 28, 2),
			Block.box(12, 20, 1, 13, 21, 2),
			Block.box(12, 9, 0, 13, 13, 1),
			Block.box(12, 12, 1, 13, 13, 2)
	).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

	public KitchenFridge(Properties properties) {
		super(properties);
		runCalculation(SHAPE);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES.get(this).get(state.getValue(HORIZONTAL_FACING));
	}

	/* Everything below is new. Copy this code to other blocks to create chests */
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new KitchenFridgeTile(); //Change this if copied
	}

	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if(!worldIn.isClientSide()) {
			TileEntity tileEntity = worldIn.getBlockEntity(pos);
			if(tileEntity instanceof GenericContainerTile) {
				INamedContainerProvider containerProvider = new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return ((GenericContainerTile) tileEntity).getDisplayName();
					}

					@Nullable
					@Override
					public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
						return new GenericStorageContainer((IInventory) tileEntity, playerInventory, i, ((GenericContainerTile) tileEntity).getContainerType());
					}
				};
				NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getBlockPos());
			} else {
				throw new IllegalStateException("Named container provider is missing");
			}
		}
		return ActionResultType.SUCCESS;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onRemove(BlockState blockState, World worldIn, BlockPos pos, BlockState blockStateNew, boolean p_196243_5_) {
		if (!blockState.is(blockStateNew.getBlock())) {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof IInventory) {
				InventoryHelper.dropContents(worldIn, pos, (IInventory)tileentity);
				worldIn.updateNeighbourForOutputSignal(pos, this);
			}

			super.onRemove(blockState, worldIn, pos, blockStateNew, p_196243_5_);
		}
	}
}
