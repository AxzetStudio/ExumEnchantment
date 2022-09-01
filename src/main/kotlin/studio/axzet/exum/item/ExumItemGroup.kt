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
            .appendItems { stacks: MutableList<ItemStack> ->
                stacks.add(ItemStack(ExumItems.ANCIENT_WAND))
                stacks.add(ItemStack(ExumItems.OBSIDIAN_STICK))
                stacks.add(ItemStack(ExumBlocks.DEMON_DEBRIS))
                stacks.add(ItemStack(ExumItems.DEMONITE_SCRAP))
                stacks.add(ItemStack(ExumItems.DEMONITE_INGOT))
                stacks.add(ItemStack(ExumItems.DEMONITE_AXE))
                stacks.add(ItemStack(ExumItems.DEMONITE_HOE))
                stacks.add(ItemStack(ExumItems.DEMONITE_SHOVEL))
                stacks.add(ItemStack(ExumItems.DEMONITE_PICKAXE))
            }
            .build()

        val INCANTATIO: ItemGroup = FabricItemGroupBuilder.create(
            Identifier(Exum.MOD_ID, "incantatio")
        )
            .icon { ItemStack(ExumItems.INCANTATIO) }
            .appendItems { stacks: MutableList<ItemStack> ->
                stacks.add(ItemStack(ExumItems.RAW_INCANTATIO))
                stacks.add(ItemStack(ExumItems.INCANTATIO))
                stacks.add(ItemStack(ExumBlocks.INCANTATIO_BLOCK))
                stacks.add(ItemStack(ExumBlocks.INCANTATIO_ORE))
                stacks.add(ItemStack(ExumBlocks.DEEPSLATE_INCANTATIO_ORE))
                stacks.add(ItemStack(ExumBlocks.NETHERRACK_INCANTATIO_ORE))
                stacks.add(ItemStack(ExumBlocks.ENDSTONE_INCANTATIO_ORE))
                stacks.add(ItemStack(ExumItems.INCANTATIO_HELMET))
                stacks.add(ItemStack(ExumItems.INCANTATIO_CHEST))
                stacks.add(ItemStack(ExumItems.INCANTATIO_LEGGINGS))
                stacks.add(ItemStack(ExumItems.INCANTATIO_BOOTS))
            }
            .build()

        val INFUSED: ItemGroup = FabricItemGroupBuilder.create(
            Identifier(Exum.MOD_ID, "infused")
        )
            .icon{ ItemStack(ExumItems.INFUSED_INCANTATIO) }
            .appendItems { stacks: MutableList<ItemStack> ->
                stacks.add(ItemStack(ExumItems.INFUSED_COPPER))
                stacks.add(ItemStack(ExumItems.INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumItems.BEACON_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumItems.DIAMOND_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumItems.NETHERITE_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumItems.SPIDER_EYE_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumItems.FIREBALL_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumItems.END_CRYSTAL_INFUSED_INCANTATIO))
            }
            .build()
    }
}