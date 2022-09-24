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

class AncientInfuserRecipe: Recipe<SimpleInventory> {

    private val id: Identifier
    private val output: ItemStack
    private val recipeItem: DefaultedList<Ingredient>

    constructor(id: Identifier, output: ItemStack, recipeItem: DefaultedList<Ingredient>) {
        this.id = id
        this.output = output
        this.recipeItem = recipeItem
    }

    companion object {
        class Type : RecipeType<AncientInfuserRecipe> {
            companion object {
                val INSTANCE = Type()
                val ID = "ancient_infuser"
            }
        }

        class Serializer: RecipeSerializer<AncientInfuserRecipe> {
            companion object {
                val INSTANCE = Serializer()
                val ID = "ancient_infuser"
            }

            // Json
            override fun read(id: Identifier, json: JsonObject): AncientInfuserRecipe {
                val output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"))
                val ingredients: JsonArray = JsonHelper.getArray(json, "ingredients")
                val inputs = DefaultedList.ofSize(7, Ingredient.EMPTY)
                for (i in inputs.indices) {
                    inputs[i] = Ingredient.fromJson(ingredients.get(i))
                }
                return AncientInfuserRecipe(id, output, inputs)
            }

            // Networking
            override fun read(id: Identifier, buf: PacketByteBuf): AncientInfuserRecipe {
                val inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY)
                for (i in inputs.indices) {
                    inputs[i] = Ingredient.fromPacket(buf)
                }
                val output = buf.readItemStack()
                return AncientInfuserRecipe(id, output, inputs)
            }

            override fun write(buf: PacketByteBuf, recipe: AncientInfuserRecipe) {
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

        var ingredientsMatch: Boolean = true

        for (i: Int in this.recipeItem.indices) {
            if (!(this.recipeItem[i].test(inventory.getStack(i)))) {
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