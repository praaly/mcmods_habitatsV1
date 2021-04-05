package net.praaly.habitats.setup.entities.guard_traders;



import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class GuardTradersEntity extends AbstractGuard {
    public GuardTradersEntity(EntityType<? extends GuardTradersEntity> type, World worldIn) {
        super(type, worldIn);

        this.setDropChance(EquipmentSlotType.MAINHAND, 0);
        this.setDropChance(EquipmentSlotType.OFFHAND, 0);
        this.setDropChance(EquipmentSlotType.FEET, 0);
        this.setDropChance(EquipmentSlotType.LEGS, 0);
        this.setDropChance(EquipmentSlotType.CHEST, 0);
        this.setDropChance(EquipmentSlotType.HEAD, 0);

    }

}