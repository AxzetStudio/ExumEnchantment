package studio.axzet.exumenchantment.item.custom.incantatio

import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.world.World

class IncantatioSwordHandle: Item {
    constructor(settings: Settings): super(settings)

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        tooltip?.add(Text.literal("The handle of the Incantatio Sword"))
    }
}