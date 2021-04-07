package net.praaly.habitats.setup;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.praaly.habitats.HabitatsMain;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES_TEORITE = forge("ores/teorite_ore");
        public static final ITag.INamedTag<Block> ORES_TITANIUM = forge("ores/titanium_ore");

        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_TEORITE = forge("storage_blocks/teorite_block");

        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_KITCHEN_CABINET = forge("chests/kitchen_cabinet");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(HabitatsMain.MOD_ID, path).toString());
        }
    }

    public static final class Items {
        /*----------------------------   Ores   ------------------------------*/
        public static final ITag.INamedTag<Item> ORES_TEORITE = forge("ores/teorite_ore");
        public static final ITag.INamedTag<Item> ORES_TITANIUM = forge("ores/titanium_ore");

        /*----------------------------   Storage_blocks   ------------------------------*/
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_TEORITE = forge("storage_blocks/teorite_block");
         /*----------------------------   Ingots  ------------------------------*/
        public static final ITag.INamedTag<Item> INGOTS_TEORITE = forge("ingots/teorite_ingot");
        public static final ITag.INamedTag<Item> INGOTS_TITANIUM = forge("ingots/titanium_ingot");

        /*----------------------------   Equipments   ------------------------------*/
        /*--- Teorite ---*/
        public static final ITag.INamedTag<Item> SWORD_TEORITE = forge("equipment/teorite_sword");
        public static final ITag.INamedTag<Item> PICKAXE_TEORITE = forge("equipment/teorite_pickaxe");
        public static final ITag.INamedTag<Item> AXE_TEORITE = forge("equipment/teorite_axe");
        public static final ITag.INamedTag<Item> SHOVEL_TEORITE = forge("equipment/teorite_shovel");
        public static final ITag.INamedTag<Item> HOE_TEORITE = forge("equipment/teorite_hoe");

        /*--- Titanium ---*/
        public static final ITag.INamedTag<Item> SWORD_TITANIUM = forge("equipment/titanium_sword");
        public static final ITag.INamedTag<Item> PICKAXE_TITANIUM = forge("equipment/titanium_pickaxe");
        public static final ITag.INamedTag<Item> AXE_TITANIUM = forge("equipment/titanium_axe");
        public static final ITag.INamedTag<Item> SHOVEL_TITANIUM = forge("equipment/titanium_shovel");
        public static final ITag.INamedTag<Item> HOE_TITANIUM = forge("equipment/titanium_hoe");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(HabitatsMain.MOD_ID, path).toString());
        }
    }
}
