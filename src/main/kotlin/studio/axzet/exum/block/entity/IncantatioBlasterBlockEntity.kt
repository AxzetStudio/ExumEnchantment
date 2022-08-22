package studio.axzet.exum.block.entity

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.ScreenHandler
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos

class IncantatioBlasterBlockEntity: BlockEntity, NamedScreenHandlerFactory, ImplementedInventory {

    private val inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(3, ItemStack.EMPTY)

    constructor(, pos: BlockPos, state: BlockState) : super(, pos, state)

    override fun getItems(): DefaultedList<ItemStack> {
        return this.inventory
    }

    override fun getDisplayName(): Text {
        return Text.literal("Incantatio Blaster")
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory?, player: PlayerEntity?): ScreenHandler? {
        return
    }

    override fun markDirty() {
        super<BlockEntity>.markDirty()
        super<ImplementedInventory>.markDirty()
    }
}