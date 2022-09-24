package studio.axzet.exumenchantment.block.entity

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import studio.axzet.exumenchantment.ExumEnchantment
import studio.axzet.exumenchantment.block.ExumEnchantmentBlocks

class ExumEnchantmentBlockEntities {
    companion object {
        var ANCIENT_SMELTER: BlockEntityType<AncientSmelterBlockEntity>? = null

        var ANCIENT_INFUSER: BlockEntityType<AncientInfuserBlockEntity>? = null

        var ANCIENT_ENCHANTER: BlockEntityType<AncientEnchanterBlockEntity>? = null

        fun registerBlockEntities() {
            ANCIENT_SMELTER = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                Identifier(
                    ExumEnchantment.MOD_ID,
                    "ancient_smelter",
                ),
                FabricBlockEntityTypeBuilder.create(
                    ::AncientSmelterBlockEntity,
                    ExumEnchantmentBlocks.ANCIENT_SMELTER
                ).build()
            )

            ANCIENT_INFUSER = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                Identifier(
                    ExumEnchantment.MOD_ID,
                    "ancient_infuser"
                ),
                FabricBlockEntityTypeBuilder.create(
                    ::AncientInfuserBlockEntity,
                    ExumEnchantmentBlocks.ANCIENT_INFUSER
                ).build()
            )

            ANCIENT_ENCHANTER = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                Identifier(
                    ExumEnchantment.MOD_ID,
                    "ancient_enchanter"
                ),
                FabricBlockEntityTypeBuilder.create(
                    ::AncientEnchanterBlockEntity,
                    ExumEnchantmentBlocks.ANCIENT_ENCHANTER
                ).build()
            )
        }
    }
}