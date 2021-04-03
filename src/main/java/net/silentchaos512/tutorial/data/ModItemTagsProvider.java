package net.silentchaos512.tutorial.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silentchaos512.tutorial.TutorialMod;
import net.silentchaos512.tutorial.setup.ModItems;
import net.silentchaos512.tutorial.setup.ModTags;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        copy(ModTags.Blocks.ORES_TEORITE, ModTags.Items.ORES_TEORITE);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_TEORITE, ModTags.Items.STORAGE_BLOCKS_TEORITE);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);



        tag(ModTags.Items.INGOTS_TEORITE).add(ModItems.TEORITE_INGOT.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_TEORITE);
    }
}
