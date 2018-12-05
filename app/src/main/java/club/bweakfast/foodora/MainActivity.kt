package club.bweakfast.foodora

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import club.bweakfast.foodora.auth.AuthenticationActivity
import club.bweakfast.foodora.custom.CustomToolbarActivity
import club.bweakfast.foodora.home.HomeFragment
import club.bweakfast.foodora.plan.MealPlanFragment
import club.bweakfast.foodora.search.SearchFragment
import club.bweakfast.foodora.settings.SettingsActivity
import club.bweakfast.foodora.user.ProfileActivity
import club.bweakfast.foodora.util.listenForChanges
import club.bweakfast.foodora.util.showFragment
import club.bweakfast.foodora.util.showView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : CustomToolbarActivity() {
    private var currentTab: Int? = null

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState, R.layout.activity_main)

        bottomBar.setOnNavigationItemSelectedListener {
            if (currentTab == it.itemId) false
            else {
                currentTab = it.itemId
                when (it.itemId) {
                    R.id.tab_home -> {
                        val fragment = HomeFragment.newInstance()
                        showFragment(fragment)
                        showSearchBox(false)
                        message = getString(R.string.message_home)
                        title = getString(R.string.app_name)
                    }
                    R.id.tab_search -> {
                        val query = searchBox.text.toString()
                        searchViewModel.searchListener = searchBox.listenForChanges(query)
                        val fragment = SearchFragment.newInstance(query)
                        searchBox.requestFocus()
                        showFragment(fragment)
                        showSearchBox(true)
                    }
                    R.id.tab_plan -> {
                        val fragment = MealPlanFragment.newInstance()
                        showFragment(fragment)
                        showSearchBox(false)
                        message = getString(R.string.message_meal_plan)
                        title = getString(R.string.title_meal_plan)
                    }
                }
                true
            }
        }
        bottomBar.selectedItemId = R.id.tab_home

        leftIcon.setOnClickListener {
            val nextScreen = if (userViewModel.isLoggedIn) ProfileActivity::class.java else AuthenticationActivity::class.java
            Intent(this, nextScreen).apply { startActivity(this) }
        }

        showView(rightIcon, userViewModel.isLoggedIn)
        if (userViewModel.isLoggedIn) {
            rightIcon.setOnClickListener { Intent(this, SettingsActivity::class.java).apply { startActivity(this) } }
        } else {
            bottomBar.menu.removeItem(R.id.tab_plan)
        }
    }

    override fun onDestroy() {
        if (searchViewModel.isSearchListenerInitialized()) searchViewModel.searchDisposable.dispose()
        super.onDestroy()
    }
}
