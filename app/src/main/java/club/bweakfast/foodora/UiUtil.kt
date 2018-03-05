package club.bweakfast.foodora

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

/**
 * Created by silve on 3/2/2018.
 */

fun AppCompatActivity.showFragment(
    fragment: Fragment,
    addToStack: Boolean = false,
    name: String? = "",
    setAnimations: (FragmentTransaction) -> Unit = {}
) {
    val transaction = supportFragmentManager.beginTransaction()

    setAnimations(transaction)
    transaction.replace(R.id.container, fragment)
    if (addToStack)
        transaction.addToBackStack(name)
    transaction.commit()
}