package net.praaly.habitats.setup;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.praaly.habitats.setup.inventory.GenericStorageContainer;
import net.praaly.habitats.setup.inventory.StorageContainers;

public class ModContainerTypes {
    static void register() {}

    public static final RegistryObject<ContainerType<GenericStorageContainer>> KITCHEN_CABINET_CONTAINER =
            registerGenericContainer("kitchen_cabinet_container", StorageContainers.KITCHEN_CABINET, ModBlocks.KITCHEN_CABINET_TILE);

    /**
     * @param name non-localized name
     * @param containerType A type of {@link StorageContainers}
     * @param tile Associated tile entity type registry object
     * @return RegistryObject of container
     */
    private static <T extends TileEntity> RegistryObject<ContainerType<GenericStorageContainer>> registerGenericContainer(String name, StorageContainers containerType, RegistryObject<TileEntityType<T>> tile) {
        return Registration.CONTAINERS.register(name, () -> IForgeContainerType.create((windowId, inv, data) ->
                new GenericStorageContainer((IInventory) tile.get().create().getTileEntity(), inv, windowId, containerType))

        );
    }
}
