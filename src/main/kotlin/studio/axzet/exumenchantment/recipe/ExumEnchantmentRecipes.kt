package studio.axzet.exumenchantment.recipe

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import studio.axzet.exumenchantment.ExumEnchantment

class ExumEnchantmentRecipes {
    companion object {
        fun registerRecipes() {
            // Ancient Enchanter Recipe
            Registry.register(
                Registry.RECIPE_SERIALIZER, Identifier(ExumEnchantment.MOD_ID, AncientEnchanterRecipe.Companion.Serializer.ID),
                AncientEnchanterRecipe.Companion.Serializer.INSTANCE
            )
            Registry.register(
                Registry.RECIPE_TYPE, Identifier(ExumEnchantment.MOD_ID, AncientEnchanterRecipe.Companion.Type.ID),
                AncientEnchanterRecipe.Companion.Type.INSTANCE
            )

            // Ancient Infuser Recipe
            Registry.register(
                Registry.RECIPE_SERIALIZER, Identifier(ExumEnchantment.MOD_ID, AncientInfuserRecipe.Companion.Serializer.ID),
                AncientInfuserRecipe.Companion.Serializer.INSTANCE
            )
            Registry.register(
                Registry.RECIPE_TYPE, Identifier(ExumEnchantment.MOD_ID, AncientInfuserRecipe.Companion.Type.ID),
                AncientInfuserRecipe.Companion.Type.INSTANCE
            )
        }
    }
}