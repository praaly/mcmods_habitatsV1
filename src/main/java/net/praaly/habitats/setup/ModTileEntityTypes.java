package net.praaly.habitats.setup;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.praaly.habitats.setup.blocks.Quarry.QuarryEntity;

import java.util.Arrays;
import java.util.function.Supplier;

public class ModTileEntityTypes {
    public static final RegistryObject<TileEntityType<QuarryEntity>> QUARRY = register(
            "quarry_block",
            QuarryEntity::new,
            ModBlocks.QUARRY
    );

    static void register() {}

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String name, Supplier<T> factory, RegistryObject<? extends Block> block) {
        return Registration.TILE_ENTITIES.register(name, () -> {
            //noinspection ConstantConditions - null in build
            return TileEntityType.Builder.of(factory, block.get()).build(null);
        });
    }
}
