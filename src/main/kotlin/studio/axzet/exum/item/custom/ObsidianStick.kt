package studio.axzet.exum.item.custom

import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World

class ObsidianStick: Item {
    constructor(settings: Settings): super(settings)

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        if (Screen.hasShiftDown()) {
            tooltip?.add(Text.literal("A stick, made of obsidian, what else do you want to know?").formatted(Formatting.AQUA))
        } else {
            tooltip?.add(Text.literal("Press Shift for more info").formatted(Formatting.UNDERLINE))
        }
    }
}