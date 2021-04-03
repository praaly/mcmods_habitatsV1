package net.silentchaos512.tutorial.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silentchaos512.tutorial.TutorialMod;
import net.silentchaos512.tutorial.setup.ModBlocks;
import net.silentchaos512.tutorial.setup.ModTags;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.ORES_TEORITE).add(ModBlocks.TEORITE_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_TEORITE);

        tag(ModTags.Blocks.ORES_TITANIUM).add(ModBlocks.TEORITE_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_TEORITE);


        tag(ModTags.Blocks.STORAGE_BLOCKS_TEORITE).add(ModBlocks.TEORITE_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_TEORITE);
    }
}
