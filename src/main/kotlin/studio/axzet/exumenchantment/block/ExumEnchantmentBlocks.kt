package studio.axzet.exumenchantment.block

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
import studio.axzet.exumenchantment.ExumEnchantment
import studio.axzet.exumenchantment.block.custom.ancient.AncientEnchanterBlock
import studio.axzet.exumenchantment.block.custom.ancient.AncientInfuserBlock
import studio.axzet.exumenchantment.block.custom.ancient.AncientSmelterBlock
import studio.axzet.exumenchantment.block.custom.demonite.DemonDebris
import studio.axzet.exumenchantment.block.custom.incantatio.IncantatioBlock
import studio.axzet.exumenchantment.block.custom.incantatio.IncantatioLampBlock
import studio.axzet.exumenchantment.block.custom.incantatio.IncantatioOre
import studio.axzet.exumenchantment.item.ExumEnchantmentItemGroup

class ExumEnchantmentBlocks {

    companion object  {
        val INCANTATIO_BLOCK: Block = registerBlock(
            "incantatio_block",
            IncantatioBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()),
            ExumEnchantmentItemGroup.INCANTATIO
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
            ExumEnchantmentItemGroup.INCANTATIO
        )

        val DEEPSLATE_INCANTATIO_ORE: Block = registerBlock(
            "deepslate_incantatio_ore",
            IncantatioOre(
                FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                UniformIntProvider.create(5,10)
            ),
            ExumEnchantmentItemGroup.INCANTATIO
        )

        val NETHERRACK_INCANTATIO_ORE: Block = registerBlock(
            "netherrack_incantatio_ore",
            IncantatioOre(
                FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                UniformIntProvider.create(5,10)
            ),
            ExumEnchantmentItemGroup.INCANTATIO
        )

        val ENDSTONE_INCANTATIO_ORE: Block = registerBlock(
            "endstone_incantatio_ore",
            IncantatioOre(
                FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                UniformIntProvider.create(5,10)
            ),
            ExumEnchantmentItemGroup.INCANTATIO
        )

        val DEMON_DEBRIS: Block = registerBlock(
            "demon_debris",
            DemonDebris(
                FabricBlockSettings.of(Material.STONE).strength(35f).requiresTool(),
                UniformIntProvider.create(10,15)
            ),
            ExumEnchantmentItemGroup.DEMONITE
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
            ExumEnchantmentItemGroup.INCANTATIO
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
            ExumEnchantmentItemGroup.ANCIENT
        )

        val ANCIENT_INFUSER: Block = registerBlock(
            "ancient_infuser",
            AncientInfuserBlock(
                FabricBlockSettings.of(Material.METAL).strength(4f).nonOpaque()
            ),
            ExumEnchantmentItemGroup.ANCIENT
        )


        val ANCIENT_ENCHANTER: Block = registerBlock(
            "ancient_enchanter",
            AncientEnchanterBlock(
                FabricBlockSettings.of(Material.METAL).strength(4f).nonOpaque()
            ),
            ExumEnchantmentItemGroup.ANCIENT
        )

        private fun registerBlock(name: String, block: Block, group: ItemGroup): Block {
            registerBlockItem(name, block, group)
            return Registry.register(Registry.BLOCK, Identifier(ExumEnchantment.MOD_ID, name), block)
        }

        private fun registerBlockWithoutItem(name: String, block: Block): Block {
            return Registry.register(Registry.BLOCK, Identifier(ExumEnchantment.MOD_ID, name), block)
        }

        private fun registerBlockItem(name: String, block: Block, group: ItemGroup): Item {
            return Registry.register(Registry.ITEM, Identifier(ExumEnchantment.MOD_ID, name), BlockItem(block, FabricItemSettings().group(group)))
        }

        fun registerModBlocks() {
            ExumEnchantment.LOGGER.info("Registering ModBlocks for ${ExumEnchantment.MOD_ID}")
        }
    }
}