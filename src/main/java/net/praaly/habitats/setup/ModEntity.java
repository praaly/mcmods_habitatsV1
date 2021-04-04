package net.praaly.habitats.setup;


import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.praaly.habitats.HabitatsMain;
import net.praaly.habitats.setup.entities.dumb_marchants.DumbMarchantEntity;

public class ModEntity {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, HabitatsMain.MOD_ID);
	
	public static final RegistryObject<EntityType<DumbMarchantEntity>> WANDERING_FLORIST =
			ENTITY_TYPES.register("wandering_florist", () -> EntityType.Builder.<DumbMarchantEntity>of(DumbMarchantEntity::new,
					EntityClassification.CREATURE).sized(0.6f, 1.95f).build(new ResourceLocation(HabitatsMain.MOD_ID, "wandering_florist").toString()));
}
