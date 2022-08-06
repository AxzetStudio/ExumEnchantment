package studio.axzet.exum.block

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import studio.axzet.exum.Exum

class ExumBlocks {

    companion object  {
        private fun registerBlock(name: String, block: Block, group: ItemGroup): Block {
            registerBlockItem(name, block, group)
            return Registry.register(Registry.BLOCK, Identifier(Exum.MOD_ID, name), block)
        }

        private fun registerBlockItem(name: String, block: Block, group: ItemGroup): Item {
            return Registry.register(Registry.ITEM, Identifier(Exum.MOD_ID, name), BlockItem(block, FabricItemSettings().group(group)))
        }

        fun registerModBlocks() {
            Exum.LOGGER.info("Registering ModBlocs for ${Exum.MOD_ID}")

            // Ancient Enchanter
            registerBlock(
                "ancient_enchanter",
                AncientEnchanter(
                    FabricBlockSettings.of(Material.METAL).strength(6.0f).requiresTool()
                ),
                ItemGroup.MISC
            )
        }
    }
}