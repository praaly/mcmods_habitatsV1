package net.silentchaos512.tutorial.setup.items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;
import net.silentchaos512.tutorial.setup.Registration;

public class ModItems {
    public static final RegistryObject<Item> TEORITE_INGOT = Registration.ITEMS.register("teorite_ingot", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    public static final RegistryObject<Item> TITANIUM_INGOT = Registration.ITEMS.register("titanium_ingot", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    public static final RegistryObject<SwordItem> TEORITE_SWORD = Registration.ITEMS.register("teorite_sword", () ->
            new SwordItem(ItemTier.IRON, 3, -2.4F, (new Item.Properties().tab(ItemGroup.TAB_COMBAT))));

    public static final RegistryObject<SwordItem> TITANIUM_SWORD = Registration.ITEMS.register("titanium_sword", () ->
            new SwordItem(ItemTier.IRON, 7, -2.4F, (new Item.Properties().tab(ItemGroup.TAB_COMBAT))));

   // public static final RegistryObject<ArmorItem> TITANIUM_HELMET = Registration.ITEMS.register("titanium_sword", () ->
            //new ArmorItem(new ArmorMaterial("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, Ingredient.of(Items.NETHERITE_INGOT)),EquipmentSlotType.HEAD, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT).));
    static void register() {}
}
