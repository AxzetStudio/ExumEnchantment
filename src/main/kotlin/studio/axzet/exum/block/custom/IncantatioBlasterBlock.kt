package studio.axzet.exum.block.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.HorizontalFacingBlock
import net.minecraft.block.ShapeContext
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.DirectionProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.BlockMirror
import net.minecraft.util.BlockRotation
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView

class IncantatioBlasterBlock: HorizontalFacingBlock {

    companion object {
        val FACING: DirectionProperty = Properties.HORIZONTAL_FACING

        private var SHAPE: VoxelShape = Block.createCuboidShape(0.0,0.0,0.0, 16.0, 12.0, 16.0)
    }

    constructor(settings: Settings) : super(settings)

    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return SHAPE
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState? {
        return this.defaultState.with(FACING, ctx.playerFacing.opposite)
    }

    override fun rotate(state: BlockState, rotation: BlockRotation): BlockState {
        return state.with(FACING, rotation.rotate(state.get(FACING)))
    }

    override fun mirror(state: BlockState, mirror: BlockMirror): BlockState {
        return state.rotate(mirror.getRotation(state.get(FACING)))
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>?) {
        builder?.add(FACING)
    }
}