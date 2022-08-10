package studio.axzet.exum

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer
import studio.axzet.exum.block.ExumBlocks

@Suppress("UNUSED")
class ExumClient: ClientModInitializer {
    override fun onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ExumBlocks.GRAPE_CROP, RenderLayer.getCutout())
    }
}