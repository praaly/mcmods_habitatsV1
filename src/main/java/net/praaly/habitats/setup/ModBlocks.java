package net.praaly.habitats.setup;


import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.praaly.habitats.setup.blocks.kitchen.*;
import net.praaly.habitats.setup.blocks.Quarry.Quarry;
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

    /* quarry_block*/
    public static final RegistryObject<Quarry> QUARRY = register("quarry_block", () ->
            new Quarry(AbstractBlock.Properties.of(Material.METAL)
                    .strength(4, 20)
                    .sound(SoundType.METAL)));
    /* ------------------------------------------------------ */
    /* kitchen_border*/
    public static final RegistryObject<Block> KITCHEN_BORDER = register("kitchen_border", () ->
            new KitchenBorder(AbstractBlock.Properties.of(Material.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3, 10)
                    .sound(SoundType.METAL)));
    /* ------------------------------------------------------ */
    /* kitchen_cabinet*/
    public static final RegistryObject<Block> KITCHEN_CABINET = register("kitchen_cabinet", () ->
            new KitchenCabinet(AbstractBlock.Properties.of(Material.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3, 10)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<TileEntityType<KitchenCabinetTile>> KITCHEN_CABINET_TILE =
            registerTile("kitchen_cabinet_tile", KitchenCabinetTile::new , KITCHEN_CABINET);
    /* ------------------------------------------------------ */
    /* kitchen_cabinet_up*/
    public static final RegistryObject<Block> KITCHEN_CABINET_UP = register("kitchen_cabinet_up", () ->
            new KitchenCabinetUp(AbstractBlock.Properties.of(Material.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3, 10)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<TileEntityType<KitchenCabinetUpTile>> KITCHEN_CABINET_UP_TILE =
            registerTile("kitchen_cabinet_up_tile", KitchenCabinetUpTile::new , KITCHEN_CABINET_UP);
    /* ------------------------------------------------------ */
    /* kitchen_trash*/
    public static final RegistryObject<Block> KITCHEN_TRASH = register("kitchen_trash", () ->
            new KitchenTrash(AbstractBlock.Properties.of(Material.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3, 10)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<TileEntityType<KitchenTrashTile>> KITCHEN_TRASH_TILE =
            registerTile("kitchen_trash_tile", KitchenTrashTile::new , KITCHEN_TRASH);
    /* ------------------------------------------------------ */

    /* kitchen_fridge*/
    public static final RegistryObject<Block> KITCHEN_FRIDGE = register("kitchen_fridge", () ->
            new KitchenFridge(AbstractBlock.Properties.of(Material.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3, 10)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<TileEntityType<KitchenFridgeTile>> KITCHEN_FRIDGE_TILE =
            registerTile("kitchen_fridge_tile", KitchenFridgeTile::new , KITCHEN_FRIDGE);
    /* ------------------------------------------------------ */

    public static final RegistryObject<Block> KITCHEN_COOK = register("kitchen_cook", () ->
            new KitchenCook(AbstractBlock.Properties.of(Material.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3, 10)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<Block> KITCHEN_SINK = register("kitchen_sink", () ->
            new KitchenSink(AbstractBlock.Properties.of(Material.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3, 10)
                    .sound(SoundType.METAL)));
    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> registerTile(String name, Supplier<T> tile, RegistryObject<Block> block) {
        return Registration.TILE_ENTITIES.register(name, () -> TileEntityType.Builder.of(tile, block.get()).build(null));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(InventoryCreative.TAB_DECO_HABITAT)));
        return ret;
    }


}

