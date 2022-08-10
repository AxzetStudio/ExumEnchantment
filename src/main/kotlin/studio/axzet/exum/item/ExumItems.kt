package studio.axzet.exum.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.AliasedBlockItem
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import studio.axzet.exum.Exum
import studio.axzet.exum.block.ExumBlocks
import studio.axzet.exum.item.custom.AncientWand
import studio.axzet.exum.item.custom.Incantatio
import studio.axzet.exum.item.custom.ObsidianStick
import studio.axzet.exum.item.custom.RawIncantatio

class ExumItems {

    companion object {

        val RAW_INCANTATIO: Item = registerItem(
            "raw_incantatio", RawIncantatio(
                FabricItemSettings().maxCount(32).group(ExumItemGroup.GENERAL)
            )
        )

        val INCANTATIO: Item = registerItem(
            "incantatio", Incantatio(
                FabricItemSettings().maxCount(16).group(ExumItemGroup.GENERAL)
            )
        )

        val ANCIENT_WAND: Item = registerItem(
            "ancient_wand", AncientWand(
                FabricItemSettings().group(ExumItemGroup.GENERAL).maxCount(1)
            )
        )

        val OBSIDIAN_STICK: Item = registerItem(
            "obsidian_stick", ObsidianStick(
                FabricItemSettings().group(ExumItemGroup.GENERAL).maxCount(16)
            )
        )

        val GRAPE_SEEDS: Item = registerItem(
            "grape_seeds", AliasedBlockItem(
                ExumBlocks.GRAPE_CROP,
                FabricItemSettings().group(ExumItemGroup.GENERAL)
            )
        )

        val GRAPE: Item = registerItem(
            "grape", Item(
                FabricItemSettings().group(ExumItemGroup.GENERAL).food(
                    FoodComponent.Builder().hunger(4).saturationModifier(4f).build()
                )
            )
        )

        private fun registerItem(name: String, item: Item) : Item {
            return Registry.register(Registry.ITEM, Identifier(Exum.MOD_ID, name), item)
        }

        fun registerModItems() {
            Exum.LOGGER.debug("Registering Mod Items for ${Exum.MOD_ID}")
        }
    }
}