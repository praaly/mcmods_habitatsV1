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
    public static final RegistryObject<ContainerType<GenericStorageContainer>> KITCHEN_CABINET_CONTAINER =
            registerGenericContainer("kitchen_cabinet_container", StorageContainers.KITCHEN_CABINET, ModBlocks.KITCHEN_CABINET_TILE);

    public static final RegistryObject<ContainerType<GenericStorageContainer>> KITCHEN_CABINET_UP_CONTAINER =
            registerGenericContainer("kitchen_cabinet_up_container", StorageContainers.KITCHEN_CABINET_UP, ModBlocks.KITCHEN_CABINET_UP_TILE);

    public static final RegistryObject<ContainerType<GenericStorageContainer>> KITCHEN_TRASH_CONTAINER =
            registerGenericContainer("kitchen_trash_container", StorageContainers.KITCHEN_TRASH, ModBlocks.KITCHEN_TRASH_TILE);

    private static <T extends TileEntity> RegistryObject<ContainerType<GenericStorageContainer>> registerGenericContainer(String name, StorageContainers containerType, RegistryObject<TileEntityType<T>> tile) {
        return Registration.CONTAINERS.register(name, () -> IForgeContainerType.create((windowId, inv, data) ->
                new GenericStorageContainer((IInventory) tile.get().create().getTileEntity(), inv, windowId, containerType))

        );
    }

    static void register() {}
}
