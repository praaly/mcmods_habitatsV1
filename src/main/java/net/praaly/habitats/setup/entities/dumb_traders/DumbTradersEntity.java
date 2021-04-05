package net.praaly.habitats.setup.entities.dumb_traders;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.praaly.habitats.setup.entities.ModVillagerTrades;


public class DumbTradersEntity extends AbstractDumb {
    public DumbTradersEntity(EntityType<? extends DumbTradersEntity> type, World worldIn) {
        super(type, worldIn);

        this.sells = new VillagerTrades.ITrade[]{
                // item, num emeralds to input, num items to output, max uses, priceMultiplierIn
                //new RubyVillagerTrades.ItemsForRubiesTrade(, 40, 1, 1, 1),
        };

        this.buys = new VillagerTrades.ITrade[]{
                // item, num items to input, num emeralds to output, max uses, ex given
                new ModVillagerTrades.ItemsForEmeraldsTrade(Items.WHEAT_SEEDS, 4, 1, 5, 5),
                new ModVillagerTrades.ItemsForEmeraldsTrade(Items.OBSIDIAN, 4, 1, 5, 5),
        };
    }

    public static AttributeModifierMap.MutableAttribute Attributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.7D);
    }
}