package studio.axzet.exum.item.custom.incantatio

import net.minecraft.item.HoeItem
import net.minecraft.item.ToolMaterial

class IncantatioHoeItem: HoeItem {
    constructor(material: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) : super(material, attackDamage, attackSpeed, settings)

}