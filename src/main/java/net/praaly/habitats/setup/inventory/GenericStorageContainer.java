package net.praaly.habitats.setup.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.praaly.habitats.setup.ModContainerTypes;

import javax.annotation.Nullable;

public class GenericStorageContainer extends Container {
    private final int totalSlots;
    private final StorageContainers type;

    public GenericStorageContainer(IInventory container, PlayerInventory inventory, int id, StorageContainers type) {
        this(type.containerType.get().get(), container, inventory, id, type, type.getRows(), type.getColumns(), type.getConX(), type.getConY(), type.getInvX(), type.getInvY());
    }
    public GenericStorageContainer(ContainerType<GenericStorageContainer> containerType, IInventory container, PlayerInventory inventory, int id, @Nullable StorageContainers type, int rows, int columns, int containerX, int containerY, int inventoryX, int inventoryY) {
        super(containerType, id);
        this.type = type;
        this.totalSlots = rows * columns;
        checkContainerSize(container, totalSlots);

        int containerIndex = 0;
        int q = containerX;
        int w = containerY;

        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                this.addSlot(new Slot(container, containerIndex++, q, w));
                q += 18;
            }
            q = containerX;
            w += 18;
        }
        this.addPlayerInventory(inventory, inventoryX, inventoryY);
    }

    private void addPlayerInventory(PlayerInventory inventory, int x, int y) {
        int index = 9;
        int q = x;
        for(int i = 1; i <= 3; i++) {
            for(int j = 1 ; j <= 9; j++) {
                this.addSlot(new Slot(inventory, index++, q, y));
                q += 18;
            }
            y += 18;
            q = x;
        }

        addPlayerHotbar(inventory, 0, x, y + 4);
    }

    private void addPlayerHotbar(PlayerInventory inventory, int index, int x, int y) {
        for(int i = 1; i <= 9; i++) {
            this.addSlot(new Slot(inventory, index++, x, y));
            x += 18;
        }
    }

    @Override
    public boolean stillValid(PlayerEntity p_75145_1_) {
        return true;
    }

    public ItemStack quickMoveStack(PlayerEntity player, int sourceSlot) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(sourceSlot);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (sourceSlot < totalSlots) {
                if (!this.moveItemStackTo(itemstack1, totalSlots, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, totalSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    public StorageContainers getContainerType() {
        return this.type;
    }

    public ResourceLocation getTexture() {
        return this.type.getTexture();
    }
}
