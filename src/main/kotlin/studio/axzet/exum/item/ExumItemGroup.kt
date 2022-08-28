package studio.axzet.exum.item

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import studio.axzet.exum.Exum
import studio.axzet.exum.block.ExumBlocks

class ExumItemGroup {

    companion object {
        val GENERAL: ItemGroup = FabricItemGroupBuilder.create(
            Identifier(Exum.MOD_ID, "general")
        )
            .icon { ItemStack(ExumItems.INCANTATIO) }
            .appendItems { stacks: MutableList<ItemStack?> ->
                stacks.add(ItemStack(ExumItems.RAW_INCANTATIO))
                stacks.add(ItemStack(ExumItems.INCANTATIO))
                stacks.add(ItemStack(ExumBlocks.INCANTATIO_BLOCK))
                stacks.add(ItemStack(ExumBlocks.INCANTATIO_ORE))
                stacks.add(ItemStack(ExumBlocks.DEEPSLATE_INCANTATIO_ORE))
                stacks.add(ItemStack(ExumBlocks.NETHERRACK_INCANTATIO_ORE))
                stacks.add(ItemStack(ExumBlocks.ENDSTONE_INCANTATIO_ORE))
                stacks.add(ItemStack(ExumItems.ANCIENT_WAND))
                stacks.add(ItemStack(ExumItems.OBSIDIAN_STICK))
                stacks.add(ItemStack(ExumBlocks.DEMON_DEBRIS))
                stacks.add(ItemStack(ExumItems.DEMONITE_SCRAP))
            }
            .build()
    }
}