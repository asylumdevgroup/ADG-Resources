package asylumdev.adgresources.world;

import asylumdev.adgresources.block.ModBlocks;
import asylumdev.adgresources.config.OregenConfig;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
	public static void setupOreGeneration() {
		for(Biome biome: ForgeRegistries.BIOMES) {
			if (OregenConfig.generate_advancium.get()) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, ModBlocks.advancium_ore.getDefaultState(), OregenConfig.advancium_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 70)));
			}
			if (OregenConfig.generate_copper.get()) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, ModBlocks.copper_ore.getDefaultState(), OregenConfig.copper_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 40, 0, 80)));
			}
			if (OregenConfig.generate_tin.get()) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, ModBlocks.tin_ore.getDefaultState(), OregenConfig.tin_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 70)));
			}
			if (OregenConfig.generate_aluminum.get()) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, ModBlocks.aluminum_ore.getDefaultState(), OregenConfig.aluminum_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 40, 0, 80)));
			}
			if (OregenConfig.generate_lead.get()) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, ModBlocks.lead_ore.getDefaultState(), OregenConfig.lead_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 40)));
			}
			if (OregenConfig.generate_silver.get()) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, ModBlocks.silver_ore.getDefaultState(), OregenConfig.silver_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 40)));
			}
		}
	}
}