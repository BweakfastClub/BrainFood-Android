package club.bweakfast.foodora.browse.category

import android.support.annotation.DrawableRes

/**
 * Created by silve on 3/8/2018.
 */

class Category(val name: CategoryName, val imageURL: String) {
    constructor(name: CategoryName, @DrawableRes imageID: Int) : this(name, "res:/$imageID")
}