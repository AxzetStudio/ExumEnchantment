package studio.axzet.exumenchantment.recipe

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.recipe.*
import net.minecraft.util.Identifier
import net.minecraft.util.JsonHelper
import net.minecraft.util.collection.DefaultedList
import net.minecraft.world.World


class AncientEnchanterRecipe: Recipe<SimpleInventory> {

    private val id: Identifier
    private val output: ItemStack
    private val recipeItems: DefaultedList<Ingredient>

    constructor(id: Identifier, output: ItemStack, recipeItems: DefaultedList<Ingredient>) {
        this.id = id
        this.output = output
        this.recipeItems = recipeItems
    }

    companion object {
        class Type : RecipeType<AncientEnchanterRecipe> {
            companion object {
                val INSTANCE = Type()
                const val ID = "ancient_enchanter"
            }
        }

        class Serializer : RecipeSerializer<AncientEnchanterRecipe> {
            companion object {
                val INSTANCE = Serializer()
                const val ID = "ancient_enchanter"
            }

            // Json
            override fun read(id: Identifier, json: JsonObject): AncientEnchanterRecipe {
                val output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"))
                val ingredients: JsonArray = JsonHelper.getArray(json, "ingredients")
                val inputs = DefaultedList.ofSize(2, Ingredient.EMPTY)
                for (i in inputs.indices) {
                    inputs[i] = Ingredient.fromJson(ingredients.get(i))
                }
                return AncientEnchanterRecipe(id, output, inputs)
            }

            // Networking
            override fun read(id: Identifier, buf: PacketByteBuf): AncientEnchanterRecipe {
                val inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY)
                for (i in inputs.indices) {
                    inputs[i] = Ingredient.fromPacket(buf)
                }
                val output = buf.readItemStack()
                return AncientEnchanterRecipe(id, output, inputs)
            }

            override fun write(buf: PacketByteBuf, recipe: AncientEnchanterRecipe) {
                buf.writeInt(recipe.ingredients.size)
                for (ing in recipe.ingredients) {
                    ing.write(buf)
                }
                buf.writeItemStack(recipe.getOutput())
            }
        }
    }

    override fun matches(inventory: SimpleInventory, world: World): Boolean {
        if (world.isClient()) {
            return false
        }

        var ingredientsMatch = true

        for (i: Int in this.recipeItems.indices) {
            if (!(this.recipeItems[i].test(inventory.getStack(i)))) {
                ingredientsMatch = false
            }
        }

        return ingredientsMatch
    }

    override fun craft(inventory: SimpleInventory): ItemStack {
        return this.output
    }

    override fun fits(width: Int, height: Int): Boolean {
        return true
    }

    override fun getOutput(): ItemStack {
        return this.output.copy()
    }

    override fun getId(): Identifier {
        return this.id
    }

    override fun getSerializer(): RecipeSerializer<*> {
        return Serializer.INSTANCE
    }

    override fun getType(): RecipeType<*> {
        return Type.INSTANCE
    }

}