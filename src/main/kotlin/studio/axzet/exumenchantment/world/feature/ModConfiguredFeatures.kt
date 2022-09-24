package studio.axzet.exumenchantment.world.feature

import net.minecraft.block.Blocks
import net.minecraft.structure.rule.BlockMatchRuleTest
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.world.gen.feature.*
import studio.axzet.exumenchantment.ExumEnchantment
import studio.axzet.exumenchantment.block.ExumEnchantmentBlocks


class ModConfiguredFeatures {
    companion object {

        private val OVERWORLD_INCANTATIO_ORES: List<OreFeatureConfig.Target> = listOf(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ExumEnchantmentBlocks.INCANTATIO_ORE.defaultState),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ExumEnchantmentBlocks.DEEPSLATE_INCANTATIO_ORE.defaultState)
        )

        private val NETHER_INCANTATIO_ORES: List<OreFeatureConfig.Target> = listOf(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, ExumEnchantmentBlocks.NETHERRACK_INCANTATIO_ORE.defaultState),
        )

        private val END_INCANTATIO_ORES: List<OreFeatureConfig.Target> = listOf(
            OreFeatureConfig.createTarget(BlockMatchRuleTest(Blocks.END_STONE), ExumEnchantmentBlocks.ENDSTONE_INCANTATIO_ORE.defaultState),
        )

        private val OVERWORLD_DEMON_DEBRIS_ORE: List<OreFeatureConfig.Target> = listOf(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ExumEnchantmentBlocks.DEMON_DEBRIS.defaultState)
        )

        val INCANTATIO_ORE: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>>? = ConfiguredFeatures.register(
            "incantatio_ore",
            Feature.ORE,
            OreFeatureConfig(OVERWORLD_INCANTATIO_ORES, 3)
        )

        val NETHER_INCANTATIO_ORE: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>>? = ConfiguredFeatures.register(
            "nether_incantatio_ore",
            Feature.ORE,
            OreFeatureConfig(NETHER_INCANTATIO_ORES,3)
        )

        val END_INCANTATIO_ORE: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>>? = ConfiguredFeatures.register(
            "end_incantatio_ore",
            Feature.ORE,
            OreFeatureConfig(END_INCANTATIO_ORES,3)
        )

        val DEMON_DEBRIS: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>>? = ConfiguredFeatures.register(
            "demon_debris_ore",
            Feature.ORE,
            OreFeatureConfig(OVERWORLD_DEMON_DEBRIS_ORE, 1)
        )

        fun registerConfiguredFeatures() {
            ExumEnchantment.LOGGER.debug("Registering the ModConfiguredFeatures for ${ExumEnchantment.MOD_ID}")
        }
    }
}