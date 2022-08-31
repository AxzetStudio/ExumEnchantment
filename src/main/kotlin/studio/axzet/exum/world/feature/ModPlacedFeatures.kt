package studio.axzet.exum.world.feature

import net.minecraft.util.registry.RegistryEntry
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.feature.PlacedFeatures
import net.minecraft.world.gen.placementmodifier.*


class ModPlacedFeatures {
    companion object {

        val INCANTATIO_ORE_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
            "incantatio_ore_placed",
            ModConfiguredFeatures.INCANTATIO_ORE, modifiersWithCount(
                9,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))
            )
        )

        val DEMON_DEBRIS_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
            "demon_debris_placed",
            ModConfiguredFeatures.DEMON_DEBRIS, modifiersWithCount(
                5,
                HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))
            )

        )

        val NETHER_INCANTATIO_ORE_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
            "nether_incantatio_ore_placed",
            ModConfiguredFeatures.NETHER_INCANTATIO_ORE, modifiersWithCount(
                10,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))
            )
        )

        val END_INCANTATIO_ORE_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
            "end_incantatio_ore_placed",
            ModConfiguredFeatures.END_INCANTATIO_ORE, modifiersWithCount(
                10,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))
            )
        )

        private fun modifiersWithCount(count: Int, heightModifier: PlacementModifier): List<PlacementModifier>? {
            return modifiers(CountPlacementModifier.of(count), heightModifier)
        }

        private fun modifiersWithRarity(chance: Int, heightModifier: PlacementModifier): List<PlacementModifier>? {
            return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier)
        }

        private fun modifiers(countModifier: PlacementModifier, heightModifier: PlacementModifier): List<PlacementModifier>? {
            return listOf(
                countModifier,
                SquarePlacementModifier.of(),
                heightModifier,
                BiomePlacementModifier.of()
            )
        }
    }
}