package net.praaly.habitats.setup.blocks.kitchen;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.praaly.habitats.setup.ModBlocks;
import net.praaly.habitats.setup.blocks.GenericContainerTile;
import net.praaly.habitats.setup.inventory.StorageContainers;

public class KitchenCabinetUpTile extends GenericContainerTile {
    public KitchenCabinetUpTile() {
        super(ModBlocks.KITCHEN_CABINET_UP_TILE.get(), StorageContainers.KITCHEN_CABINET_UP);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.habitats.kitchen_cabinet_up");
    }
}
