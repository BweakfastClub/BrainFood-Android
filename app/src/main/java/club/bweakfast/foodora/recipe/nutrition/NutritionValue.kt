package club.bweakfast.foodora.recipe.nutrition

import android.os.Parcel
import club.bweakfast.foodora.util.KParcelable
import club.bweakfast.foodora.util.parcelableCreator
import club.bweakfast.foodora.util.readBoolean
import club.bweakfast.foodora.util.writeBoolean

data class NutritionValue(
    val name: String,
    val amount: Float,
    val unit: String?,
    val displayValue: String?,
    val dailyValue: String?,
    val isCompleteData: Boolean
) : KParcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readBoolean()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        with(parcel) {
            writeString(name)
            writeFloat(amount)
            writeString(unit)
            writeString(displayValue)
            writeString(dailyValue)
            writeBoolean(isCompleteData)
        }
    }

    companion object {
        val CREATOR = parcelableCreator(::NutritionValue)
    }
}