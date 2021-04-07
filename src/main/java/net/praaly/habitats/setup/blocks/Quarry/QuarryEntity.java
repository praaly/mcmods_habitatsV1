package net.praaly.habitats.setup.blocks.Quarry;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.Tags;
import net.praaly.habitats.setup.ModTileEntityTypes;


public class QuarryEntity extends LockableTileEntity implements ITickableTileEntity {
    private int levelBelow = 1;
    public QuarryEntity() {
        super(ModTileEntityTypes.QUARRY.get());
    }

    @Override
    public void tick() {

        while (this.level.getBlockState(this.worldPosition.below(levelBelow)) != Blocks.BEDROCK.defaultBlockState())
        {
            if(!((this.level.getFluidState(this.worldPosition.below(levelBelow)) == Fluids.FLOWING_WATER.defaultFluidState()) || (this.level.getFluidState(this.worldPosition.below(levelBelow)) == Fluids.FLOWING_LAVA.defaultFluidState()) || (this.level.getFluidState(this.worldPosition.below(levelBelow)) == Fluids.WATER.defaultFluidState()) || (this.level.getFluidState(this.worldPosition.below(levelBelow)) == Fluids.LAVA.defaultFluidState())))
            {
                this.level.setBlock(this.worldPosition.below(levelBelow), Blocks.AIR.defaultBlockState(), 2);
            }
            levelBelow = levelBelow + 1;
        }

    }

    void encodeExtraData(PacketBuffer buffer)
    {

    }

    @Override
    protected ITextComponent getDefaultName() {
        return null;
    }

    @Override
    protected Container createMenu(int p_213906_1_, PlayerInventory p_213906_2_) {
        return null;
    }

    @Override
    public int getContainerSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getItem(int p_70301_1_) {
        return null;
    }

    @Override
    public ItemStack removeItem(int p_70298_1_, int p_70298_2_) {
        return null;
    }

    @Override
    public ItemStack removeItemNoUpdate(int p_70304_1_) {
        return null;
    }

    @Override
    public void setItem(int p_70299_1_, ItemStack p_70299_2_) {

    }

    @Override
    public boolean stillValid(PlayerEntity p_70300_1_) {
        return false;
    }

    @Override
    public void clearContent() {

    }


}
