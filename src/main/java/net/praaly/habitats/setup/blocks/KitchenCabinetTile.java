package net.praaly.habitats.setup.blocks;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.praaly.habitats.setup.ModBlocks;
import net.praaly.habitats.setup.inventory.StorageContainers;

public class KitchenCabinetTile extends GenericContainerTile{
    public KitchenCabinetTile() {
        super(ModBlocks.KITCHEN_CABINET_TILE.get(), StorageContainers.KITCHEN_CABINET);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.habitats.kitchen_cabinet");
    }
}
