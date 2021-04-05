package net.praaly.habitats.setup.items.equipments;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;

public class customHoe extends HoeItem {

    public customHoe(IItemTier tier, int attackDamage, float attackSpeedIn, Properties builder) {
        super(tier, attackDamage, attackSpeedIn, builder);
    }
}
