package net.praaly.habitats.setup;


import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.praaly.habitats.HabitatsMain;
import net.praaly.habitats.setup.entities.dumb_traders.DumbTradersEntity;

public class ModEntity {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, HabitatsMain.MOD_ID);
	
	public static final RegistryObject<EntityType<DumbTradersEntity>> DUMB_TRADER =
			ENTITY_TYPES.register("dumb_trader", () -> EntityType.Builder.<DumbTradersEntity>of(DumbTradersEntity::new,
					EntityClassification.CREATURE).sized(0.6f, 1.95f).build(new ResourceLocation(HabitatsMain.MOD_ID, "dumb_trader").toString()));

	public static final RegistryObject<EntityType<DumbTradersEntity>> GOOD_TRADER =
			ENTITY_TYPES.register("good_trader", () -> EntityType.Builder.<DumbTradersEntity>of(DumbTradersEntity::new,
					EntityClassification.CREATURE).sized(0.6f, 1.95f).build(new ResourceLocation(HabitatsMain.MOD_ID, "good_trader").toString()));

}
