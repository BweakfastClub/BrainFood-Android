package club.bweakfast.foodora

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*

@SuppressLint("Registered")
open class CustomToolbarActivity : AppCompatActivity() {
    protected var message: String = ""
        set(value) {
            field = value
            messageTxt.text = value
        }
    protected var title = "BrainFood"
        set(value) {
            field = value
            titleTxt.text = value
        }

    protected fun onCreate(savedInstanceState: Bundle?, @LayoutRes layoutID: Int) {
        super.onCreate(savedInstanceState)
        setContentView(layoutID)

        setSupportActionBar(toolbar as Toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    protected fun showSearchBox(show: Boolean) {
        val showView = if (show) searchBox else messageTxt
        val hideView = if (show) messageTxt else searchBox
        showView.visibility = View.VISIBLE
        hideView.visibility = View.GONE

        title = getString(R.string.title_search)
    }
}