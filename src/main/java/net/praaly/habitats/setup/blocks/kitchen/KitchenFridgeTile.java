package net.praaly.habitats.setup.blocks.kitchen;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.praaly.habitats.setup.ModBlocks;
import net.praaly.habitats.setup.blocks.GenericContainerTile;
import net.praaly.habitats.setup.inventory.StorageContainers;

public class KitchenFridgeTile extends GenericContainerTile {
    public KitchenFridgeTile() {
        super(ModBlocks.KITCHEN_TRASH_TILE.get(), StorageContainers.KITCHEN_TRASH);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.habitats.kitchen_fridge");
    }
}
