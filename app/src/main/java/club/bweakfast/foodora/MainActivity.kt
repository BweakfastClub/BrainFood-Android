package club.bweakfast.foodora

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import club.bweakfast.foodora.search.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(SearchFragment.newInstance())
    }
}
