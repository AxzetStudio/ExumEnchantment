package studio.axzet.exumenchantment.block.entity

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
import studio.axzet.exumenchantment.recipe.AncientInfuserRecipe
import studio.axzet.exumenchantment.screen.AncientInfuserScreenHandler
import java.util.Optional

class AncientInfuserBlockEntity: BlockEntity, NamedScreenHandlerFactory, ImplementedInventory {
    private val inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(8, ItemStack.EMPTY)

    var propertyDelegate: PropertyDelegate

    private var progress: Int = 0
    private var maxProgress: Int = 146

    constructor(pos: BlockPos, state: BlockState) : super(ExumEnchantmentBlockEntities.ANCIENT_INFUSER, pos, state) {
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
            val inventory= SimpleInventory(entity.size())

            for (i: Int in 0 until entity.size()) {
                inventory.setStack(i, entity.getStack(i))
            }

            var recipe: Optional<AncientInfuserRecipe> = entity.world?.recipeManager?.getFirstMatch(AncientInfuserRecipe.Companion.Type.INSTANCE, inventory, entity.world)
                ?: Optional.empty()

            if (hasRecipe(entity)) {
                entity.removeStack(0, 1)
                entity.removeStack(1, 1)
                entity.removeStack(2, 1)
                entity.removeStack(3, 1)
                entity.removeStack(4, 1)
                entity.removeStack(5, 1)
                entity.removeStack(6, 1)

                entity.setStack(
                    7, ItemStack(
                        recipe.get().output.item,
                        entity.getStack(7).count + 1
                    )
                )

                entity.resetProgress()
            }
        }

        private fun hasRecipe(entity: AncientInfuserBlockEntity): Boolean {
            val inventory = SimpleInventory(entity.size())

            for (i: Int in 0 until entity.size()) {
                inventory.setStack(i, entity.getStack(i))
            }

            var match: Optional<AncientInfuserRecipe> = entity.world?.recipeManager?.getFirstMatch(AncientInfuserRecipe.Companion.Type.INSTANCE, inventory, entity.world)
                ?: Optional.empty()

            return match.isPresent
                    && canInsertAmountInOutputSlot(inventory)
                    && canInsertItemIntoOutputSlot(inventory, match.get().output.item)
        }

        private fun canInsertItemIntoOutputSlot(inventory: SimpleInventory, output: Item): Boolean {
            return inventory.getStack(7).item == output || inventory.getStack(7).isEmpty
        }

        private fun canInsertAmountInOutputSlot(inventory: SimpleInventory): Boolean {
            return inventory.getStack(7).maxCount > inventory.getStack(7).count
        }
    }

    private fun resetProgress() {
        this.progress = 0
    }

    override fun getItems(): DefaultedList<ItemStack> {
        return this.inventory
    }

    override fun getDisplayName(): Text {
        return Text.translatable("block.exumenchantment.ancient_infuser")
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