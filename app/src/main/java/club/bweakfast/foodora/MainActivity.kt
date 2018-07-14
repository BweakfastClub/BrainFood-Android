package club.bweakfast.foodora

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import club.bweakfast.foodora.browse.BrowseFragment
import club.bweakfast.foodora.search.SearchFragment
import club.bweakfast.foodora.util.showFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tab_browse -> showFragment(BrowseFragment.newInstance())
                R.id.tab_search -> showFragment(SearchFragment.newInstance())
            }
            true
        }
        bottomBar.selectedItemId = R.id.tab_home
    }
}
