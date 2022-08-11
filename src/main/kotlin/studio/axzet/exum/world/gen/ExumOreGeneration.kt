package studio.axzet.exum.world.gen

import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.world.gen.GenerationStep
import studio.axzet.exum.world.feature.ModPlacedFeatures

class ExumOreGeneration {
    companion object {
        fun generateOres() {
            BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.INCANTATIO_ORE_PLACED.key.get()
            )

            BiomeModifications.addFeature(
                BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.NETHER_INCANTATIO_ORE_PLACED.key.get()
            )

            BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.END_INCANTATIO_ORE_PLACED.key.get()
            )
        }
    }
}