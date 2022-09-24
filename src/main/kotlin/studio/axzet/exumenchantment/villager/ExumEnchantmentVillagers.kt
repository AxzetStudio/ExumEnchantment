package studio.axzet.exumenchantment.villager

import com.google.common.collect.ImmutableSet
import net.fabricmc.fabric.api.`object`.builder.v1.trade.TradeOfferHelper
import net.fabricmc.fabric.api.`object`.builder.v1.villager.VillagerProfessionBuilder
import net.fabricmc.fabric.api.`object`.builder.v1.world.poi.PointOfInterestHelper
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import net.minecraft.util.math.random.Random
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.village.TradeOffer
import net.minecraft.village.TradeOffers
import net.minecraft.village.VillagerProfession
import net.minecraft.world.poi.PointOfInterestType
import studio.axzet.exumenchantment.ExumEnchantment
import studio.axzet.exumenchantment.block.ExumEnchantmentBlocks
import studio.axzet.exumenchantment.item.ExumEnchantmentItems

class ExumEnchantmentVillagers {
    companion object {

        val INCANTATIO_BLOCK_POI: PointOfInterestType = registerPOI(
            "incantatio_block_poi",
            ExumEnchantmentBlocks.INCANTATIO_BLOCK
        )

        val INCANTATIO_SAGE: VillagerProfession = registerProfession(
            "incantatio_sage",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, Identifier(ExumEnchantment.MOD_ID, "incantatio_block_poi"))
        )

        private fun registerProfession(name: String, type: RegistryKey<PointOfInterestType>): VillagerProfession {
            return Registry.register(
                Registry.VILLAGER_PROFESSION,
                Identifier(ExumEnchantment.MOD_ID, name),
                VillagerProfessionBuilder.create().id(Identifier(ExumEnchantment.MOD_ID, name)).workstation(type).workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build()
            )
        }

        private fun registerPOI(name: String, block: Block): PointOfInterestType {
            return PointOfInterestHelper.register(
                Identifier(ExumEnchantment.MOD_ID, name),
                1,
                1,
                ImmutableSet.copyOf(block.stateManager.states)
            )
        }

        fun registerTrades() {
            TradeOfferHelper.registerVillagerOffers(
                INCANTATIO_SAGE, 1
            ) { factories: MutableList<TradeOffers.Factory?> ->
                factories.add(TradeOffers.Factory { _: Entity?, _: Random? ->
                    TradeOffer(
                        ItemStack(Items.EMERALD, 64),
                        ItemStack(ExumEnchantmentItems.INCANTATIO, 1),
                        6, 2, 0.02f
                    )
                })
            }
        }


        fun registerVillagers() {
            ExumEnchantment.LOGGER.debug("Registering villagers for ${ExumEnchantment.MOD_ID}")
        }
    }
}