package studio.axzet.exumenchantment.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem
import net.minecraft.item.Item
import net.minecraft.item.ShovelItem
import net.minecraft.item.SwordItem
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import net.minecraft.util.registry.Registry
import studio.axzet.exumenchantment.ExumEnchantment
import studio.axzet.exumenchantment.item.custom.*
import studio.axzet.exumenchantment.item.custom.ancient.AncientInhibitor
import studio.axzet.exumenchantment.item.custom.demonite.*
import studio.axzet.exumenchantment.item.custom.incantatio.*
import studio.axzet.exumenchantment.item.custom.infused.*

class ExumEnchantmentItems {
    companion object {

        val RAW_INCANTATIO: Item = registerItem(
            "raw_incantatio", RawIncantatio(
                FabricItemSettings().maxCount(32).group(ExumEnchantmentItemGroup.INCANTATIO)
            )
        )

        val INCANTATIO: Item = registerItem(
            "incantatio", Incantatio(
                FabricItemSettings().maxCount(16).group(ExumEnchantmentItemGroup.INCANTATIO)
            )
        )

        val MIDAS_CAST: Item = registerItem(
            "midas_cast", MidasCast(
                FabricItemSettings().group(ExumEnchantmentItemGroup.GENERAL).maxCount(16)
            )
        )

        val OBSIDIAN_STICK: Item = registerItem(
            "obsidian_stick", ObsidianStick(
                FabricItemSettings().group(ExumEnchantmentItemGroup.GENERAL).maxCount(16)
            )
        )

        val INCANTATIO_SWORD_HANDLE = registerItem(
            "incantatio_sword_handle", IncantatioSwordHandle(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INCANTATIO).maxCount(1)
            )
        )

        // Ancient

        val ANCIENT_INHIBITOR: Item = registerItem(
            "ancient_inhibitor", AncientInhibitor(
                FabricItemSettings().group(ExumEnchantmentItemGroup.ANCIENT).maxCount(16)
            )
        )

        // Demonite

        val DEMONITE_SCRAP: Item = registerItem(
            "demonite_scrap", DemoniteScrap(
                FabricItemSettings().group(ExumEnchantmentItemGroup.DEMONITE).maxCount(64)
            )
        )

        val DEMONITE_INGOT: Item = registerItem(
            "demonite_ingot", DemoniteIngot(
                FabricItemSettings().group(ExumEnchantmentItemGroup.DEMONITE).maxCount(64)
            )
        )

        // Infused

        val INFUSED_COPPER: Item = registerItem(
            "infused_copper", InfusedCopper(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(64)
            )
        )

        val INFUSED_INCANTATIO: Item = registerItem(
            "infused_incantatio", InfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val BEACON_INFUSED_INCANTATIO: Item = registerItem(
            "beacon_infused_incantatio", BeaconInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val DIAMOND_INFUSED_INCANTATIO: Item = registerItem(
            "diamond_infused_incantatio", DiamondInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val NETHERITE_INFUSED_INCANTATIO: Item = registerItem(
            "netherite_infused_incantatio", NetheriteInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val SPIDER_EYE_INFUSED_INCANTATIO: Item = registerItem(
            "spider_eye_infused_incantatio", SpiderEyeInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val FIREBALL_INFUSED_INCANTATIO: Item = registerItem(
            "fireball_infused_incantatio", FireballInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val END_CRYSTAL_INFUSED_INCANTATIO: Item = registerItem(
            "end_crystal_infused_incantatio", EndCrystalInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val WITHER_INFUSED_INCANTATIO: Item = registerItem(
            "wither_infused_incantatio", WitherInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val NETHER_STAR_INFUSED_INCANTATIO: Item = registerItem(
            "nether_star_infused_incantatio", NetheriteInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val ZOMBIE_INFUSED_INCANTATIO: Item = registerItem(
            "zombie_infused_incantatio", ZombieInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val TNT_INFUSED_INCANTATIO: Item = registerItem(
            "tnt_infused_incantatio", TNTInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val GOLDEN_APPLE_INFUSED_INCANTATIO: Item = registerItem(
            "golden_apple_infused_incantatio", GoldenAppleInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val BOW_INFUSED_INCANTATIO: Item = registerItem(
            "bow_infused_incantatio", BowInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val TOTEM_INFUSED_INCANTATIO: Item = registerItem(
            "totem_infused_incantatio", TotemInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val SPONGE_INFUSED_INCANTATIO: Item = registerItem(
            "sponge_infused_incantatio", SpongeInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val DRAGONS_BREATH_INFUSED_INCANTATIO: Item = registerItem(
            "dragons_breath_infused_incantatio", DragonsBreathInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val SEA_LANTERN_INFUSED_INCANTATIO: Item = registerItem(
            "sea_lantern_infused_incantatio", SeaLanternInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        val HEART_OF_SEA_INFUSED_INCANTATIO: Item = registerItem(
            "heart_of_the_sea_infused_incantatio", HeartOfTheSeaInfusedIncantatio(
                FabricItemSettings().group(ExumEnchantmentItemGroup.INFUSED).maxCount(16)
            )
        )

        // Tools & Weapons
        val INCANTATIO_SWORD: Item = registerItem(
            "incantatio_sword",
            SwordItem(
                ExumEnchantmentToolMaterials.INCANTATIO,
                1,
                2f,
                FabricItemSettings().group(ExumEnchantmentItemGroup.INCANTATIO)
            )
        )

        val INCANTATIO_AXE: Item = registerItem(
            "incantatio_axe",
            IncantatioAxeItem(
                ExumEnchantmentToolMaterials.INCANTATIO,
                3f,
                1f,
                FabricItemSettings().group(ExumEnchantmentItemGroup.INCANTATIO)
            )
        )

        val INCANTATIO_HOE: Item = registerItem(
            "incantatio_hoe",
            IncantatioHoeItem(
                ExumEnchantmentToolMaterials.INCANTATIO,
                0,
                0f,
                FabricItemSettings().group(ExumEnchantmentItemGroup.INCANTATIO)
            )
        )

        val INCANTATIO_SHOVEL: Item = registerItem(
            "incantatio_shovel",
            ShovelItem(
                ExumEnchantmentToolMaterials.INCANTATIO,
                0f,
                1f,
                FabricItemSettings().group(ExumEnchantmentItemGroup.INCANTATIO)
            )
        )

        val INCANTATIO_PICKAXE: Item = registerItem(
            "incantatio_pickaxe",
            IncantatioPickaxeItem(
                ExumEnchantmentToolMaterials.INCANTATIO,
                1,
                0f,
                FabricItemSettings().group(ExumEnchantmentItemGroup.INCANTATIO)
            )
        )

        // Demonite

        val DEMONITE_AXE: Item = registerItem(
            "demonite_axe",
            DemontieAxeItem(
                ExumEnchantmentToolMaterials.DEMONITE,
                4f,
                2f,
                FabricItemSettings().group(ExumEnchantmentItemGroup.DEMONITE)
            )
        )

        val DEMONITE_HOE: Item = registerItem(
            "demonite_hoe",
            DemoniteHoeItem(
                ExumEnchantmentToolMaterials.DEMONITE,
                0,
                0f,
                FabricItemSettings().group(ExumEnchantmentItemGroup.DEMONITE)
            )
        )

        val DEMONITE_SHOVEL: Item = registerItem(
            "demonite_shovel",
            DemoniteShovelItem(
                ExumEnchantmentToolMaterials.DEMONITE,
                0f,
                2f,
                FabricItemSettings().group(ExumEnchantmentItemGroup.DEMONITE)
            )
        )

        val DEMONITE_PICKAXE: Item = registerItem(
            "demonite_pickaxe",
            DemonitePickaxeItem(
                ExumEnchantmentToolMaterials.DEMONITE,
                2,
                3f,
                FabricItemSettings().group(ExumEnchantmentItemGroup.DEMONITE)
            )
        )

        // Armor

        val INCANTATIO_HELMET: Item = registerItem(
            "incantatio_helmet",
            ArmorItem(
                ExumEnchantmentArmorMaterials.INCANTATIO,
                EquipmentSlot.HEAD,
                FabricItemSettings().fireproof().rarity(Rarity.EPIC).group(ExumEnchantmentItemGroup.INCANTATIO)
            )
        )

        val INCANTATIO_CHEST: Item = registerItem(
            "incantatio_chest",
            ArmorItem(
                ExumEnchantmentArmorMaterials.INCANTATIO,
                EquipmentSlot.CHEST,
                FabricItemSettings().fireproof().rarity(Rarity.EPIC).group(ExumEnchantmentItemGroup.INCANTATIO)
            )
        )

        val INCANTATIO_LEGGINGS: Item = registerItem(
            "incantatio_leggings",
            ArmorItem(
                ExumEnchantmentArmorMaterials.INCANTATIO,
                EquipmentSlot.LEGS,
                FabricItemSettings().fireproof().rarity(Rarity.EPIC).group(ExumEnchantmentItemGroup.INCANTATIO)
            )
        )

        val INCANTATIO_BOOTS: Item = registerItem(
            "incantatio_boots",
            ArmorItem(
                ExumEnchantmentArmorMaterials.INCANTATIO,
                EquipmentSlot.FEET,
                FabricItemSettings().fireproof().rarity(Rarity.EPIC).group(ExumEnchantmentItemGroup.INCANTATIO)
            )
        )

        private fun registerItem(name: String, item: Item) : Item {
            return Registry.register(Registry.ITEM, Identifier(ExumEnchantment.MOD_ID, name), item)
        }

        fun registerModItems() {
            ExumEnchantment.LOGGER.debug("Registering Mod Items for ${ExumEnchantment.MOD_ID}")
        }
    }
}