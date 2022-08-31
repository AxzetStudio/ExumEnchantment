package studio.axzet.exum.recipe

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import studio.axzet.exum.Exum

class ExumRecipes {
    companion object {
        fun registerRecipes() {
            Registry.register(
                Registry.RECIPE_SERIALIZER, Identifier(Exum.MOD_ID, AncientEnchanterRecipe.Companion.Serializer.ID),
                AncientEnchanterRecipe.Companion.Serializer.INSTANCE
            )
            Registry.register(
                Registry.RECIPE_TYPE, Identifier(Exum.MOD_ID, AncientEnchanterRecipe.Companion.Type.ID),
                AncientEnchanterRecipe.Companion.Type.INSTANCE
            )
        }
    }
}