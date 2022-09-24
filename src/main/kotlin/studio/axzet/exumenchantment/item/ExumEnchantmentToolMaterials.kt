package studio.axzet.exumenchantment.item

import net.fabricmc.yarn.constants.MiningLevels
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import java.util.function.Supplier

enum class ExumEnchantmentToolMaterials(
    miningLevel: Int,
    itemDurability: Int,
    miningSpeed: Float,
    attackDamage: Float,
    enchantability: Int,
    repairIngredient: Supplier<Ingredient>
) : ToolMaterial {

    INCANTATIO(MiningLevels.NETHERITE, 2000, 10F, 4F, 24, Supplier { Ingredient.ofItems(ExumEnchantmentItems.INCANTATIO) }),

    DEMONITE(MiningLevels.NETHERITE, 2500, 12F, 6F, 24, Supplier { Ingredient.ofItems(ExumEnchantmentItems.DEMONITE_INGOT) });


    private val miningLevel = miningLevel
    private val itemDurability = itemDurability
    private val miningSpeed = miningSpeed
    private val attackDamage = attackDamage
    private val enchantability = enchantability
    private val repairIngredient: Supplier<Ingredient> = repairIngredient

    override fun getDurability(): Int {
        return itemDurability
    }

    override fun getMiningSpeedMultiplier(): Float {
        return miningSpeed
    }

    override fun getAttackDamage(): Float {
        return attackDamage
    }

    override fun getMiningLevel(): Int {
        return miningLevel
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient? {
        return repairIngredient.get()
    }
}