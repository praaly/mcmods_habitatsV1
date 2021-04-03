package net.silentchaos512.tutorial.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> TEORITE_INGOT = Registration.ITEMS.register("teorite_ingot", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    public static final RegistryObject<Item> TEORITE_SWORD = Registration.ITEMS.register("teorite_swords", () ->
            new SwordItem(ItemTier.IRON, 3, -2.4F, (new Item.Properties().tab(ItemGroup.TAB_COMBAT))));

    static void register() {}
}
