package club.bweakfast.foodora.favourite

import com.google.gson.annotations.SerializedName

abstract class Favourite(@SerializedName("") open val id: Int, val type: FavouriteType)