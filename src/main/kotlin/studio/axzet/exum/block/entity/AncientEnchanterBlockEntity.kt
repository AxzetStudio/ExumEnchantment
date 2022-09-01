package studio.axzet.exum.block.entity

import com.google.gson.Gson
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.enchantment.EnchantmentLevelEntry
import net.minecraft.enchantment.Enchantments
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.EnchantedBookItem
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
import studio.axzet.exum.recipe.AncientEnchanterRecipe
import studio.axzet.exum.screen.AncientEnchanterScreenHandler
import studio.axzet.exum.util.ExumEnchantmentUtil
import java.util.Optional

class AncientEnchanterBlockEntity: BlockEntity, NamedScreenHandlerFactory, ImplementedInventory {
    private val inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(3, ItemStack.EMPTY)

    var propertyDelegate: PropertyDelegate

    private var progress: Int = 0
    private var maxProgress: Int = 72

    constructor(pos: BlockPos, state: BlockState) : super(ExumBlockEntities.ANCIENT_ENCHANTER, pos, state) {
        propertyDelegate = object : PropertyDelegate {
            override fun get(index: Int): Int {
                return when (index) {
                    0 -> this@AncientEnchanterBlockEntity.progress
                    1 -> this@AncientEnchanterBlockEntity.maxProgress
                    else -> 0
                }
            }

            override fun set(index: Int, value: Int) {
                when(index) {
                    0 -> this@AncientEnchanterBlockEntity.progress = value
                    1 -> this@AncientEnchanterBlockEntity.maxProgress = value
                }
            }

            override fun size(): Int {
                return 2
            }
        }
    }

    companion object {

        fun tick(world: World, blockPos: BlockPos, state: BlockState, entity: AncientEnchanterBlockEntity) {
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

        private fun craftItem(entity: AncientEnchanterBlockEntity) {
            val inventory = SimpleInventory(entity.size())

            for (i: Int in 0 until entity.size()) {
                inventory.setStack(i, entity.getStack(i))
            }

            if (hasRecipe(entity)) {
                val outputItem = ItemStack(Items.ENCHANTED_BOOK)

                val enchantmentNbt = EnchantedBookItem.getEnchantmentNbt(entity.getStack(0))

                var enchantmentJson: Map<String, Any> = HashMap()
                enchantmentJson = Gson().fromJson(enchantmentNbt[0].asString(), enchantmentJson.javaClass)

                val enchantment: Enchantment = ExumEnchantmentUtil.getEnchantmentById(enchantmentJson["id"].toString())
                val enchantmentLevel: Int = ExumEnchantmentUtil.parseEnchantmentLevel(enchantmentJson["lvl"].toString()) + 1

                EnchantedBookItem.addEnchantment(
                    outputItem, EnchantmentLevelEntry(
                        enchantment,
                        enchantmentLevel
                    )
                )

                entity.removeStack(0, 1)
                entity.removeStack(1, 1)
                entity.setStack(2, outputItem)

                entity.resetProgress()
            }
        }

        private fun hasRecipe(entity: AncientEnchanterBlockEntity): Boolean {
            val inventory = SimpleInventory(entity.size())

            for (i: Int in 0 until entity.size()) {
                inventory.setStack(i, entity.getStack(i))
            }

            var match: Optional<AncientEnchanterRecipe> = entity.world?.recipeManager?.getFirstMatch(AncientEnchanterRecipe.Companion.Type.INSTANCE, inventory, entity.world)
                ?: Optional.empty()

            return match.isPresent
                    && canInsertAmountInOutputSlot(inventory)
                    && canInsertItemIntoOutputSlot(inventory, match.get().output.item)
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
        return Text.translatable("block.exum.ancient_enchanter")
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity): ScreenHandler? {
        return AncientEnchanterScreenHandler(syncId, inv, this, this.propertyDelegate)
    }

    override fun writeNbt(nbt: NbtCompound) {
        super.writeNbt(nbt)
        Inventories.writeNbt(nbt, inventory)
        nbt.putInt("ancient_enchanter.progress", progress)
    }

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
        Inventories.readNbt(nbt, inventory)
        progress = nbt.getInt("ancient_enchanter.progress")
    }

    override fun markDirty() {
        super<BlockEntity>.markDirty()
        super<ImplementedInventory>.markDirty()
    }
}