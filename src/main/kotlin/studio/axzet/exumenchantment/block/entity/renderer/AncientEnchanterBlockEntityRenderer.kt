package studio.axzet.exumenchantment.block.entity.renderer

import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.block.entity.BlockEntityRenderer
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.math.Vec3f
import studio.axzet.exumenchantment.block.entity.AncientEnchanterBlockEntity
import kotlin.math.sin

class AncientEnchanterBlockEntityRenderer: BlockEntityRenderer<AncientEnchanterBlockEntity> {

    constructor(ctx: BlockEntityRendererFactory.Context)

    companion object {
        val stack: ItemStack = ItemStack(Items.ENCHANTED_BOOK)
    }

    override fun render(
        entity: AncientEnchanterBlockEntity,
        tickDelta: Float,
        matrices: MatrixStack,
        vertexConsumers: VertexConsumerProvider,
        light: Int,
        overlay: Int
    ) {
        matrices.push()

        var offset: Double = sin((entity.world!!.time + tickDelta) / 8.0) / 16.0

        matrices.translate(0.5, 0.65 + offset, 0.5)

        matrices.scale(0.5f,0.5f,0.5f)

        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((entity.world!!.time + tickDelta) * 4))

        MinecraftClient.getInstance().itemRenderer.renderItem(stack, ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers, 0)

        matrices.pop()
    }

}