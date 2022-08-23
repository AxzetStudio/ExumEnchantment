package studio.axzet.exum.block.custom

import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.state.StateManager
import net.minecraft.state.property.DirectionProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.*
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.World
import studio.axzet.exum.block.entity.ExumBlockEntities
import studio.axzet.exum.block.entity.IncantatioBlasterBlockEntity

class IncantatioBlasterBlock: BlockWithEntity, BlockEntityProvider {

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

    /* BLOCK ENTITY */

    override fun getRenderType(state: BlockState): BlockRenderType {
        return BlockRenderType.MODEL
    }

    override fun onStateReplaced(
        state: BlockState,
        world: World,
        pos: BlockPos,
        newState: BlockState,
        moved: Boolean
    ) {
        if (state.block != newState.block) {
            var blockEntity: BlockEntity? = world.getBlockEntity(pos)
            if (blockEntity is IncantatioBlasterBlockEntity) {
                ItemScatterer.spawn(world, pos, blockEntity as IncantatioBlasterBlockEntity)
                world.updateComparators(pos, this)
            }
            super.onStateReplaced(state, world, pos, newState, moved)
        }
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        if (!world.isClient) {
            var screenHandlerFactory: NamedScreenHandlerFactory? = state.createScreenHandlerFactory(world, pos)

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory)
            }
        }

        return ActionResult.SUCCESS
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity? {
        return IncantatioBlasterBlockEntity(pos, state)
    }

    override fun <T : BlockEntity> getTicker(
        world: World,
        state: BlockState,
        type: BlockEntityType<T>
    ): BlockEntityTicker<T>? {
        return checkType(type, ExumBlockEntities.INCANTATIO_BLASTER, IncantatioBlasterBlockEntity::tick)
    }
}