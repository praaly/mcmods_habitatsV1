package net.silentchaos512.tutorial.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silentchaos512.tutorial.TutorialMod;
import net.silentchaos512.tutorial.setup.blocks.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.TEORITE_BLOCK.get());
        simpleBlock(ModBlocks.TEORITE_ORE.get());
        simpleBlock(ModBlocks.TITANIUM_ORE.get());

    }
}
