package net.silentchaos512.tutorial.setup;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> TEORITE_INGOT = Registration.ITEMS.register("teorite_ingot", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    public static final RegistryObject<Item> TITANIUM_INGOT = Registration.ITEMS.register("titanium_ingot", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    public static final RegistryObject<SwordItem> TEORITE_SWORD = Registration.ITEMS.register("teorite_sword", () ->
            new SwordItem(ItemTier.IRON, 3, -2.4F, (new Item.Properties().tab(ItemGroup.TAB_COMBAT))));

    public static final RegistryObject<SwordItem> TITANIUM_SWORD = Registration.ITEMS.register("titanium_sword", () ->
            new SwordItem(ItemTier.IRON, 7, -2.4F, (new Item.Properties().tab(ItemGroup.TAB_COMBAT))));

    static void register() {}
}
