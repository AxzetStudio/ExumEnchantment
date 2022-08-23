package studio.axzet.exum.screen

import net.minecraft.screen.ScreenHandlerType

class ExumScreenHandlers {
    companion object {
        var INCANTATIO_BLASTER_SCREEN_HANDLER: ScreenHandlerType<IncantatioBlasterScreenHandler>? = null

        fun registerAllScreenHandlers() {
            INCANTATIO_BLASTER_SCREEN_HANDLER = ScreenHandlerType(::IncantatioBlasterScreenHandler)
        }
    }
}