package studio.axzet.exumenchantment.block.custom.incantatio

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.particle.DustParticleEffect
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.intprovider.IntProvider
import net.minecraft.world.World

class IncantatioOre: OreBlock {
    constructor(settings: Settings, experience: IntProvider) : super(settings, experience) {
        defaultState = defaultState.with(LIT, false)
    }

    companion object {
        val LIT: BooleanProperty = BooleanProperty.of("lit")

        private fun light(state: BlockState, world: World, pos: BlockPos) {
            spawnParticles(world, pos)
            if (!state.get(LIT) && !world.isClient) {
                world.setBlockState(pos, state.with(LIT, true) as BlockState)
            }
        }

        private fun spawnParticles(world: World, pos: BlockPos) {
            val d = 0.5625
            val random = world.random
            val var5 = Direction.values()
            val var6 = var5.size
            for (var7 in 0 until var6) {
                val direction = var5[var7]
                val blockPos = pos.offset(direction)
                if (!world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) {
                    val axis = direction.axis
                    val e =
                        if (axis === Direction.Axis.X) 0.5 + d * direction.offsetX.toDouble() else random.nextFloat()
                            .toDouble()
                    val f =
                        if (axis === Direction.Axis.Y) 0.5 + d * direction.offsetY.toDouble() else random.nextFloat()
                            .toDouble()
                    val g =
                        if (axis === Direction.Axis.Z) 0.5 + d * direction.offsetZ.toDouble() else random.nextFloat()
                            .toDouble()
                    world.addParticle(
                        DustParticleEffect.DEFAULT,
                        pos.x.toDouble() + e,
                        pos.y.toDouble() + f,
                        pos.z.toDouble() + g,
                        0.0,
                        0.0,
                        0.0
                    )
                }
            }
        }
    }

    override fun onBlockBreakStart(state: BlockState?, world: World?, pos: BlockPos?, player: PlayerEntity?) {
        if (state != null && world != null && pos != null) {
            light(state, world, pos)
        }
        super.onBlockBreakStart(state, world, pos, player)
    }

    override fun onSteppedOn(world: World?, pos: BlockPos?, state: BlockState?, entity: Entity?) {
        if (entity != null) {
            if (!entity.bypassesSteppingEffects()) {
                if (state != null && world != null && pos != null) {
                    light(state, world, pos)
                }
            }
        }

        super.onSteppedOn(world, pos, state, entity)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>?) {
        builder?.add(LIT)
    }
}