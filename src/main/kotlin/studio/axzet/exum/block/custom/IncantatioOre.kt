package studio.axzet.exum.block.custom

import net.minecraft.block.OreBlock
import net.minecraft.util.math.intprovider.IntProvider


class IncantatioOre: OreBlock {
    constructor(settings: Settings, experience: IntProvider) : super(settings, experience)
}