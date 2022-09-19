package studio.axzet.exum.item.custom.demonite

import net.minecraft.item.ShovelItem
import net.minecraft.item.ToolMaterial

class DemoniteShovelItem: ShovelItem {
    constructor(material: ToolMaterial, attackDamage: Float, attackSpeed: Float, settings: Settings) : super(material, attackDamage, attackSpeed, settings)
}