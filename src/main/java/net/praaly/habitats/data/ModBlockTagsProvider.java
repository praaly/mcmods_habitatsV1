package net.praaly.habitats.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.praaly.habitats.HabitatsMain;
import net.praaly.habitats.setup.ModBlocks;
import net.praaly.habitats.setup.ModTags;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, HabitatsMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.ORES_TEORITE).add(ModBlocks.TEORITE_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_TEORITE);

        tag(ModTags.Blocks.ORES_TITANIUM).add(ModBlocks.TEORITE_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_TEORITE);

        tag(ModTags.Blocks.STORAGE_BLOCKS_TEORITE).add(ModBlocks.TEORITE_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_TEORITE);

        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_BORDER).add(ModBlocks.KITCHEN_BORDER.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_BORDER).addTag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_BORDER);

        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_CABINET).add(ModBlocks.KITCHEN_CABINET.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_CABINET).addTag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_CABINET);

        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_CABINET_UP).add(ModBlocks.KITCHEN_CABINET_UP.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_CABINET_UP).addTag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_CABINET_UP);

        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_COOK).add(ModBlocks.KITCHEN_COOK.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_COOK).addTag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_COOK);

        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_SINK).add(ModBlocks.KITCHEN_SINK.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_SINK).addTag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_SINK);

        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_TRASH).add(ModBlocks.KITCHEN_TRASH.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_TRASH).addTag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_TRASH);

        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_FRIDGE).add(ModBlocks.KITCHEN_FRIDGE.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_FRIDGE).addTag(ModTags.Blocks.STORAGE_BLOCKS_KITCHEN_FRIDGE);



        tag(ModTags.Blocks.QUARRY_BLOCK).add(ModBlocks.QUARRY.get());
        tag(Tags.Blocks.CHESTS).addTag(ModTags.Blocks.QUARRY_BLOCK);



    }



}
