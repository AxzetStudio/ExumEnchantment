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