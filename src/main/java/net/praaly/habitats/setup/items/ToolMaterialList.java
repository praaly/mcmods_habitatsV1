package net.praaly.habitats.setup.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier {

    /*----------------------------   Equipments   ------------------------------*/
    /*----------------------------     TEORITE    ------------------------------*/
    teorite_pickaxe(155, 5.0f, 0, 1,1),
    teorite_axe(155, 5.0f, 0, 1,1),
    teorite_shovel(155, 5.0f, 0, 1,1),
    teorite_hoe(155, 5.0f, 0, 1,1),
    TITANIUM(2250, 12.0F, 4.0F, 4,22);

    private float speed, attackDamageBonus;
    private int uses, level, enchantmentValue;

    private ToolMaterialList(int uses, float speed, float attackDamageBonus, int level, int enchantmentValue)
    {
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.level = level;
        this.enchantmentValue = enchantmentValue;

    }

    @Override
    public int getUses() {
        return this.uses = uses;
    }

    @Override
    public float getSpeed() {
        return this.speed = speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

}
