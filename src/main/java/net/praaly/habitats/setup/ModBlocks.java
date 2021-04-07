package net.praaly.habitats.setup;


import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.praaly.habitats.setup.blocks.KitchenCabinet;
import net.praaly.habitats.setup.blocks.KitchenCabinetTile;

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
    public static final RegistryObject<Block> KITCHEN_CABINET = register("kitchen_cabinet", () ->
            new KitchenCabinet(AbstractBlock.Properties.of(Material.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3, 10)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<TileEntityType<KitchenCabinetTile>> KITCHEN_CABINET_TILE =
            registerTile("kitchen_cabinet_tile", KitchenCabinetTile::new, KITCHEN_CABINET);


    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
        return ret;
    }

    /**
     * @param name non-localized name
     * @param tile Supplier for tile, see KITCHEN_CHEST_TILE
     * @param block Associated Block registry object
     * @param <T> Class of tile entity. You may not have to explicitly state it
     * @return RegistryObject of the tile entity
     */
    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> registerTile(String name, Supplier<T> tile, RegistryObject<Block> block) {
        return Registration.TILE_ENTITIES.register(name, () -> TileEntityType.Builder.of(tile, block.get()).build(null));
    }


}

