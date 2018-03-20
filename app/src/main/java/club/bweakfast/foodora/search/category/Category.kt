package club.bweakfast.foodora.search.category

import android.support.annotation.DrawableRes

/**
 * Created by silve on 3/8/2018.
 */

class Category(val name: String, val imageURL: String) {
    constructor(name: String, @DrawableRes imageID: Int): this(name, "res:/$imageID")
}