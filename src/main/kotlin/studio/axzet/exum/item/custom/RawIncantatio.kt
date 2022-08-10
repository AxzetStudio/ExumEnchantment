package studio.axzet.exum.item.custom

import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World

class RawIncantatio: Item {
    constructor(settings: Settings): super(settings)

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        tooltip?.add(Text.translatable("Este es el primer tooltip"))

        tooltip?.add(Text.translatable("Otro tooltip pero rojo").formatted(Formatting.RED))
    }
}