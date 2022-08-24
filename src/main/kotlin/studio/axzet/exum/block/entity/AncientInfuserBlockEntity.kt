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
import studio.axzet.exum.screen.AncientInfuserScreenHandler

class AncientInfuserBlockEntity: BlockEntity, NamedScreenHandlerFactory, ImplementedInventory {
    private val inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(7, ItemStack.EMPTY)

    var propertyDelegate: PropertyDelegate

    private var progress: Int = 0
    private var maxProgress: Int = 146

    constructor(pos: BlockPos, state: BlockState) : super(ExumBlockEntities.ANCIENT_INFUSER, pos, state) {
        propertyDelegate = object : PropertyDelegate {
            override fun get(index: Int): Int {
                return when (index) {
                    0 -> this@AncientInfuserBlockEntity.progress
                    1 -> this@AncientInfuserBlockEntity.maxProgress
                    else -> 0
                }
            }

            override fun set(index: Int, value: Int) {
                when (index) {
                    0 -> this@AncientInfuserBlockEntity.progress = value
                    1 -> this@AncientInfuserBlockEntity.maxProgress = value
                }
            }

            override fun size(): Int {
                return 2
            }
        }
    }

    companion object {
        fun tick(world: World, blockPos: BlockPos, state: BlockState, entity: AncientInfuserBlockEntity) {
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

        private fun craftItem(entity: AncientInfuserBlockEntity) {
            println("Crafting Item")
            var inventorySize: Int = entity.size() - 1

            val inventory: SimpleInventory = SimpleInventory(inventorySize)

            for (i: Int in 0..inventorySize) {
                inventory.setStack(1, entity.getStack(i))
            }

            if (hasRecipe(entity)) {
                entity.removeStack(1, 1)
                entity.removeStack(2, 1)
                entity.removeStack(3, 1)
                entity.removeStack(4, 1)
                entity.removeStack(5, 1)
                entity.removeStack(6, 1)

                entity.setStack(0, ItemStack(ExumItems.INCANTATIO, entity.getStack(0).count + 1))

                entity.resetProgress()
            }
        }

        private fun hasRecipe(entity: AncientInfuserBlockEntity): Boolean {
            var inventorySize: Int = entity.size() - 1

            val inventory: SimpleInventory = SimpleInventory(inventorySize)

            for (i: Int in 0..inventorySize) {
                inventory.setStack(1, entity.getStack(i))
            }

            return hasSlotsFilled(entity)
                    && canInsertAmountInOutputSlot(inventory)
                    && canInsertItemIntoOutputSlot(inventory, ExumItems.INCANTATIO)
        }

        private fun hasSlotsFilled(entity: AncientInfuserBlockEntity): Boolean {
            if (
                entity.getStack(1).item == ExumItems.INCANTATIO &&
                entity.getStack(2).item == ExumItems.INCANTATIO &&
                entity.getStack(3).item == ExumItems.INCANTATIO &&
                entity.getStack(4).item == ExumItems.INCANTATIO &&
                entity.getStack(5).item == ExumItems.INCANTATIO &&
                entity.getStack(6).item == ExumItems.INCANTATIO
            ) {
                println("Has Slots filled")
                return true
            }
            println("Doesnt Has Slots filled")
            return false
        }

        private fun canInsertItemIntoOutputSlot(inventory: SimpleInventory, output: Item): Boolean {
            return inventory.getStack(0).item == output || inventory.getStack(0).isEmpty
        }

        private fun canInsertAmountInOutputSlot(inventory: SimpleInventory): Boolean {
            return inventory.getStack(0).maxCount > inventory.getStack(0).count
        }
    }

    private fun resetProgress() {
        this.progress = 0
    }

    override fun getItems(): DefaultedList<ItemStack> {
        return this.inventory
    }

    override fun getDisplayName(): Text {
        return Text.translatable("block.exum.ancient_infuser")
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity): ScreenHandler? {
        return AncientInfuserScreenHandler(syncId, inv, this, this.propertyDelegate)
    }

    override fun writeNbt(nbt: NbtCompound) {
        super.writeNbt(nbt)
        Inventories.writeNbt(nbt, inventory)
        nbt.putInt("ancient_infuser.progress", progress)
    }

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
        Inventories.readNbt(nbt, inventory)
        progress = nbt.getInt("ancient_infuser.progress")
    }

    override fun markDirty() {
        super<BlockEntity>.markDirty()
        super<ImplementedInventory>.markDirty()
    }
}