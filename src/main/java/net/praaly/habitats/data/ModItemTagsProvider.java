package net.praaly.habitats.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.praaly.habitats.HabitatsMain;
import net.praaly.habitats.setup.ModItems;
import net.praaly.habitats.setup.ModTags;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, HabitatsMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        /*----- Teorite -----*/
        copy(ModTags.Blocks.ORES_TEORITE, ModTags.Items.ORES_TEORITE);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);


        copy(ModTags.Blocks.STORAGE_BLOCKS_TEORITE, ModTags.Items.STORAGE_BLOCKS_TEORITE);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        tag(ModTags.Items.INGOTS_TEORITE).add(ModItems.TEORITE_INGOT.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_TEORITE);
        tag(ModTags.Items.SWORD_TEORITE).add(ModItems.TEORITE_SWORD.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.SWORD_TEORITE);

        tag(ModTags.Items.PICKAXE_TEORITE).add(ModItems.TEORITE_PICKAXE.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.PICKAXE_TEORITE);

        tag(ModTags.Items.AXE_TEORITE).add(ModItems.TEORITE_AXE.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.AXE_TEORITE);

        tag(ModTags.Items.SHOVEL_TEORITE).add(ModItems.TEORITE_SHOVEL.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.SHOVEL_TEORITE);

        tag(ModTags.Items.HOE_TEORITE).add(ModItems.TEORITE_HOE.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.HOE_TEORITE);


        /*----- Titanium ----*/
        copy(ModTags.Blocks.ORES_TITANIUM, ModTags.Items.ORES_TITANIUM);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);

        tag(ModTags.Items.SWORD_TITANIUM).add(ModItems.TITANIUM_SWORD.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.SWORD_TITANIUM);

        tag(ModTags.Items.INGOTS_TITANIUM).add(ModItems.TITANIUM_INGOT.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_TITANIUM);

        tag(ModTags.Items.PICKAXE_TITANIUM).add(ModItems.TITANIUM_PICKAXE.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.PICKAXE_TITANIUM);

        tag(ModTags.Items.AXE_TITANIUM).add(ModItems.TITANIUM_AXE.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.AXE_TITANIUM);

        tag(ModTags.Items.SHOVEL_TITANIUM).add(ModItems.TITANIUM_SHOVEL.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.SHOVEL_TITANIUM);

        tag(ModTags.Items.HOE_TITANIUM).add(ModItems.TITANIUM_HOE.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.HOE_TITANIUM);


    }
}
