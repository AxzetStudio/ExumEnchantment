package studio.axzet.exum.painting

import net.minecraft.entity.decoration.painting.PaintingVariant
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import studio.axzet.exum.Exum

class ExumPaintings {
    companion object {

        val SUNSET: PaintingVariant = registerPainting("sunset", PaintingVariant(32, 16))
        val PLANT: PaintingVariant = registerPainting("plant", PaintingVariant(16, 16))
        val WANDERER: PaintingVariant = registerPainting("wanderer", PaintingVariant(16, 32))

        private fun registerPainting(name: String, paintingVariant: PaintingVariant): PaintingVariant {
            return Registry.register(
                Registry.PAINTING_VARIANT,
                Identifier(Exum.MOD_ID, name),
                paintingVariant
            )
        }

        fun registerPaintings() {
            Exum.LOGGER.debug("Registering Paintings for ${Exum.MOD_ID}")
        }
    }
}