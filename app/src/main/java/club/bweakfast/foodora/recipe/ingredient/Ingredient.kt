package club.bweakfast.foodora.recipe.ingredient

import android.os.Parcel
import club.bweakfast.foodora.util.KParcelable
import club.bweakfast.foodora.util.parcelableCreator
import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("_id") val id: Int,
    val name: String,
    val grams: Float,
    val displayType: String
) : KParcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeFloat(grams)
        parcel.writeString(displayType)
    }

    companion object {
        val CREATOR = parcelableCreator(::Ingredient)
    }
}