package studio.axzet.exum.block

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.util.registry.Registry
import studio.axzet.exum.Exum
import studio.axzet.exum.block.custom.*
import studio.axzet.exum.item.ExumItemGroup

class ExumBlocks {

    companion object  {
        val INCANTATIO_BLOCK: Block = registerBlock(
            "incantatio_block",
            IncantatioBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()),
            ExumItemGroup.INCANTATIO
        )

        val INCANTATIO_ORE: Block = registerBlock(
            "incantatio_ore",
            IncantatioOre(
                FabricBlockSettings.of(Material.STONE)
                    .strength(4f)
                    .requiresTool()
                    .luminance { state -> if (state.get(IncantatioOre.LIT)) 15 else 0 },
                UniformIntProvider.create(5,10)
            ),
            ExumItemGroup.INCANTATIO
        )

        val DEEPSLATE_INCANTATIO_ORE: Block = registerBlock(
            "deepslate_incantatio_ore",
            IncantatioOre(
                FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                UniformIntProvider.create(5,10)
            ),
            ExumItemGroup.INCANTATIO
        )

        val NETHERRACK_INCANTATIO_ORE: Block = registerBlock(
            "netherrack_incantatio_ore",
            IncantatioOre(
                FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                UniformIntProvider.create(5,10)
            ),
            ExumItemGroup.INCANTATIO
        )

        val ENDSTONE_INCANTATIO_ORE: Block = registerBlock(
            "endstone_incantatio_ore",
            IncantatioOre(
                FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                UniformIntProvider.create(5,10)
            ),
            ExumItemGroup.INCANTATIO
        )

        val DEMON_DEBRIS: Block = registerBlock(
            "demon_debris",
            DemonDebris(
                FabricBlockSettings.of(Material.STONE).strength(35f).requiresTool(),
                UniformIntProvider.create(10,15)
            ),
            ExumItemGroup.DEMONITE
        )

        val INCANTATIO_LAMP: Block = registerBlock(
            "incantatio_lamp",
            IncantatioLampBlock(
                FabricBlockSettings
                    .of(Material.STONE)
                    .strength(4f)
                    .requiresTool()
                    .luminance { state -> if (state.get(IncantatioLampBlock.LIT)) 15 else 0 }
            ),
            ExumItemGroup.INCANTATIO
        )

        val GRAPE_CROP: Block = registerBlockWithoutItem(
            "grape_crop",
            GrapeCropBlock(
                FabricBlockSettings.copy(Blocks.WHEAT)
            )
        )

        val ANCIENT_SMELTER: Block = registerBlock(
            "ancient_smelter",
            AncientSmelterBlock(
                FabricBlockSettings
                    .of(Material.METAL)
                    .strength(4f)
                    .nonOpaque()
                    .luminance { state -> if (state.get(AncientSmelterBlock.LIT)) 15 else 0 }
            ),
            ExumItemGroup.ANCIENT
        )

        val ANCIENT_INFUSER: Block = registerBlock(
            "ancient_infuser",
            AncientInfuserBlock(
                FabricBlockSettings.of(Material.METAL).strength(4f).nonOpaque()
            ),
            ExumItemGroup.ANCIENT
        )


        val ANCIENT_ENCHANTER: Block = registerBlock(
            "ancient_enchanter",
            AncientEnchanterBlock(
                FabricBlockSettings.of(Material.METAL).strength(4f).nonOpaque()
            ),
            ExumItemGroup.ANCIENT
        )
                
        val ANCIENT_DIRT_GRASS: Block = registerBlock(
            "ancient_dirt_grass",
            AncientDirtBlockGrass(
                FabricBlockSettings.copy(Blocks.GRASS_BLOCK).strength(5f).requiresTool()
            ),
            ExumItemGroup.GENERAL
        )

        val ANCIENT_LOG_BLOCK_GRENY:Block = registerBlock(
            "ancient_log_block_greny",
            AncientLogBlockGreny(
                FabricBlockSettings.of(Material.WOOD).strength(5f).nonOpaque().requiresTool()
            ),
            ExumItemGroup.GENERAL
        )

        private fun registerBlock(name: String, block: Block, group: ItemGroup): Block {
            registerBlockItem(name, block, group)
            return Registry.register(Registry.BLOCK, Identifier(Exum.MOD_ID, name), block)
        }

        private fun registerBlockWithoutItem(name: String, block: Block): Block {
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