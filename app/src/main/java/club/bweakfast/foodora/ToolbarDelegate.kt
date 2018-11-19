package club.bweakfast.foodora

import android.support.v7.widget.Toolbar
import android.widget.ImageView
import club.bweakfast.foodora.util.showView
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class ToolbarDelegate(private val toolbar: Toolbar) {
    var message: String = ""
        set(value) {
            field = value
            toolbar.messageTxt.text = value
            showView(toolbar.messageTxt, value.isNotBlank())
        }

    var title: String = toolbar.context.getString(R.string.app_name)
        set(value) {
            field = value
            toolbar.titleTxt.text = value
        }

    var isSearchBoxVisible: Boolean = false
        set(show) {
            val showView = if (show) toolbar.searchBox else toolbar.messageTxt
            val hideView = if (show) toolbar.messageTxt else toolbar.searchBox
            showView(showView, true)
            showView(hideView, false)

            if (show) title = toolbar.context.getString(R.string.title_search)
        }

    var leftIcon: ImageView = toolbar.leftIcon

    var rightIcon: ImageView = toolbar.rightIcon

    var isLeftIconVisible: Boolean = true
        set(show) {
            showView(toolbar.leftIcon, show)
        }

    var isRightIconVisible: Boolean = true
        set(show) {
            showView(toolbar.rightIcon, show)
        }

    var isNotLoggedInMsgVisible: Boolean = true
        set(show) {
            showView(toolbar.notLoggedInMsg, show)
        }
}