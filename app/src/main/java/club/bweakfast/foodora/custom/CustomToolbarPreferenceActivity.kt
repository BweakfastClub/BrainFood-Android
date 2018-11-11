package club.bweakfast.foodora.custom

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.preference.PreferenceActivity
import android.support.annotation.LayoutRes
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import android.support.v7.widget.ViewStubCompat
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import club.bweakfast.foodora.R
import club.bweakfast.foodora.ToolbarDelegate
import club.bweakfast.foodora.util.showView

/**
 * A [android.preference.PreferenceActivity] which implements and proxies the necessary calls
 * to be used with AppCompat.
 */
abstract class CustomToolbarPreferenceActivity : PreferenceActivity() {
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

    protected val leftIcon: ImageView
        get() = toolbarDelegate.leftIcon

    protected val rightIcon: ImageView
        get() = toolbarDelegate.rightIcon

    override fun onCreate(savedInstanceState: Bundle?) {
        delegate.installViewFactory()
        delegate.onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        delegate.onPostCreate(savedInstanceState)

        initToolbar()
    }

    @SuppressLint("RestrictedApi")
    private fun initToolbar() {
        findViewById<ViewStubCompat>(R.id.action_mode_bar_stub).apply {
            layoutResource = R.layout.layout_toolbar
            inflate()
        }
        val toolbar = findViewById<Toolbar>(R.id.action_mode_bar)

        toolbarDelegate = ToolbarDelegate(toolbar)
        toolbarDelegate.isLeftIconVisible = false
        toolbarDelegate.isRightIconVisible = false
        toolbarDelegate.isSearchBoxVisible = false
        toolbarDelegate.isNotLoggedInMsgVisible = false
    }

    protected fun showToolbar(show: Boolean) {
        val toolbar = findViewById<Toolbar>(R.id.action_mode_bar)
        showView(toolbar, show)
    }

    val supportActionBar: ActionBar?
        get() = delegate.supportActionBar

    fun setSupportActionBar(toolbar: Toolbar?) {
        delegate.setSupportActionBar(toolbar)
    }

    override fun getMenuInflater(): MenuInflater {
        return delegate.menuInflater
    }

    override fun setContentView(@LayoutRes layoutResID: Int) {
        delegate.setContentView(layoutResID)
    }

    override fun setContentView(view: View) {
        delegate.setContentView(view)
    }

    override fun setContentView(view: View, params: ViewGroup.LayoutParams) {
        delegate.setContentView(view, params)
    }

    override fun addContentView(view: View, params: ViewGroup.LayoutParams) {
        delegate.addContentView(view, params)
    }

    override fun onPostResume() {
        super.onPostResume()
        delegate.onPostResume()
    }

    override fun onTitleChanged(title: CharSequence, color: Int) {
        super.onTitleChanged(title, color)
        delegate.setTitle(title)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        delegate.onConfigurationChanged(newConfig)
    }

    override fun onStop() {
        super.onStop()
        delegate.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        delegate.onDestroy()
    }

    override fun invalidateOptionsMenu() {
        delegate.invalidateOptionsMenu()
    }

    private val delegate: AppCompatDelegate by lazy {
        AppCompatDelegate.create(this, null)
    }
}
