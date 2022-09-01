package studio.axzet.exum.util

import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.Enchantments

class ExumEnchantmentUtil {
    companion object {
        fun getEnchantmentById(id: String): Enchantment {
            return when(id.split(":")[1]) {
                "efficiency"         -> Enchantments.EFFICIENCY
                "unbreaking"         -> Enchantments.UNBREAKING
                "fortune"            -> Enchantments.FORTUNE
                "bane_of_arthropods" -> Enchantments.BANE_OF_ARTHROPODS
                "fire_aspect"        -> Enchantments.FIRE_ASPECT
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