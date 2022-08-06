package studio.axzet.exum

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Blocks
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.potion.PotionUtil
import net.minecraft.potion.Potions
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import studio.axzet.exum.block.ExumBlocks
import studio.axzet.exum.item.AncientWand
import studio.axzet.exum.item.ExumItems
import java.util.function.Supplier


@Suppress("UNUSED")
object Exum: ModInitializer {
    @JvmStatic val MOD_ID = "exum"

    @JvmStatic val LOGGER: Logger = LogManager.getLogger(MOD_ID)

    override fun onInitialize() {
        // Register Block
        ExumBlocks.registerModBlocks()

        // Register Items
        ExumItems.registerModItems()
    }
}