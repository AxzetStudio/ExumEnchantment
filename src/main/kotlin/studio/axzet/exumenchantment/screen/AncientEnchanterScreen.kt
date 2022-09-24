package studio.axzet.exumenchantment.screen

import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import studio.axzet.exumenchantment.ExumEnchantment

class AncientEnchanterScreen: HandledScreen<AncientEnchanterScreenHandler> {
    constructor(handler: AncientEnchanterScreenHandler, inventory: PlayerInventory, title: Text) : super(handler, inventory, title)

    companion object {
        val TEXTURE: Identifier = Identifier(ExumEnchantment.MOD_ID, "textures/gui/ancient_enchanter_gui.png")
    }

    override fun init() {
        super.init()
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2
    }

    override fun drawBackground(matrices: MatrixStack, delta: Float, mouseX: Int, mouseY: Int) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader)
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f)
        RenderSystem.setShaderTexture(0, TEXTURE)

        val x: Int = (width - backgroundWidth) / 2
        val y: Int = (height - backgroundHeight) / 2

        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight)

        renderProgressArrow(matrices, x, y)
    }

    private fun renderProgressArrow(matrices: MatrixStack, x: Int, y: Int) {
        if (handler.isCrafting()) {
            drawTexture(matrices, x + 68, y + 30, 176, 0, handler.getScaledProgress(), 24)
        }
    }

    override fun render(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
        renderBackground(matrices)
        super.render(matrices, mouseX, mouseY, delta)
        drawMouseoverTooltip(matrices, mouseX, mouseY)
    }
}