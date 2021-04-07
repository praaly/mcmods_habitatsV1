package net.praaly.habitats.setup;


import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.praaly.habitats.setup.blocks.Quarry.Quarry;
import net.praaly.habitats.setup.blocks.kitchenBorder;
import net.praaly.habitats.setup.blocks.kitchenChest;
import net.praaly.habitats.setup.inventory.InventoryCreative;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> TEORITE_ORE = register("teorite_ore", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3, 3)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    //new
    public static final RegistryObject<Block> TITANIUM_ORE = register("titanium_ore", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(15, 500)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> TEORITE_BLOCK = register("teorite_block", () ->
            new Block(AbstractBlock.Properties.of(Material.METAL)
                    .strength(3, 10)
                    .sound(SoundType.METAL)));

    /* CUSOTM BLOCKS*/
    public static final RegistryObject<Block> KITCHEN_CHEST = register("kitchen_cabinet", () ->
            new kitchenChest(AbstractBlock.Properties.of(Material.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3, 10)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<Block> KITCHEN_BORDER = register("kitchen_border", () ->
            new kitchenBorder(AbstractBlock.Properties.of(Material.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3, 10)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<Quarry> QUARRY = register("quarry_block", () ->
            new Quarry(AbstractBlock.Properties.of(Material.METAL)
                    .strength(4, 20)
                    .sound(SoundType.METAL)));

    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(InventoryCreative.TAB_DECO_HABITAT)));
        return ret;
    }


}

