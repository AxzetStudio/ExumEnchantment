package studio.axzet.exum.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import studio.axzet.exum.Exum

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

        private fun registerItem(name: String, item: Item) : Item {
            return Registry.register(Registry.ITEM, Identifier(Exum.MOD_ID, name), item)
        }

        fun registerModItems() {
            Exum.LOGGER.debug("Registering Mod Items for ${Exum.MOD_ID}")
        }
    }
}