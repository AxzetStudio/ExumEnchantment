package studio.axzet.exum.item.custom.demonite

import net.minecraft.item.AxeItem
import net.minecraft.item.ToolMaterial

class DemontieAxeItem: AxeItem {
    constructor(material: ToolMaterial, attackDamage: Float, attackSpeed: Float, settings: Settings): super(material, attackDamage, attackSpeed, settings)
}