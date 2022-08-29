package studio.axzet.exum.item.custom

import net.minecraft.item.ShovelItem
import net.minecraft.item.ToolMaterial

class DemoniteShovelItem: ShovelItem {
    constructor(material: ToolMaterial, attackDamage: Float, attackSpeed: Float, settings: Settings) : super(material, attackDamage, attackSpeed, settings)
}