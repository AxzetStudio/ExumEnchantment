package studio.axzet.exum.item.custom

import net.minecraft.item.Item
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ToolMaterial

class DemonitePickaxeItem: PickaxeItem {
    constructor(material: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) : super(material, attackDamage, attackSpeed, settings)
}