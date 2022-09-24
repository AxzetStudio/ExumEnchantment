package studio.axzet.exumenchantment

import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import studio.axzet.exumenchantment.block.ExumEnchantmentBlocks
import studio.axzet.exumenchantment.block.entity.ExumEnchantmentBlockEntities
import studio.axzet.exumenchantment.item.ExumEnchantmentItems
import studio.axzet.exumenchantment.recipe.ExumEnchantmentRecipes
import studio.axzet.exumenchantment.screen.ExumEnchantmentScreenHandlers
import studio.axzet.exumenchantment.util.ExumEnchantmentLootTableModifiers
import studio.axzet.exumenchantment.villager.ExumEnchantmentVillagers
import studio.axzet.exumenchantment.world.feature.ModConfiguredFeatures
import studio.axzet.exumenchantment.world.gen.ExumEnchantmentOreGeneration

@Suppress("UNUSED")
object ExumEnchantment: ModInitializer {
    @JvmStatic val MOD_ID = "exumenchantment"

    @JvmStatic val LOGGER: Logger = LogManager.getLogger(MOD_ID)

    override fun onInitialize() {
        ModConfiguredFeatures.registerConfiguredFeatures()

        // Register Block
        ExumEnchantmentBlocks.registerModBlocks()

        // Register Items
        ExumEnchantmentItems.registerModItems()

        // Register Villagers
        ExumEnchantmentVillagers.registerVillagers()
        ExumEnchantmentVillagers.registerTrades()

        // Ore Generation
        ExumEnchantmentOreGeneration.generateOres()

        //Loot Table Modifiers
        ExumEnchantmentLootTableModifiers.modifyLootTable()

        // Register Block Entities
        ExumEnchantmentBlockEntities.registerBlockEntities()

        // Screen Handlers
        ExumEnchantmentScreenHandlers.registerAllScreenHandlers()

        // Recipes
        ExumEnchantmentRecipes.registerRecipes()
    }
}