package studio.axzet.exumenchantment.item.custom.incantatio

import net.minecraft.item.PickaxeItem
import net.minecraft.item.ToolMaterial

class IncantatioPickaxeItem: PickaxeItem {
    constructor(material: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) : super(material, attackDamage, attackSpeed, settings)

}