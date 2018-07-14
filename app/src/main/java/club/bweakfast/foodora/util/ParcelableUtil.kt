package club.bweakfast.foodora.util

import android.os.Parcel
import android.os.Parcelable

interface KParcelable : Parcelable {
    override fun describeContents() = 0
    override fun writeToParcel(parcel: Parcel, flags: Int)
}

inline fun <reified T> parcelableCreator(crossinline create: (Parcel) -> T): Parcelable.Creator<T> {
    return object : Parcelable.Creator<T> {
        override fun createFromParcel(source: Parcel) = create(source)
        override fun newArray(size: Int) = arrayOfNulls<T>(size)
    }
}

inline fun <reified T : Enum<T>> Parcel.readEnum() = readInt().let { if (it >= 0) enumValues<T>()[it] else null }

inline fun <T : Enum<T>> Parcel.writeEnum(value: T?) {
    writeInt(value?.ordinal ?: -1)
}

inline fun Parcel.readBoolean() = readByte() == 1.toByte()

inline fun Parcel.writeBoolean(value: Boolean) {
    writeByte(if (value) 1 else 0)
}