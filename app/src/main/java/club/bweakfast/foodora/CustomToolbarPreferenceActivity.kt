package club.bweakfast.foodora

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceActivity
import android.support.annotation.LayoutRes
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.LinearLayout



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

    override fun onCreate(savedInstanceState: Bundle?) {
        delegate.installViewFactory()
        delegate.onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        delegate.onPostCreate(savedInstanceState)

        val root = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            findViewById<View>(android.R.id.list_container).parent as LinearLayout
        } else {
            findViewById<View>(android.R.id.list).parent.parent.parent as LinearLayout
        }
        val toolbar = LayoutInflater.from(this).inflate(R.layout.layout_toolbar, root, false)
        root.addView(toolbar, 0) // insert at top

        toolbarDelegate = ToolbarDelegate(toolbar as Toolbar)
        initToolbar()
    }

    private fun initToolbar() {
        toolbarDelegate.isLeftIconVisible = false
        toolbarDelegate.isRightIconVisible = false
        toolbarDelegate.isSearchBoxVisible = false
        toolbarDelegate.isNotLoggedInMsgVisible = false
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
