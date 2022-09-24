package studio.axzet.exumenchantment.item.custom.demonite

import net.minecraft.item.PickaxeItem
import net.minecraft.item.ToolMaterial

class DemonitePickaxeItem: PickaxeItem {
    constructor(material: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) : super(material, attackDamage, attackSpeed, settings)
}