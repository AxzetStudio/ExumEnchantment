package studio.axzet.exumenchantment

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry
import net.minecraft.client.gui.screen.ingame.HandledScreens
import studio.axzet.exumenchantment.block.entity.ExumEnchantmentBlockEntities
import studio.axzet.exumenchantment.block.entity.renderer.AncientEnchanterBlockEntityRenderer
import studio.axzet.exumenchantment.screen.AncientEnchanterScreen
import studio.axzet.exumenchantment.screen.AncientInfuserScreen
import studio.axzet.exumenchantment.screen.ExumEnchantmentScreenHandlers
import studio.axzet.exumenchantment.screen.AncientSmelterScreen

@Suppress("UNUSED")
class ExumEnchantmentClient: ClientModInitializer {
    override fun onInitializeClient() {
        BlockEntityRendererRegistry.register(
            ExumEnchantmentBlockEntities.ANCIENT_ENCHANTER,
            ::AncientEnchanterBlockEntityRenderer
        )

        HandledScreens.register(ExumEnchantmentScreenHandlers.ANCIENT_SMELTER_SCREEN_HANDLER, ::AncientSmelterScreen)
        HandledScreens.register(ExumEnchantmentScreenHandlers.ANCIENT_INFUSER_SCREEN_HANDLER, ::AncientInfuserScreen)
        HandledScreens.register(ExumEnchantmentScreenHandlers.ANCIENT_ENCHANTER_SCREEN_HANDLER, ::AncientEnchanterScreen)
    }
}