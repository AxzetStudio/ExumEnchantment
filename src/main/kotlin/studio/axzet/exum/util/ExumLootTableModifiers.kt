package studio.axzet.exum.util

import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.fabricmc.fabric.api.loot.v2.LootTableEvents.Modify
import net.fabricmc.fabric.api.loot.v2.LootTableSource
import net.minecraft.loot.LootManager
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.EntityPropertiesLootCondition
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.context.LootContext
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.predicate.entity.EntityEquipmentPredicate
import net.minecraft.predicate.entity.EntityPredicate
import net.minecraft.predicate.item.ItemPredicate
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier
import studio.axzet.exum.item.ExumItems


class ExumLootTableModifiers {
    companion object {
        private val IGLOO_STRUCTURE_CHEST_ID: Identifier = Identifier(
            "minecraft",
            "chests/igloo_chest"
        )

        fun modifyLootTable() {
            LootTableEvents.MODIFY.register(Modify { _: ResourceManager?, _: LootManager?, id: Identifier, tableBuilder: LootTable.Builder, _: LootTableSource? ->
                if (IGLOO_STRUCTURE_CHEST_ID == id) {
                    val poolBuilder: LootPool.Builder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ExumItems.RAW_INCANTATIO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                    tableBuilder.pool(poolBuilder.build())
                }
            })
        }
    }
}