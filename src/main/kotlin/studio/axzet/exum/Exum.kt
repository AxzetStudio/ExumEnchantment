package studio.axzet.exum

import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import studio.axzet.exum.block.ExumBlocks
import studio.axzet.exum.block.entity.ExumBlockEntities
import studio.axzet.exum.item.ExumItems
import studio.axzet.exum.recipe.ExumRecipes
import studio.axzet.exum.screen.ExumScreenHandlers
import studio.axzet.exum.util.ExumLootTableModifiers
import studio.axzet.exum.villager.ExumVillagers
import studio.axzet.exum.world.feature.ModConfiguredFeatures
import studio.axzet.exum.world.gen.ExumOreGeneration

@Suppress("UNUSED")
object Exum: ModInitializer {
    @JvmStatic val MOD_ID = "exum"

    @JvmStatic val LOGGER: Logger = LogManager.getLogger(MOD_ID)

    override fun onInitialize() {
        ModConfiguredFeatures.registerConfiguredFeatures()

        // Register Block
        ExumBlocks.registerModBlocks()

        // Register Items
        ExumItems.registerModItems()

        // Register Villagers
        ExumVillagers.registerVillagers()
        ExumVillagers.registerTrades()

        // Ore Generation
        ExumOreGeneration.generateOres()

        //Loot Table Modifiers
        ExumLootTableModifiers.modifyLootTable()

        // Register Block Entities
        ExumBlockEntities.registerBlockEntities()

        // Screen Handlers
        ExumScreenHandlers.registerAllScreenHandlers()

        // Recipes
        ExumRecipes.registerRecipes()
    }
}