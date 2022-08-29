package studio.axzet.exum.item

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import java.util.function.Supplier

enum class ExumArmorMaterials(
    name: String,
    durabilityMultiplier: Int,
    protectionAmounts: List<Int>,
    enchantability: Int,
    equipSound: SoundEvent,
    toughness: Float,
    knockbackResistance: Float,
    repairIngredient: Supplier<Ingredient>
): ArmorMaterial {

    INCANTATIO(
        "incantatio",
        37,
        listOf(3, 6, 8, 3),
        24,
        SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
        3.0F,
        0.1F,
        Supplier { Ingredient.ofItems(ExumItems.INCANTATIO) }
    );

    private val baseDurability: List<Int> = listOf(13, 15, 16, 11)
    private val materialName = name
    private val durabilityMultiplier = durabilityMultiplier
    private val protectionAmounts = protectionAmounts
    private val enchantability = enchantability
    private val equipSound = equipSound
    private val toughness = toughness
    private val knockbackResistance = knockbackResistance
    private val repairIngredientSupplier: Supplier<Ingredient> = repairIngredient

    override fun getDurability(slot: EquipmentSlot): Int {
        return baseDurability[slot.entitySlotId] * durabilityMultiplier
    }

    override fun getProtectionAmount(slot: EquipmentSlot): Int {
        return protectionAmounts[slot.entitySlotId]
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getEquipSound(): SoundEvent? {
        return equipSound
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredientSupplier.get()
    }

    override fun getName(): String {
        return materialName
    }

    override fun getToughness(): Float {
        return toughness
    }

    override fun getKnockbackResistance(): Float {
        return knockbackResistance
    }
}