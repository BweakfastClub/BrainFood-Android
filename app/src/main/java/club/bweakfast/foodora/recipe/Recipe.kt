package club.bweakfast.foodora.recipe

import android.database.Cursor
import android.os.Parcel
import android.os.Parcelable
import androidx.core.database.getInt
import androidx.core.database.getString
import club.bweakfast.foodora.favourite.Favourite
import club.bweakfast.foodora.favourite.FavouriteType
import club.bweakfast.foodora.recipe.ingredient.Ingredient
import club.bweakfast.foodora.recipe.nutrition.NutritionValue
import club.bweakfast.foodora.util.KParcelable
import club.bweakfast.foodora.util.parcelableCreator
import club.bweakfast.foodora.util.readBoolean
import club.bweakfast.foodora.util.writeBoolean
import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("id") override val id: Int,
    val ingredients: List<Ingredient>,
    val title: String,
    val servings: Int,
    val prepMinutes: Int,
    val cookMinutes: Int,
    val readyMinutes: Int,
    @SerializedName("imageUrl") val imageURL: String,
    var isFavourite: Boolean = false
) : Favourite(id, FavouriteType.RECIPE), KParcelable {
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
        @JvmField val CREATOR = parcelableCreator(::Recipe)

        fun createFromCursor(cursor: Cursor, ingredients: List<Ingredient>): Recipe {
            with(cursor) {
                return Recipe(
                    getInt(RecipeDaoImpl.COLUMN_ID),
                    emptyList(),
                    getString(RecipeDaoImpl.COLUMN_TITLE),
                    getInt(RecipeDaoImpl.COLUMN_SERVINGS),
                    getInt(RecipeDaoImpl.COLUMN_PREP_MINS),
                    getInt(RecipeDaoImpl.COLUMN_COOK_MINS),
                    getInt(RecipeDaoImpl.COLUMN_READY_MINS),
                    getString(RecipeDaoImpl.COLUMN_IMG_URL)
                )
            }
        }
    }
}