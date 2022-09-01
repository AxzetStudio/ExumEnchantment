package studio.axzet.exum.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.AliasedBlockItem
import net.minecraft.item.ArmorItem
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ShovelItem
import net.minecraft.item.SwordItem
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import net.minecraft.util.registry.Registry
import studio.axzet.exum.Exum
import studio.axzet.exum.block.ExumBlocks
import studio.axzet.exum.item.custom.*
import studio.axzet.exum.item.custom.infused.*

class ExumItems {
    companion object {

        val RAW_INCANTATIO: Item = registerItem(
            "raw_incantatio", RawIncantatio(
                FabricItemSettings().maxCount(32).group(ExumItemGroup.GENERAL)
            )
        )

        val INCANTATIO: Item = registerItem(
            "incantatio", Incantatio(
                FabricItemSettings().maxCount(16).group(ExumItemGroup.GENERAL)
            )
        )

        val MIDAS_CAST: Item = registerItem(
            "midas_cast", MidasCast(
                FabricItemSettings().group(ExumItemGroup.GENERAL).maxCount(16)
            )
        )

        val OBSIDIAN_STICK: Item = registerItem(
            "obsidian_stick", ObsidianStick(
                FabricItemSettings().group(ExumItemGroup.GENERAL).maxCount(16)
            )
        )

        val INCANTATIO_SWORD_HANDLE = registerItem(
            "incantatio_sword_handle", IncantatioSwordHandle(
                FabricItemSettings().group(ExumItemGroup.GENERAL).maxCount(1)
            )
        )

        val ANCIENT_WAND: Item = registerItem(
            "ancient_wand", AncientWand(
                FabricItemSettings().group(ExumItemGroup.GENERAL).maxCount(1)
            )
        )

        val ANCIENT_INHIBITOR: Item = registerItem(
            "ancient_inhibitor", AncientInhibitor(
                FabricItemSettings().group(ExumItemGroup.GENERAL).maxCount(16)
            )
        )

        val DEMONITE_SCRAP: Item = registerItem(
            "demonite_scrap", DemoniteScrap(
                FabricItemSettings().group(ExumItemGroup.GENERAL).maxCount(64)
            )
        )

        val DEMONITE_INGOT: Item = registerItem(
            "demonite_ingot", DemoniteIngot(
                FabricItemSettings().group(ExumItemGroup.GENERAL).maxCount(64)
            )
        )

        // Infused

        val INFUSED_COPPER: Item = registerItem(
            "infused_copper", InfusedCopper(
                FabricItemSettings().group(ExumItemGroup.GENERAL).maxCount(64)
            )
        )

        val INFUSED_INCANTATIO: Item = registerItem(
            "infused_incantatio", InfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.GENERAL).maxCount(16)
            )
        )

        val BEACON_INFUSED_INCANTATIO: Item = registerItem(
            "beacon_infused_incantatio", BeaconInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val DIAMOND_INFUSED_INCANTATIO: Item = registerItem(
            "diamond_infused_incantatio", DiamondInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val NETHERITE_INFUSED_INCANTATIO: Item = registerItem(
            "netherite_infused_incantatio", NetheriteInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val SPIDER_EYE_INFUSED_INCANTATIO: Item = registerItem(
            "spider_eye_infused_incantatio", SpiderEyeInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val FIREBALL_INFUSED_INCANTATIO: Item = registerItem(
            "fireball_infused_incantatio", FireballInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val END_CRYSTAL_INFUSED_INCANTATIO: Item = registerItem(
            "end_crystal_infused_incantatio", EndCrystalInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val WITHER_INFUSED_INCANTATIO: Item = registerItem(
            "wither_infused_incantatio", WitherInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val NETHER_STAR_INFUSED_INCANTATIO: Item = registerItem(
            "nether_star_infused_incantatio", NetheriteInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val ZOMBIE_INFUSED_INCANTATIO: Item = registerItem(
            "zombie_infused_incantatio", ZombieInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val TNT_INFUSED_INCANTATIO: Item = registerItem(
            "tnt_infused_incantatio", TNTInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val GOLDEN_APPLE_INFUSED_INCANTATIO: Item = registerItem(
            "golden_apple_infused_incantatio", GoldenAppleInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val BOW_INFUSED_INCANTATIO: Item = registerItem(
            "bow_infused_incantatio", BowInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val TOTEM_INFUSED_INCANTATIO: Item = registerItem(
            "totem_infused_incantatio", TotemInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val SPONGE_INFUSED_INCANTATIO: Item = registerItem(
            "sponge_infused_incantatio", SpongeInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val DRAGONS_BREATH_INFUSED_INCANTATIO: Item = registerItem(
            "dragons_breath_infused_incantatio", DragonsBreathInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        val SEA_LANTERN_INFUSED_INCANTATIO: Item = registerItem(
            "sea_lantern_infused_incantatio", SeaLanternInfusedIncantatio(
                FabricItemSettings().group(ExumItemGroup.INFUSED).maxCount(16)
            )
        )

        // Tools & Weapons
        val INCANTATIO_SWORD: Item = registerItem(
            "incantatio_sword",
            SwordItem(
                ExumToolMaterials.INCANTATIO,
                1,
                2f,
                FabricItemSettings().group(ExumItemGroup.GENERAL)
            )
        )

        val INCANTATIO_AXE: Item = registerItem(
            "incantatio_axe",
            IncantatioAxeItem(
                ExumToolMaterials.INCANTATIO,
                3f,
                1f,
                FabricItemSettings().group(ExumItemGroup.GENERAL)
            )
        )

        val INCANTATIO_HOE: Item = registerItem(
            "incantatio_hoe",
            IncantatioHoeItem(
                ExumToolMaterials.INCANTATIO,
                0,
                0f,
                FabricItemSettings().group(ExumItemGroup.GENERAL)
            )
        )

        val INCANTATIO_SHOVEL: Item = registerItem(
            "incantatio_shovel",
            ShovelItem(
                ExumToolMaterials.INCANTATIO,
                0f,
                1f,
                FabricItemSettings().group(ExumItemGroup.GENERAL)
            )
        )

        val INCANTATIO_PICKAXE: Item = registerItem(
            "incantatio_pickaxe",
            IncantatioPickaxeItem(
                ExumToolMaterials.INCANTATIO,
                1,
                0f,
                FabricItemSettings().group(ExumItemGroup.GENERAL)
            )
        )

        // Demonite

        val DEMONITE_AXE: Item = registerItem(
            "demonite_axe",
            DemontieAxeItem(
                ExumToolMaterials.DEMONITE,
                4f,
                2f,
                FabricItemSettings().group(ExumItemGroup.GENERAL)
            )
        )

        val DEMONITE_HOE: Item = registerItem(
            "demonite_hoe",
            DemoniteHoeItem(
                ExumToolMaterials.DEMONITE,
                0,
                0f,
                FabricItemSettings().group(ExumItemGroup.GENERAL)
            )
        )

        val DEMONITE_SHOVEL: Item = registerItem(
            "demonite_shovel",
            DemoniteShovelItem(
                ExumToolMaterials.DEMONITE,
                0f,
                2f,
                FabricItemSettings().group(ExumItemGroup.GENERAL)
            )
        )

        val DEMONITE_PICKAXE: Item = registerItem(
            "demonite_pickaxe",
            DemonitePickaxeItem(
                ExumToolMaterials.DEMONITE,
                2,
                3f,
                FabricItemSettings().group(ExumItemGroup.GENERAL)
            )
        )

        // Armor

        val INCANTATIO_HELMET: Item = registerItem(
            "incantatio_helmet",
            ArmorItem(
                ExumArmorMaterials.INCANTATIO,
                EquipmentSlot.HEAD,
                FabricItemSettings().fireproof().rarity(Rarity.EPIC).group(ExumItemGroup.INCANTATIO)
            )
        )

        val INCANTATIO_CHEST: Item = registerItem(
            "incantatio_chest",
            ArmorItem(
                ExumArmorMaterials.INCANTATIO,
                EquipmentSlot.CHEST,
                FabricItemSettings().fireproof().rarity(Rarity.EPIC).group(ExumItemGroup.INCANTATIO)
            )
        )

        val INCANTATIO_LEGGINGS: Item = registerItem(
            "incantatio_leggings",
            ArmorItem(
                ExumArmorMaterials.INCANTATIO,
                EquipmentSlot.LEGS,
                FabricItemSettings().fireproof().rarity(Rarity.EPIC).group(ExumItemGroup.INCANTATIO)
            )
        )

        val INCANTATIO_BOOTS: Item = registerItem(
            "incantatio_boots",
            ArmorItem(
                ExumArmorMaterials.INCANTATIO,
                EquipmentSlot.FEET,
                FabricItemSettings().fireproof().rarity(Rarity.EPIC).group(ExumItemGroup.INCANTATIO)
            )
        )

        // Blocks

        val GRAPE_SEEDS: Item = registerItem(
            "grape_seeds", AliasedBlockItem(
                ExumBlocks.GRAPE_CROP,
                FabricItemSettings().group(ExumItemGroup.GENERAL)
            )
        )

        val GRAPE: Item = registerItem(
            "grape", Item(
                FabricItemSettings().group(ExumItemGroup.GENERAL).food(
                    FoodComponent.Builder().hunger(4).saturationModifier(4f).build()
                )
            )
        )

        private fun registerItem(name: String, item: Item) : Item {
            return Registry.register(Registry.ITEM, Identifier(Exum.MOD_ID, name), item)
        }

        fun registerModItems() {
            Exum.LOGGER.debug("Registering Mod Items for ${Exum.MOD_ID}")
        }
    }
}