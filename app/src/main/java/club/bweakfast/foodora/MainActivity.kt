package club.bweakfast.foodora

import android.annotation.SuppressLint
import android.os.Bundle
import club.bweakfast.foodora.home.HomeFragment
import club.bweakfast.foodora.search.SearchFragment
import club.bweakfast.foodora.util.listenForChanges
import club.bweakfast.foodora.util.showFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : CustomToolbarActivity() {
    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState, R.layout.activity_main)

        bottomBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tab_home -> {
                    showFragment(HomeFragment.newInstance())
                    showSearchBox(false)
                    message = "Good morning! In the mood for some new breakfast ideas?"
                }
                R.id.tab_search -> {
                    val fragment = SearchFragment.newInstance()
                    fragment.searchListener = searchBox.listenForChanges()
                    searchBox.requestFocus()
                    showFragment(fragment)
                    showSearchBox(true)
                }
            }
            true
        }
        bottomBar.selectedItemId = R.id.tab_home
    }
}
