package studio.axzet.exum.world.feature

import net.minecraft.block.Blocks
import net.minecraft.structure.rule.BlockMatchRuleTest
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.world.gen.feature.*
import studio.axzet.exum.Exum
import studio.axzet.exum.block.ExumBlocks


class ModConfiguredFeatures {
    companion object {

        private val OVERWORLD_INCANTATIO_ORES: List<OreFeatureConfig.Target> = listOf(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ExumBlocks.INCANTATIO_ORE.defaultState),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ExumBlocks.DEEPSLATE_INCANTATIO_ORE.defaultState)
        )

        private val NETHER_INCANTATIO_ORES: List<OreFeatureConfig.Target> = listOf(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, ExumBlocks.NETHERRACK_INCANTATIO_ORE.defaultState),
        )

        private val END_INCANTATIO_ORES: List<OreFeatureConfig.Target> = listOf(
            OreFeatureConfig.createTarget(BlockMatchRuleTest(Blocks.END_STONE), ExumBlocks.ENDSTONE_INCANTATIO_ORE.defaultState),
        )

        private val OVERWORLD_DEMON_DEBRIS_ORE: List<OreFeatureConfig.Target> = listOf(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ExumBlocks.DEMON_DEBRIS.defaultState)
        )

        val INCANTATIO_ORE: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>>? = ConfiguredFeatures.register(
            "incantatio_ore",
            Feature.ORE,
            OreFeatureConfig(OVERWORLD_INCANTATIO_ORES, 9)
        )

        val NETHER_INCANTATIO_ORE: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>>? = ConfiguredFeatures.register(
            "nether_incantatio_ore",
            Feature.ORE,
            OreFeatureConfig(NETHER_INCANTATIO_ORES,12)
        )

        val END_INCANTATIO_ORE: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>>? = ConfiguredFeatures.register(
            "end_incantatio_ore",
            Feature.ORE,
            OreFeatureConfig(END_INCANTATIO_ORES,12)
        )

        val DEMON_DEBRIS: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>>? = ConfiguredFeatures.register(
            "demon_debris_ore",
            Feature.ORE,
            OreFeatureConfig(OVERWORLD_DEMON_DEBRIS_ORE, 12)
        )



        fun registerConfiguredFeatures() {
            Exum.LOGGER.debug("Registering the ModConfiguredFeatures for ${Exum.MOD_ID}")
        }
    }
}