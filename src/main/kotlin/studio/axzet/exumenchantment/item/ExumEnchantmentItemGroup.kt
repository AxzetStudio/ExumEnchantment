package studio.axzet.exumenchantment.item

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import studio.axzet.exumenchantment.ExumEnchantment
import studio.axzet.exumenchantment.block.ExumEnchantmentBlocks

class ExumEnchantmentItemGroup {

    companion object {
        val GENERAL: ItemGroup = FabricItemGroupBuilder.create(
            Identifier(ExumEnchantment.MOD_ID, "general")
        )
            .icon { ItemStack(ExumEnchantmentItems.INCANTATIO) }
            .appendItems { stacks: MutableList<ItemStack> ->
                stacks.add(ItemStack(ExumEnchantmentItems.OBSIDIAN_STICK))
                stacks.add(ItemStack(ExumEnchantmentItems.MIDAS_CAST))
            }
            .build()

        val INCANTATIO: ItemGroup = FabricItemGroupBuilder.create(
            Identifier(ExumEnchantment.MOD_ID, "incantatio")
        )
            .icon { ItemStack(ExumEnchantmentItems.INCANTATIO) }
            .appendItems { stacks: MutableList<ItemStack> ->
                stacks.add(ItemStack(ExumEnchantmentItems.RAW_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentBlocks.INCANTATIO_BLOCK))
                stacks.add(ItemStack(ExumEnchantmentBlocks.INCANTATIO_ORE))
                stacks.add(ItemStack(ExumEnchantmentBlocks.DEEPSLATE_INCANTATIO_ORE))
                stacks.add(ItemStack(ExumEnchantmentBlocks.NETHERRACK_INCANTATIO_ORE))
                stacks.add(ItemStack(ExumEnchantmentBlocks.ENDSTONE_INCANTATIO_ORE))
                stacks.add(ItemStack(ExumEnchantmentItems.INCANTATIO_HELMET))
                stacks.add(ItemStack(ExumEnchantmentItems.INCANTATIO_CHEST))
                stacks.add(ItemStack(ExumEnchantmentItems.INCANTATIO_LEGGINGS))
                stacks.add(ItemStack(ExumEnchantmentItems.INCANTATIO_BOOTS))
                stacks.add(ItemStack(ExumEnchantmentItems.INCANTATIO_SWORD_HANDLE))
                stacks.add(ItemStack(ExumEnchantmentItems.INCANTATIO_SWORD))
                stacks.add(ItemStack(ExumEnchantmentItems.INCANTATIO_AXE))
                stacks.add(ItemStack(ExumEnchantmentItems.INCANTATIO_HOE))
                stacks.add(ItemStack(ExumEnchantmentItems.INCANTATIO_SHOVEL))
                stacks.add(ItemStack(ExumEnchantmentItems.INCANTATIO_PICKAXE))
                stacks.add(ItemStack(ExumEnchantmentBlocks.INCANTATIO_LAMP))
            }
            .build()

        val ANCIENT: ItemGroup = FabricItemGroupBuilder.create(
            Identifier(ExumEnchantment.MOD_ID, "ancient")
        )
            .icon { ItemStack(ExumEnchantmentItems.ANCIENT_INHIBITOR) }
            .appendItems { stacks: MutableList<ItemStack> ->
                stacks.add(ItemStack(ExumEnchantmentItems.ANCIENT_INHIBITOR))
                stacks.add(ItemStack(ExumEnchantmentBlocks.ANCIENT_SMELTER))
                stacks.add(ItemStack(ExumEnchantmentBlocks.ANCIENT_INFUSER))
                stacks.add(ItemStack(ExumEnchantmentBlocks.ANCIENT_ENCHANTER))
            }
            .build()

        val DEMONITE: ItemGroup = FabricItemGroupBuilder.create(
            Identifier(ExumEnchantment.MOD_ID, "demonite")
        )
            .icon { ItemStack(ExumEnchantmentItems.DEMONITE_INGOT) }
            .appendItems { stacks: MutableList<ItemStack> ->
                stacks.add(ItemStack(ExumEnchantmentBlocks.DEMON_DEBRIS))
                stacks.add(ItemStack(ExumEnchantmentItems.DEMONITE_SCRAP))
                stacks.add(ItemStack(ExumEnchantmentItems.DEMONITE_INGOT))
                stacks.add(ItemStack(ExumEnchantmentItems.DEMONITE_HOE))
                stacks.add(ItemStack(ExumEnchantmentItems.DEMONITE_AXE))
                stacks.add(ItemStack(ExumEnchantmentItems.DEMONITE_PICKAXE))
                stacks.add(ItemStack(ExumEnchantmentItems.DEMONITE_SHOVEL))
            }
            .build()

        val INFUSED: ItemGroup = FabricItemGroupBuilder.create(
            Identifier(ExumEnchantment.MOD_ID, "infused")
        )
            .icon{ ItemStack(ExumEnchantmentItems.INFUSED_INCANTATIO) }
            .appendItems { stacks: MutableList<ItemStack> ->
                stacks.add(ItemStack(ExumEnchantmentItems.INFUSED_COPPER))
                stacks.add(ItemStack(ExumEnchantmentItems.INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.BEACON_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.DIAMOND_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.NETHERITE_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.SPIDER_EYE_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.FIREBALL_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.END_CRYSTAL_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.WITHER_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.NETHER_STAR_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.ZOMBIE_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.TNT_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.GOLDEN_APPLE_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.BOW_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.TOTEM_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.SPONGE_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.DRAGONS_BREATH_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.SEA_LANTERN_INFUSED_INCANTATIO))
                stacks.add(ItemStack(ExumEnchantmentItems.HEART_OF_SEA_INFUSED_INCANTATIO))
            }
            .build()
    }
}