package studio.axzet.exum

import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import studio.axzet.exum.block.ExumBlocks
import studio.axzet.exum.item.ExumItems
import studio.axzet.exum.world.feature.ModConfiguredFeatures
import studio.axzet.exum.world.gen.ModOreGeneration

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

        ModOreGeneration.generateOres()
    }
}