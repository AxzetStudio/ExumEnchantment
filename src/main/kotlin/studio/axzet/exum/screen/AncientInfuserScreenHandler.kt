package studio.axzet.exum.screen

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ArrayPropertyDelegate
import net.minecraft.screen.PropertyDelegate
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot

class AncientInfuserScreenHandler: ScreenHandler {
    private var inventory: Inventory
    private var propertyDelegate: PropertyDelegate

    constructor(syncId: Int, inventory: PlayerInventory) : this(syncId, inventory, SimpleInventory(8), ArrayPropertyDelegate(2))

    constructor(syncId: Int, playerInventory: PlayerInventory, inventory: Inventory, delegate: PropertyDelegate) : super(ExumScreenHandlers.ANCIENT_INFUSER_SCREEN_HANDLER, syncId) {
        checkSize(inventory, 8)
        this.inventory = inventory
        inventory.onOpen(playerInventory.player)
        this.propertyDelegate = delegate

        this.addSlot(Slot(inventory, 0, 40, 12)) // Up
        this.addSlot(Slot(inventory, 1, 65, 21)) // Right-Up
        this.addSlot(Slot(inventory, 2, 65, 49)) // Right-Down
        this.addSlot(Slot(inventory, 3, 40, 58)) // Down
        this.addSlot(Slot(inventory, 4, 15, 49)) // Left-Down
        this.addSlot(Slot(inventory, 5, 15, 21)) // Left-Up
        this.addSlot(Slot(inventory, 6, 40, 35)) // Center
        this.addSlot(Slot(inventory, 7, 125,35)) // Output

        addPlayerInventory(playerInventory)
        addPlayerHotbar(playerInventory)

        addProperties(delegate)
    }

    fun isCrafting(): Boolean {
        return propertyDelegate[0] > 0
    }

    fun getScaledProgress(): Int {
        val progress = propertyDelegate[0]
        val maxProgress = propertyDelegate[1] // Max Progress
        val progressArrowSize = 44 // This is the width in pixels of the arrow
        return if (maxProgress != 0 && progress != 0) progress * progressArrowSize / maxProgress else 0
    }

    override fun transferSlot(player: PlayerEntity, invSlot: Int): ItemStack {
        var newStack: ItemStack = ItemStack.EMPTY
        val slot: Slot = slots[invSlot]
        if (slot != null && slot.hasStack()) {
            val originalStack: ItemStack = slot.stack
            newStack = originalStack.copy()
            if (invSlot < this.inventory.size()) {
                if (!insertItem(originalStack, this.inventory.size(), slots.size, true)) {
                    return ItemStack.EMPTY
                }
            } else if (!insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY
            }
            if (originalStack.isEmpty) {
                slot.stack = ItemStack.EMPTY
            } else {
                slot.markDirty()
            }
        }

        return newStack
    }

    override fun canUse(player: PlayerEntity): Boolean {
        return this.inventory.canPlayerUse(player)
    }

    private fun addPlayerInventory(playerInventory: PlayerInventory) {
        for (i in 0..2) {
            for (l in 0..8) {
                addSlot(Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18))
            }
        }
    }

    private fun addPlayerHotbar(playerInventory: PlayerInventory) {
        for (i in 0..8) {
            addSlot(Slot(playerInventory, i, 8 + i * 18, 144))
        }
    }

}