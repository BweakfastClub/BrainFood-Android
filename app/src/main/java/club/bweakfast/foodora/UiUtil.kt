package club.bweakfast.foodora

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import io.reactivex.Observable

/**
 * Created by silve on 3/2/2018.
 */

fun FragmentActivity.showFragment(
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

fun EditText.listenForChanges(): Observable<String> {
    var currentQuery = ""
    return Observable.create {
        this.addTextChangedListener(object : TextListener() {
            override fun afterTextChanged(s: Editable) {
                super.afterTextChanged(s)
                val query = s.toString()
                if (currentQuery != query) {
                    currentQuery = query
                    it.onNext(query)
                }
            }
        })
    }
}

open class TextListener: TextWatcher {
    override fun afterTextChanged(s: Editable) {}

    override fun beforeTextChanged(s: CharSequence?, start: Int, end: Int, count: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, end: Int, count: Int) {}
}