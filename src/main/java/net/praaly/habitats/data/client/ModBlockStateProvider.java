package net.praaly.habitats.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.praaly.habitats.HabitatsMain;
import net.praaly.habitats.setup.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, HabitatsMain.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.TEORITE_BLOCK.get());
        simpleBlock(ModBlocks.TEORITE_ORE.get());
        simpleBlock(ModBlocks.TITANIUM_ORE.get());
        simpleBlock(ModBlocks.KITCHEN_CABINET.get());
    }
}
