package net.silentchaos512.tutorial.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> TEORITE_INGOT = Registration.ITEMS.register("teorite_ingot", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    static void register() {}
}
