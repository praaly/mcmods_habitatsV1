package net.praaly.habitats.setup.items;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;

public class customShovel extends ShovelItem {

    public customShovel(IItemTier tier, int attackDamage, float attackSpeedIn, Properties builder) {
        super(tier, attackDamage, attackSpeedIn, builder);
    }
}
