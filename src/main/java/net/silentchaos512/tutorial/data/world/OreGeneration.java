package net.silentchaos512.tutorial.data.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {
    public static void generateOres (final BiomeLoadingEvent event) {
        if (!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND))){
            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize)).withPlacement(
                            Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0,  maxHeight)))
                            .square().func_242731_n(0));
        }
    }
}
