package net.praaly.habitats.setup.items;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;

public class customAxe extends AxeItem {

    public customAxe(IItemTier tier, int attackDamage, float attackSpeedIn, Properties builder) {
        super(tier, attackDamage, attackSpeedIn, builder);
    }
}
