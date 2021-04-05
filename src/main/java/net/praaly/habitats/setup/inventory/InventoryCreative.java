package net.praaly.habitats.setup.inventory;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.praaly.habitats.setup.ModItems;

public class InventoryCreative {
    public static final ItemGroup TAB_DECO_HABITAT = new ItemGroup( "decoratives") {
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(Items.OAK_DOOR);
        }
    };
    public static final ItemGroup TAB_EQUIP_HABITAT = new ItemGroup( "tools") {
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TITANIUM_SWORD.get());
        }
    };
    public static final ItemGroup TAB_OTHERS_HABITAT = new ItemGroup( "others") {
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(Items.OAK_BUTTON);
        }
    };
}
