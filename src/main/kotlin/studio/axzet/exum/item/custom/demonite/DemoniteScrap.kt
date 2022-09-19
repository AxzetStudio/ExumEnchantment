package studio.axzet.exum.item.custom.demonite

import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.world.World

class DemoniteScrap: Item {

    constructor(settings: Settings): super(settings)

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        tooltip?.add(Text.literal("Demonite Scrap"))
    }
}