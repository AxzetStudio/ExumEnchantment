package studio.axzet.exum.block.entity

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.nbt.NbtCompound
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.PropertyDelegate
import net.minecraft.screen.ScreenHandler
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import studio.axzet.exum.item.ExumItems
import studio.axzet.exum.screen.AncientSmelterScreenHandler

class AncientSmelterBlockEntity: BlockEntity, NamedScreenHandlerFactory, ImplementedInventory {

    private val inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(3, ItemStack.EMPTY)

    var propertyDelegate: PropertyDelegate

    private var progress: Int = 0
    private var maxProgress: Int = 72

    constructor(pos: BlockPos, state: BlockState) : super(ExumBlockEntities.ANCIENT_SMELTER, pos, state) {
        propertyDelegate = object : PropertyDelegate {
            override fun get(index: Int): Int {
                return when (index) {
                    0 -> this@AncientSmelterBlockEntity.progress
                    1 -> this@AncientSmelterBlockEntity.maxProgress
                    else -> 0
                }
            }

            override fun set(index: Int, value: Int) {
                when (index) {
                    0 -> this@AncientSmelterBlockEntity.progress = value
                    1 -> this@AncientSmelterBlockEntity.maxProgress = value
                }
            }

            override fun size(): Int {
                return 2
            }
        }
    }

    companion object {
        fun tick(world: World, blockPos: BlockPos, state: BlockState, entity: AncientSmelterBlockEntity) {
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

        private fun craftItem(entity: AncientSmelterBlockEntity) {
            var inventorySize: Int = entity.size() - 1

            val inventory: SimpleInventory = SimpleInventory(inventorySize)

            for (i: Int in 0..inventorySize) {
                inventory.setStack(1, entity.getStack(i))
            }

            if (hasRecipe(entity)) {
                entity.removeStack(0, 1)
                entity.removeStack(1, 1)

                entity.setStack(2, ItemStack(ExumItems.INCANTATIO, entity.getStack(2).count + 1))

                entity.resetProgress()
            }
        }

        private fun hasRecipe(entity: AncientSmelterBlockEntity): Boolean {
            var inventorySize: Int = entity.size() - 1

            val inventory: SimpleInventory = SimpleInventory(inventorySize)

            for (i: Int in 0..inventorySize) {
                inventory.setStack(1, entity.getStack(i))
            }

            var hasRawIncantatioInFirstSlot: Boolean = entity.getStack(1).item == ExumItems.RAW_INCANTATIO
            var hasInfusedCopperInFuelSlot: Boolean = entity.getStack(0).item == ExumItems.INFUSED_COPPER

            return hasRawIncantatioInFirstSlot
                    && hasInfusedCopperInFuelSlot
                    && canInsertAmountInOutputSlot(inventory)
                    && canInsertItemIntoOutputSlot(inventory, ExumItems.INCANTATIO)
        }

        private fun canInsertItemIntoOutputSlot(inventory: SimpleInventory, output: Item): Boolean {
            return inventory.getStack(2).item == output || inventory.getStack(2).isEmpty
        }

        private fun canInsertAmountInOutputSlot(inventory: SimpleInventory): Boolean {
            return inventory.getStack(2).maxCount > inventory.getStack(2).count
        }
    }

    private fun resetProgress() {
        this.progress = 0
    }

    override fun getItems(): DefaultedList<ItemStack> {
        return this.inventory
    }

    override fun getDisplayName(): Text {
        return Text.translatable("block.exum.ancient_smelter")
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity): ScreenHandler? {
        return AncientSmelterScreenHandler(syncId, inv, this, this.propertyDelegate)
    }

    override fun writeNbt(nbt: NbtCompound) {
        super.writeNbt(nbt)
        Inventories.writeNbt(nbt, inventory)
        nbt.putInt("ancient_smelter.progress", progress)
    }

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
        Inventories.readNbt(nbt, inventory)
        progress = nbt.getInt("ancient_smelter.progress")
    }

    override fun markDirty() {
        super<BlockEntity>.markDirty()
        super<ImplementedInventory>.markDirty()
    }
}