package club.bweakfast.foodora

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import club.bweakfast.foodora.setup.SetupViewModel
import club.bweakfast.foodora.user.UserViewModel
import club.bweakfast.foodora.util.showView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

@SuppressLint("Registered")
open class CustomToolbarActivity : AppCompatActivity() {
    private lateinit var toolbarDelegate: ToolbarDelegate

    protected var message: String
        get() = toolbarDelegate.message
        set(value) {
            toolbarDelegate.message = value
        }

    protected var title: String
        get() = toolbarDelegate.title
        set(value) {
            toolbarDelegate.title = value
        }

    @Inject
    lateinit var userViewModel: UserViewModel

    @Inject
    lateinit var setupViewModel: SetupViewModel

    protected fun onCreate(savedInstanceState: Bundle?, @LayoutRes layoutID: Int) {
        super.onCreate(savedInstanceState)
        setContentView(layoutID)

        FoodoraApp.daggerComponent.inject(this)

        toolbarDelegate = ToolbarDelegate(toolbar as Toolbar)

        setSupportActionBar(toolbar as Toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    protected fun showSearchBox(show: Boolean) {
        toolbarDelegate.isSearchBoxVisible = show
    }

    protected fun showLeftIcon(show: Boolean) {
        toolbarDelegate.isLeftIconVisible = show
    }

    protected fun showRightIcon(show: Boolean) {
        toolbarDelegate.isRightIconVisible = show
    }

    override fun onResume() {
        super.onResume()

        toolbarDelegate.isNotLoggedInMsgVisible = !userViewModel.isLoggedIn
    }
}