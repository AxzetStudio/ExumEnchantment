package studio.axzet.exum

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry
import net.minecraft.client.gui.screen.ingame.HandledScreens
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.block.entity.BlockEntityRenderer
import studio.axzet.exum.block.ExumBlocks
import studio.axzet.exum.block.entity.AncientEnchanterBlockEntity
import studio.axzet.exum.block.entity.ExumBlockEntities
import studio.axzet.exum.block.entity.renderer.AncientEnchanterBlockEntityRenderer
import studio.axzet.exum.screen.AncientEnchanterScreen
import studio.axzet.exum.screen.AncientInfuserScreen
import studio.axzet.exum.screen.ExumScreenHandlers
import studio.axzet.exum.screen.AncientSmelterScreen

@Suppress("UNUSED")
class ExumClient: ClientModInitializer {
    override fun onInitializeClient() {
        BlockEntityRendererRegistry.register(
            ExumBlockEntities.ANCIENT_ENCHANTER,
            ::AncientEnchanterBlockEntityRenderer
        )

        HandledScreens.register(ExumScreenHandlers.ANCIENT_SMELTER_SCREEN_HANDLER, ::AncientSmelterScreen)
        HandledScreens.register(ExumScreenHandlers.ANCIENT_INFUSER_SCREEN_HANDLER, ::AncientInfuserScreen)
        HandledScreens.register(ExumScreenHandlers.ANCIENT_ENCHANTER_SCREEN_HANDLER, ::AncientEnchanterScreen)
    }
}