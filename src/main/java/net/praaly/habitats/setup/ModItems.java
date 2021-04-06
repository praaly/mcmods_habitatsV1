package net.praaly.habitats.setup;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.praaly.habitats.setup.inventory.InventoryCreative;
import net.praaly.habitats.setup.items.*;
import net.praaly.habitats.setup.items.equipments.customAxe;
import net.praaly.habitats.setup.items.equipments.customHoe;
import net.praaly.habitats.setup.items.equipments.customPickaxe;
import net.praaly.habitats.setup.items.equipments.customShovel;


public class ModItems {
    /*----------------------------   Equipments   ------------------------------*/
    /*----------------------------     TEORITE    ------------------------------*/
    public static final RegistryObject<Item> TEORITE_INGOT = Registration.ITEMS.register("teorite_ingot", () ->
            new Item(new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT)));
    /* teorite_sword */
    public static final RegistryObject<SwordItem> TEORITE_SWORD = Registration.ITEMS.register("teorite_sword", () ->
            new SwordItem(ItemTier.STONE, 3, -2.4f, (new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT))));
    /* teorite_pickaxe */
    public static final RegistryObject<PickaxeItem> TEORITE_PICKAXE = Registration.ITEMS.register("teorite_pickaxe", () ->
            new customPickaxe(ToolMaterialList.TEORITE, 0, 0f, (new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT))));
    /* teorite_pickaxe */
    public static final RegistryObject<AxeItem> TEORITE_AXE = Registration.ITEMS.register("teorite_axe", () ->
            new customAxe(ToolMaterialList.TEORITE, 9, -3.1f, (new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT))));
    /* teorite_shovel */
    public static final RegistryObject<ShovelItem> TEORITE_SHOVEL = Registration.ITEMS.register("teorite_shovel", () ->
            new customShovel(ToolMaterialList.TEORITE, 0, -0.2f, (new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT))));
    /* teorite_hoe */
    public static final RegistryObject<HoeItem> TEORITE_HOE = Registration.ITEMS.register("teorite_hoe", () ->
            new customHoe(ToolMaterialList.TEORITE, 0, -0.2f, (new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT))));

    public static final RegistryObject<ModSpawnEgg> WANDERING_FLORIST_SPAWN_EGG = Registration.ITEMS.register("dumb_trader_spawn_egg", () ->
            new ModSpawnEgg(ModEntity.DUMB_TRADER, 0x2FFF00, 15377456, new Item.Properties().tab(InventoryCreative.TAB_RESSOURCES_HABITAT)));

    public static final RegistryObject<ModSpawnEgg> GOOD_TRADER_SPAWN_EGG = Registration.ITEMS.register("guard_trader_spawn_egg", () ->
            new ModSpawnEgg(ModEntity.GUARD_TRADER, 0x2FFF00, 15377456, new Item.Properties().tab(InventoryCreative.TAB_RESSOURCES_HABITAT)));


    /*----------------------------   Equipments   ------------------------------*/
    /*----------------------------     TITANIUM    ------------------------------*/

    /* titanium_ingot */
    public static final RegistryObject<Item> TITANIUM_INGOT = Registration.ITEMS.register("titanium_ingot", () ->
            new Item(new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT)));

    /* titanium_sword */
    public static final RegistryObject<SwordItem> TITANIUM_SWORD = Registration.ITEMS.register("titanium_sword", () ->
            new SwordItem(ItemTier.NETHERITE, 7, -2.4F, (new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT))));

    public static final RegistryObject<PickaxeItem> TITANIUM_PICKAXE = Registration.ITEMS.register("titanium_pickaxe", () ->
            new customPickaxe(ToolMaterialList.TITANIUM, 3, 0f, (new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT))));

    /* titanium_pickaxe */
    public static final RegistryObject<AxeItem> TITANIUM_AXE = Registration.ITEMS.register("titanium_axe", () ->
            new customAxe(ToolMaterialList.TITANIUM, 6, -3.1f, (new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT))));

    /* titanium_shovel */
    public static final RegistryObject<ShovelItem> TITANIUM_SHOVEL = Registration.ITEMS.register("titanium_shovel", () ->
            new customShovel(ToolMaterialList.TITANIUM, 2, -0.2f, (new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT))));

    /* titanium_hoe */
    public static final RegistryObject<HoeItem> TITANIUM_HOE = Registration.ITEMS.register("titanium_hoe", () ->
            new customHoe(ToolMaterialList.TITANIUM, 2, -0.2f, (new Item.Properties().tab(InventoryCreative.TAB_EQUIP_HABITAT))));

    // public static final RegistryObject<ArmorItem> TITANIUM_HELMET = Registration.ITEMS.register("titanium_sword", () ->
    //new ArmorItem(new ArmorMaterial("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, Ingredient.of(Items.NETHERITE_INGOT)),EquipmentSlotType.HEAD, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT).));


    static void register() {}
}
