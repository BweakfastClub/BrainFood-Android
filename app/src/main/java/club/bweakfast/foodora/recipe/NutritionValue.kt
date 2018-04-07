package club.bweakfast.foodora.recipe

import android.os.Parcel
import android.os.Parcelable

data class NutritionValue(
    val name: String?,
    val amount: Float,
    val unit: String?,
    val displayValue: String?,
    val dailyValue: String?,
    val isCompleteData: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeFloat(amount)
        parcel.writeString(unit)
        parcel.writeString(displayValue)
        parcel.writeString(dailyValue)
        parcel.writeByte(if (isCompleteData) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NutritionValue> {
        override fun createFromParcel(parcel: Parcel): NutritionValue {
            return NutritionValue(parcel)
        }

        override fun newArray(size: Int): Array<NutritionValue?> {
            return arrayOfNulls(size)
        }
    }
}