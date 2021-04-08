package net.praaly.habitats.setup.inventory;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.praaly.habitats.HabitatsMain;
import net.praaly.habitats.setup.ModContainerTypes;

import java.util.function.Supplier;

public enum StorageContainers {
    KITCHEN_CABINET(() -> ModContainerTypes.KITCHEN_CABINET_CONTAINER, 2, 2, 74, 20, 8, 85,
            new ResourceLocation(HabitatsMain.MOD_ID, "textures/gui/kitchen_cabinet_gui.png")),
    KITCHEN_CABINET_UP(() -> ModContainerTypes.KITCHEN_CABINET_UP_CONTAINER, 2, 2, 74, 20, 8, 85,
            new ResourceLocation(HabitatsMain.MOD_ID, "textures/gui/kitchen_cabinet_gui.png")),
    KITCHEN_TRASH(() -> ModContainerTypes.KITCHEN_TRASH_CONTAINER, 1, 1, 74, 20, 8, 85,
            new ResourceLocation(HabitatsMain.MOD_ID, "textures/gui/kitchen_trash_gui.png"));

    public final Supplier<RegistryObject<ContainerType<GenericStorageContainer>>> containerType;
    private final int rows;
    private final int columns;
    private final int containerX;
    private final int containerY;
    private final int inventoryX;
    private final int inventoryY;
    private final ResourceLocation texture;
    StorageContainers(Supplier<RegistryObject<ContainerType<GenericStorageContainer>>> containerType, int rows, int columns, int containerX, int containerY, int inventoryX, int inventoryY, ResourceLocation texture) {
        this.containerType = containerType;
        this.rows = rows;
        this.columns = columns;
        this.containerX = containerX;
        this.containerY = containerY;
        this.inventoryX = inventoryX;
        this.inventoryY = inventoryY;
        this.texture = texture;
    }

    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
    public int getConX() {
        return containerX;
    }
    public int getConY() {
        return containerY;
    }
    public int getInvX() {
        return inventoryX;
    }
    public int getInvY() {
        return inventoryY;
    }
    public ResourceLocation getTexture() {
        return texture;
    }
}
