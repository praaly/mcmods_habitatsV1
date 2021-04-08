package net.praaly.habitats.setup.inventory;

import net.minecraft.util.ResourceLocation;
import net.praaly.habitats.HabitatsMain;

public enum StorageContainers {
    KITCHEN_CABINET(2, 2, 74, 20, 8, 85,
            new ResourceLocation(HabitatsMain.MOD_ID, "textures/gui/kitchen_cabinet_gui.png")),
    KITCHEN_CABINET_UP(2, 2, 74, 20, 8, 85,
                            new ResourceLocation(HabitatsMain.MOD_ID, "textures/gui/kitchen_cabinet_gui.png")),
    KITCHEN_TRASH(1, 1, 74, 20, 8, 85,
            new ResourceLocation(HabitatsMain.MOD_ID, "textures/gui/kitchen_trash_gui.png"));
    private final int rows;
    private final int columns;
    private final int containerX;
    private final int containerY;
    private final int inventoryX;
    private final int inventoryY;
    private final ResourceLocation texture;
    StorageContainers(int rows, int columns, int containerX, int containerY, int inventoryX, int inventoryY, ResourceLocation texture) {
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
