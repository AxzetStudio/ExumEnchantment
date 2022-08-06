package studio.axzet.exum.item

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import studio.axzet.exum.Exum

class ExumItemGroup {

    companion object {
        val GENERAL: ItemGroup? = FabricItemGroupBuilder.create(
            Identifier(Exum.MOD_ID, "general")
        )
            .icon { ItemStack(ExumItems.INCANTATIO) }
            .appendItems { stacks: MutableList<ItemStack?> ->
                stacks.add(ItemStack(ExumItems.RAW_INCANTATIO))
                stacks.add(ItemStack(ExumItems.INCANTATIO))
                stacks.add(ItemStack(ExumItems.ANCIENT_WAND))
            }
            .build()
    }
}