package studio.axzet.exum.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class AncientEnchanter: Block {
    constructor(settings: Settings) : super(settings)

    override fun onUse(
        state: BlockState?,
        world: World?,
        pos: BlockPos?,
        player: PlayerEntity?,
        hand: Hand?,
        hit: BlockHitResult?
    ): ActionResult {
        if (world != null && world.isClient) {
            player?.sendMessage(Text.of("Hello! worl... pvto el que lo lea"), false)
        }

        return ActionResult.SUCCESS
    }
}