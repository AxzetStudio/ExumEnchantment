package studio.axzet.exum.block.entity

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import studio.axzet.exum.Exum
import studio.axzet.exum.block.ExumBlocks

class ExumBlockEntities {
    companion object {
        var ANCIENT_SMELTER: BlockEntityType<AncientSmelterBlockEntity>? = null

        fun registerBlockEntities() {
            ANCIENT_SMELTER = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                Identifier(
                    Exum.MOD_ID,
                    "ancient_smelter",
                ),
                FabricBlockEntityTypeBuilder.create(
                    ::AncientSmelterBlockEntity,
                    ExumBlocks.ANCIENT_SMELTER
                ).build()
            )
        }
    }
}