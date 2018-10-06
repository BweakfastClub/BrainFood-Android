package club.bweakfast.foodora

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import club.bweakfast.foodora.home.HomeFragment
import club.bweakfast.foodora.search.SearchFragment
import club.bweakfast.foodora.user.ProfileActivity
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
                    message = getString(R.string.message_home)
                    title = getString(R.string.app_name)
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

        profileIcon.setOnClickListener { Intent(this, ProfileActivity::class.java).apply { startActivity(this) } }
    }
}
