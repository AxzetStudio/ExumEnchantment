package studio.axzet.exum.screen

import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import studio.axzet.exum.Exum

class AncientSmelterScreen: HandledScreen<AncientSmelterScreenHandler> {
    constructor(handler: AncientSmelterScreenHandler, inventory: PlayerInventory, title: Text) : super(handler, inventory, title)

    companion object {
        val TEXTURE: Identifier = Identifier(Exum.MOD_ID, "textures/gui/ancient_smelter_gui.png")
    }

    override fun init() {
        super.init()
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2
    }

    override fun drawBackground(matrices: MatrixStack, delta: Float, mouseX: Int, mouseY: Int) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader)
        RenderSystem.setShaderColor(1f, 1f,1f, 1f)
        RenderSystem.setShaderTexture(0, TEXTURE)
        val x: Int = (width - backgroundWidth) / 2
        val y: Int = (height - backgroundHeight) / 2
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight)

        renderProgressArrow(matrices, x, y)
    }

    private fun renderProgressArrow(matrices: MatrixStack, x: Int, y: Int) {
        if (handler.isCrafting()) {
            drawTexture(matrices, x + 78, y + 8, 177, 0, 22, handler.getScaledProgress())
        }
    }

    override fun render(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
        renderBackground(matrices)
        super.render(matrices, mouseX, mouseY, delta)
        drawMouseoverTooltip(matrices, mouseX, mouseY)
    }
}