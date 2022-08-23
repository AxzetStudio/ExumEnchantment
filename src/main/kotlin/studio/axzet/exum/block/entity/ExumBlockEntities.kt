package studio.axzet.exum.block.entity

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import studio.axzet.exum.Exum
import studio.axzet.exum.block.ExumBlocks

class ExumBlockEntities {
    companion object {
        var INCANTATIO_BLASTER: BlockEntityType<IncantatioBlasterBlockEntity>? = null

        fun registerBlockEntities() {
            INCANTATIO_BLASTER = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                Identifier(
                    Exum.MOD_ID,
                    "incantatio_blaster",
                ),
                FabricBlockEntityTypeBuilder.create(
                    ::IncantatioBlasterBlockEntity,
                    ExumBlocks.INCANTATIO_BLASTER
                ).build()
            )
        }
    }
}