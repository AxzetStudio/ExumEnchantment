package studio.axzet.exumenchantment.util

import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.Enchantments

class ExumEnchantmentUtil {
    companion object {
        fun getEnchantmentById(id: String): Enchantment {
            return when(id.split(":")[1]) {
                "efficiency"            -> Enchantments.EFFICIENCY
                "unbreaking"            -> Enchantments.UNBREAKING
                "fortune"               -> Enchantments.FORTUNE
                "bane_of_arthropods"    -> Enchantments.BANE_OF_ARTHROPODS
                "fire_aspect"           -> Enchantments.FIRE_ASPECT
                "knockback"             -> Enchantments.KNOCKBACK
                "looting"               -> Enchantments.LOOTING
                "sharpness"             -> Enchantments.SHARPNESS
                "smite"                 -> Enchantments.SMITE
                "sweeping"              -> Enchantments.SWEEPING
                "power"                 -> Enchantments.POWER
                "punch"                 -> Enchantments.PUNCH
                "quick_charge"          -> Enchantments.QUICK_CHARGE
                "piercing"              -> Enchantments.PIERCING
                "blast_protection"      -> Enchantments.BLAST_PROTECTION
                "feather_falling"       -> Enchantments.FEATHER_FALLING
                "fire_protection"       -> Enchantments.FIRE_PROTECTION
                "projectile_protection" -> Enchantments.PROJECTILE_PROTECTION
                "protection"            -> Enchantments.PROTECTION
                "respiration"           -> Enchantments.RESPIRATION
                "thorns"                -> Enchantments.THORNS
                "lure"                  -> Enchantments.LURE
                "luck_of_the_sea"       -> Enchantments.LUCK_OF_THE_SEA
                "impaling"              -> Enchantments.IMPALING
                else -> Enchantments.MENDING
            }
        }

        fun parseEnchantmentLevel(lvl: String): Int {

            var level: Int = lvl.substring(0, lvl.length - 1).toInt()

            if (level > 10) {
                level = 10
            }

            return level
        }
    }
}