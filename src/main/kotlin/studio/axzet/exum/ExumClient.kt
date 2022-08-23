package studio.axzet.exum

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.gui.screen.ingame.HandledScreens
import net.minecraft.client.render.RenderLayer
import studio.axzet.exum.block.ExumBlocks
import studio.axzet.exum.screen.ExumScreenHandlers
import studio.axzet.exum.screen.IncantatioBlasterScreen

@Suppress("UNUSED")
class ExumClient: ClientModInitializer {
    override fun onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ExumBlocks.GRAPE_CROP, RenderLayer.getCutout())

        HandledScreens.register(ExumScreenHandlers.INCANTATIO_BLASTER_SCREEN_HANDLER, ::IncantatioBlasterScreen)
    }
}