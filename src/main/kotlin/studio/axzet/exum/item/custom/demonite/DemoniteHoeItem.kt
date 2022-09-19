package studio.axzet.exum.item.custom.demonite

import net.minecraft.item.HoeItem
import net.minecraft.item.ToolMaterial

class DemoniteHoeItem: HoeItem {
    constructor(material: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) : super(material, attackDamage, attackSpeed, settings)
}