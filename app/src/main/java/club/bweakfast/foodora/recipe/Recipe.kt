package club.bweakfast.foodora.recipe

import android.os.Parcel
import android.os.Parcelable

data class Recipe(
    val ingredients: List<Ingredient>,
    val title: String,
    val servings: Int,
    val prepMinutes: Int,
    val cookMinutes: Int,
    val readyMinutes: Int,
    val imageURL: String
) : Parcelable {
    var id = -1
    var nutrition = mutableMapOf<String, NutritionValue>()

    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(Ingredient),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
        id = parcel.readInt()
        parcel.readMap(nutrition, NutritionValue::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(ingredients)
        parcel.writeString(title)
        parcel.writeInt(servings)
        parcel.writeInt(prepMinutes)
        parcel.writeInt(cookMinutes)
        parcel.writeInt(readyMinutes)
        parcel.writeString(imageURL)
        parcel.writeInt(id)
        parcel.writeMap(nutrition)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}