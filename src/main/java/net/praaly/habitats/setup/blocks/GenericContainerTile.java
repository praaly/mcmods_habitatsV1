package net.praaly.habitats.setup.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.praaly.habitats.setup.ModBlocks;
import net.praaly.habitats.setup.inventory.GenericStorageContainer;
import net.praaly.habitats.setup.inventory.StorageContainers;

public abstract class GenericContainerTile extends LockableLootTileEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);
    private StorageContainers containerType;

    public GenericContainerTile(TileEntityType<?> tileEntityType, StorageContainers containerType) {
        super(tileEntityType);
        this.containerType = containerType;
    }

    @Override
    protected Container createMenu(int id, PlayerInventory playerInventory) {
        return new GenericStorageContainer(this, playerInventory, id, containerType);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> p_199721_1_) {
        this.items = p_199721_1_;
    }

    @Override
    public int getContainerSize() {
        return containerType.getRows() * containerType.getColumns();
    }

    public StorageContainers getContainerType() {
        return this.containerType;
    }


    public CompoundNBT save(CompoundNBT tag) {
        super.save(tag);
        if (!this.trySaveLootTable(tag)) {
            ItemStackHelper.saveAllItems(tag, this.items);
        }

        return tag;
    }

    public void load(BlockState state, CompoundNBT tag) {
        super.load(state, tag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(tag)) {
            ItemStackHelper.loadAllItems(tag, this.items);
        }

    }
}
