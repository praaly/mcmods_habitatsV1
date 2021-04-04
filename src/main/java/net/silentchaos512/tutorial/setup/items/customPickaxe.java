package net.silentchaos512.tutorial.setup.items;
import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class customPickaxe extends PickaxeItem {

    public customPickaxe(IItemTier tier, int attackDamage, float attackSpeedIn, Properties builder) {
        super(tier, attackDamage, attackSpeedIn, builder);
    }
}
