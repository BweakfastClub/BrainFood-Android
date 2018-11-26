package club.bweakfast.foodora.recipe

import android.os.Parcel
import club.bweakfast.foodora.recipe.ingredient.Ingredient
import club.bweakfast.foodora.recipe.nutrition.NutritionValue
import club.bweakfast.foodora.util.KParcelable
import club.bweakfast.foodora.util.parcelableCreator
import club.bweakfast.foodora.util.readBoolean
import club.bweakfast.foodora.util.writeBoolean
import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("id") val id: Int,
    val ingredients: List<Ingredient>,
    val title: String,
    val servings: Int,
    val prepMinutes: Int,
    val cookMinutes: Int,
    val readyMinutes: Int,
    @SerializedName("imageUrl") val imageURL: String,
    var isFavourite: Boolean = false
) : KParcelable {
    var nutrition = mutableMapOf<String, NutritionValue>()

    private constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.createTypedArrayList(Ingredient.CREATOR),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readBoolean()
    ) {
        parcel.readMap(nutrition, NutritionValue::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        with(parcel) {
            writeInt(id)
            writeTypedList(ingredients)
            writeString(title)
            writeInt(servings)
            writeInt(prepMinutes)
            writeInt(cookMinutes)
            writeInt(readyMinutes)
            writeString(imageURL)
            writeBoolean(isFavourite)
            writeMap(nutrition)
        }
    }

    companion object {
        @JvmField
        val CREATOR = parcelableCreator(::Recipe)
    }
}