package net.praaly.habitats.setup;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.praaly.habitats.HabitatsMain;
import net.praaly.habitats.setup.items.*;



public class ModItems {
    /*----------------------------   Equipments   ------------------------------*/
    /*----------------------------     TEORITE    ------------------------------*/
    public static final RegistryObject<Item> TEORITE_INGOT = Registration.ITEMS.register("teorite_ingot", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    /* titanium_ingot */
        public static final RegistryObject<Item> TITANIUM_INGOT = Registration.ITEMS.register("titanium_ingot", () ->
                new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    /* teorite_sword */
        public static final RegistryObject<SwordItem> TEORITE_SWORD = Registration.ITEMS.register("teorite_sword", () ->
                new SwordItem(ItemTier.STONE, 3, -2.4f, (new Item.Properties().tab(HabitatsMain.TAB_EQUIP_HABITAT))));
    /* teorite_pickaxe */
        public static final RegistryObject<PickaxeItem> TEORITE_PICKAXE = Registration.ITEMS.register("teorite_pickaxe", () ->
                new customPickaxe(ToolMaterialList.teorite_pickaxe, 0, 0f, (new Item.Properties().tab(HabitatsMain.TAB_EQUIP_HABITAT))));
    /* teorite_pickaxe */
    public static final RegistryObject<AxeItem> TEORITE_AXE = Registration.ITEMS.register("teorite_axe", () ->
            new customAxe(ToolMaterialList.teorite_axe, 9, -3.1f, (new Item.Properties().tab(HabitatsMain.TAB_EQUIP_HABITAT))));
    /* teorite_shovel */
    public static final RegistryObject<ShovelItem> TEORITE_SHOVEL = Registration.ITEMS.register("teorite_shovel", () ->
            new customShovel(ToolMaterialList.teorite_shovel, 0, -0.2f, (new Item.Properties().tab(HabitatsMain.TAB_EQUIP_HABITAT))));
    /* teorite_hoe */
    public static final RegistryObject<HoeItem> TEORITE_HOE = Registration.ITEMS.register("teorite_hoe", () ->
            new customHoe(ToolMaterialList.teorite_hoe, 0, -0.2f, (new Item.Properties().tab(HabitatsMain.TAB_EQUIP_HABITAT))));



    /*----------------------------   Equipments   ------------------------------*/
     /*----------------------------     TITANIUM    ------------------------------*/
    public static final RegistryObject<SwordItem> TITANIUM_SWORD = Registration.ITEMS.register("titanium_sword", () ->
            new SwordItem(ItemTier.IRON, 7, -2.4F, (new Item.Properties().tab(ItemGroup.TAB_COMBAT))));

    // public static final RegistryObject<ArmorItem> TITANIUM_HELMET = Registration.ITEMS.register("titanium_sword", () ->
    //new ArmorItem(new ArmorMaterial("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, Ingredient.of(Items.NETHERITE_INGOT)),EquipmentSlotType.HEAD, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT).));


    static void register() {}
}
