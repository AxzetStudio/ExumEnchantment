package studio.axzet.exumenchantment.util

import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.fabricmc.fabric.api.loot.v2.LootTableEvents.Modify
import net.fabricmc.fabric.api.loot.v2.LootTableSource
import net.minecraft.item.Item
import net.minecraft.loot.LootManager
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier
import studio.axzet.exumenchantment.item.ExumEnchantmentItems


class ExumEnchantmentLootTableModifiers {
    companion object {

        private val ABANDONED_MINESHAFT_CHEST_ID: Identifier = Identifier(
            "minecraft",
            "chests/abandoned_mineshaft"
        )

        private val BASTION_TREASURE_CHEST_ID: Identifier = Identifier(
            "minecraft",
            "chests/bastion_treasure"
        )

        private val DESERT_PYRAMID_CHEST_ID: Identifier = Identifier(
            "minecraft",
            "chests/desert_pyramid"
        )

        private val STRONGHOLD_LIBRARY_CHEST_ID: Identifier = Identifier(
            "minecraft",
            "chests/stronghold_library"
        )

        private val JUNGLE_TEMPLE_CHEST_ID: Identifier = Identifier(
            "minecraft",
            "chests/jungle_temple"
        )

        private val PILLAGER_OUTPOST_CHEST_ID: Identifier = Identifier(
            "minecraft",
            "chests/pillager_outpost"
        )

        private val MANSION_CHEST_ID: Identifier = Identifier(
            "minecraft",
            "chests/woodland_mansion"
        )

        private val IGLOO_STRUCTURE_CHEST_ID: Identifier = Identifier(
            "minecraft",
            "chests/igloo_chest"
        )

        fun modifyLootTable() {
            LootTableEvents.MODIFY.register(Modify { _: ResourceManager?, _: LootManager?, id: Identifier, tableBuilder: LootTable.Builder, _: LootTableSource? ->

                when(id) {
                    ABANDONED_MINESHAFT_CHEST_ID -> tableBuilder.pool(customPoolBuilder(1f, 0.3f, ExumEnchantmentItems.INCANTATIO))
                    BASTION_TREASURE_CHEST_ID    -> tableBuilder.pool(defaultPoolBuilder(ExumEnchantmentItems.INCANTATIO))
                    DESERT_PYRAMID_CHEST_ID      -> tableBuilder.pool(customPoolBuilder(1f, 0.5f, ExumEnchantmentItems.INCANTATIO))
                    STRONGHOLD_LIBRARY_CHEST_ID  -> tableBuilder.pool(defaultPoolBuilder(ExumEnchantmentItems.INCANTATIO))
                    JUNGLE_TEMPLE_CHEST_ID       -> tableBuilder.pool(defaultPoolBuilder(ExumEnchantmentItems.INCANTATIO))
                    PILLAGER_OUTPOST_CHEST_ID    -> tableBuilder.pool(defaultPoolBuilder(ExumEnchantmentItems.INCANTATIO))
                    MANSION_CHEST_ID             -> tableBuilder.pool(defaultPoolBuilder(ExumEnchantmentItems.INCANTATIO))
                    IGLOO_STRUCTURE_CHEST_ID     -> tableBuilder.pool(defaultPoolBuilder(ExumEnchantmentItems.INCANTATIO))
                }

            })
        }

        private fun defaultPoolBuilder(item: Item): LootPool.Builder {
            return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1f))
                .conditionally(RandomChanceLootCondition.builder(1f)) // 100% drop rate
                .with(ItemEntry.builder(item))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())
        }

        private fun customPoolBuilder(quantity: Float, chance: Float, item: Item): LootPool.Builder {
            return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(quantity))
                .conditionally(RandomChanceLootCondition.builder(chance))
                .with(ItemEntry.builder(item))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())
        }
    }
}