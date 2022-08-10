package studio.axzet.exum.block.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.CropBlock
import net.minecraft.item.ItemConvertible
import net.minecraft.state.StateManager
import net.minecraft.state.property.IntProperty
import studio.axzet.exum.item.ExumItems

class GrapeCropBlock: CropBlock {

    companion object {
        val AGE: IntProperty = IntProperty.of("age", 0, 6)
    }

    constructor(settings: Settings): super(settings)

    override fun getSeedsItem(): ItemConvertible {
        return ExumItems.GRAPE_SEEDS
    }

    override fun getMaxAge(): Int {
        return 6;
    }

    override fun getAgeProperty(): IntProperty {
        return AGE
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>?) {
        builder?.add(AGE)
    }
}