package studio.axzet.exumenchantment.block.custom.demonite

import net.minecraft.block.OreBlock
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.math.intprovider.IntProvider
import net.minecraft.world.BlockView


class DemonDebris: OreBlock {
    constructor(settings: Settings, experience: IntProvider) : super(settings, experience)

    override fun appendTooltip(
        stack: ItemStack?,
        world: BlockView?,
        tooltip: MutableList<Text>?,
        options: TooltipContext?
    ) {
        tooltip?.add(Text.literal("An ancient debris corrupted with demon's blood..."))
    }


}