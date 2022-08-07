package studio.axzet.exum.block

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.util.registry.Registry
import studio.axzet.exum.Exum
import studio.axzet.exum.item.ExumItemGroup

class ExumBlocks {

    companion object  {
        val INCANTATIO_BLOCK: Block = registerBlock(
            "incantatio_block",
            IncantatioBlock( FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool(),),
            ExumItemGroup.GENERAL
        )

        val INCANTATIO_ORE: Block = registerBlock(
            "incantatio_ore",
            IncantatioOre(
                FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                UniformIntProvider.create(5,10)
            ),
            ExumItemGroup.GENERAL
        )

        val DEEPSLATE_INCANTATIO_ORE: Block = registerBlock(
            "deepslate_incantatio_ore",
            IncantatioOre(
                FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                UniformIntProvider.create(5,10)
            ),
            ExumItemGroup.GENERAL
        )

        val NETHERRACK_INCANTATIO_ORE: Block = registerBlock(
            "netherrack_incantatio_ore",
            IncantatioOre(
                FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                UniformIntProvider.create(5,10)
            ),
            ExumItemGroup.GENERAL
        )

        val ENDSTONE_INCANTATIO_ORE: Block = registerBlock(
            "endstone_incantatio_ore",
            IncantatioOre(
                FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                UniformIntProvider.create(5,10)
            ),
            ExumItemGroup.GENERAL
        )

        private fun registerBlock(name: String, block: Block, group: ItemGroup): Block {
            registerBlockItem(name, block, group)
            return Registry.register(Registry.BLOCK, Identifier(Exum.MOD_ID, name), block)
        }

        private fun registerBlockItem(name: String, block: Block, group: ItemGroup): Item {
            return Registry.register(Registry.ITEM, Identifier(Exum.MOD_ID, name), BlockItem(block, FabricItemSettings().group(group)))
        }

        fun registerModBlocks() {
            Exum.LOGGER.info("Registering ModBlocks for ${Exum.MOD_ID}")
        }
    }
}