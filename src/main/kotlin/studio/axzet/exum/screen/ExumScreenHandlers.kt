package studio.axzet.exum.screen

import net.minecraft.screen.ScreenHandlerType

class ExumScreenHandlers {
    companion object {
        var ANCIENT_SMELTER_SCREEN_HANDLER: ScreenHandlerType<AncientSmelterScreenHandler>? = null

        fun registerAllScreenHandlers() {
            ANCIENT_SMELTER_SCREEN_HANDLER = ScreenHandlerType(::AncientSmelterScreenHandler)
        }
    }
}