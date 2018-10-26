package club.bweakfast.foodora

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import club.bweakfast.foodora.user.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

@SuppressLint("Registered")
open class CustomToolbarActivity : AppCompatActivity() {
    protected var message: String = ""
        set(value) {
            field = value
            messageTxt.text = value
            showView(messageTxt, value.isNotBlank())
        }
    protected var title = "BrainFood"
        set(value) {
            field = value
            titleTxt.text = value
        }

    @Inject
    lateinit var userViewModel: UserViewModel

    protected fun onCreate(savedInstanceState: Bundle?, @LayoutRes layoutID: Int) {
        super.onCreate(savedInstanceState)
        setContentView(layoutID)

        FoodoraApp.daggerComponent.inject(this)

        setSupportActionBar(toolbar as Toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    protected fun showSearchBox(show: Boolean) {
        val showView = if (show) searchBox else messageTxt
        val hideView = if (show) messageTxt else searchBox
        showView(showView, true)
        showView(hideView, false)

        title = getString(R.string.title_search)
    }

    protected fun showLeftIcon(show: Boolean) {
        showView(leftIcon, show)
    }

    protected fun showRightIcon(show: Boolean) {
        showView(rightIcon, show)
    }

    private fun showView(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun onResume() {
        super.onResume()

        showView(notLoggedInMsg, !userViewModel.isLoggedIn)
    }
}