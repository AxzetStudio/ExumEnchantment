package studio.axzet.exum.block.entity

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.PropertyDelegate
import net.minecraft.screen.ScreenHandler
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import studio.axzet.exum.item.ExumItems
import studio.axzet.exum.screen.IncantatioBlasterScreenHandler

class IncantatioBlasterBlockEntity: BlockEntity, NamedScreenHandlerFactory, ImplementedInventory {

    private val inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(3, ItemStack.EMPTY)

    var propertyDelegate: PropertyDelegate

    private var progress: Int = 0
    private var maxProgress: Int = 72

    constructor(pos: BlockPos, state: BlockState) : super(ExumBlockEntities.INCANTATIO_BLASTER, pos, state) {
        propertyDelegate = object : PropertyDelegate {
            override fun get(index: Int): Int {
                return when (index) {
                    0 -> this@IncantatioBlasterBlockEntity.progress
                    1 -> this@IncantatioBlasterBlockEntity.maxProgress
                    else -> 0
                }
            }

            override fun set(index: Int, value: Int) {
                when (index) {
                    0 -> this@IncantatioBlasterBlockEntity.progress = value
                    1 -> this@IncantatioBlasterBlockEntity.maxProgress = value
                }
            }

            override fun size(): Int {
                return 2
            }
        }
    }

    companion object {
        fun tick(world: World, blockPos: BlockPos, state: BlockState, entity: IncantatioBlasterBlockEntity) {
            if (world.isClient) return

            if (hasRecipe(entity)) {
                entity.progress++
                markDirty(world, blockPos, state)
                if (entity.progress >= entity.maxProgress) {
                    craftItem(entity)
                }
            } else {
                entity.resetProgress()
                markDirty(world, blockPos, state)
            }
        }

        private fun craftItem(entity: IncantatioBlasterBlockEntity) {
            var inventorySize: Int = entity.size() - 1

            val inventory: SimpleInventory = SimpleInventory(inventorySize)

            for (i: Int in 0..inventorySize) {
                inventory.setStack(1, entity.getStack(i))
            }

            if (hasRecipe(entity)) {
                entity.removeStack(1, 1)

                entity.setStack(2, ItemStack(ExumItems.INCANTATIO, entity.getStack(2).count + 1))
            }
        }

        private fun hasRecipe(entity: IncantatioBlasterBlockEntity): Boolean {
            var inventorySize: Int = entity.size() - 1

            val inventory: SimpleInventory = SimpleInventory(inventorySize)

            for (i: Int in 0..inventorySize) {
                inventory.setStack(1, entity.getStack(i))
            }

            var hasRawIncantatioInFirstSlot: Boolean = entity.getStack(1).item == ExumItems.RAW_INCANTATIO

            return hasRawIncantatioInFirstSlot && canInsertAmountInOutputSlot(inventory, 1) && canInsertItemIntoOutputSlot(inventory, ExumItems.INCANTATIO)
        }

        private fun canInsertItemIntoOutputSlot(inventory: SimpleInventory, output: Item): Boolean {
            return inventory.getStack(2).item == output || inventory.getStack(2).isEmpty
        }

        private fun canInsertAmountInOutputSlot(inventory: SimpleInventory, count: Int): Boolean {
            return inventory.getStack(2).maxCount > inventory.getStack(2).count + count
        }
    }

    private fun resetProgress() {
        this.progress = 0
    }

    override fun getItems(): DefaultedList<ItemStack> {
        return this.inventory
    }

    override fun getDisplayName(): Text {
        return Text.literal("Incantatio Blaster")
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity): ScreenHandler? {
        return IncantatioBlasterScreenHandler(syncId, inv, this, this.propertyDelegate)
    }

    override fun writeNbt(nbt: NbtCompound) {
        super.writeNbt(nbt)
        Inventories.writeNbt(nbt, inventory)
        nbt.putInt("incantatio_blaster.progress", progress)
    }

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
        Inventories.readNbt(nbt, inventory)
        progress = nbt.getInt("incantatio_blaster.progress")
    }

    override fun markDirty() {
        super<BlockEntity>.markDirty()
        super<ImplementedInventory>.markDirty()
    }
}