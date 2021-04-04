package net.praaly.habitats.data.world;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.praaly.habitats.HabitatsMain;

public class STConfiguredStructures {

    public static StructureFeature<?, ?> CONFIGURED_RUN_DOWN_HOUSE = STStructures.RUN_DOWN_HOUSE.get().configured(IFeatureConfig.NONE);
    public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(HabitatsMain.MOD_ID, "configured_run_down_house"), CONFIGURED_RUN_DOWN_HOUSE);

        FlatGenerationSettings.STRUCTURE_FEATURES.put(STStructures.RUN_DOWN_HOUSE.get(), CONFIGURED_RUN_DOWN_HOUSE);
    }
}