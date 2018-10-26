package club.bweakfast.foodora.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.R
import club.bweakfast.foodora.getRandomRecipes
import club.bweakfast.foodora.recipe.RecipesAdapter
import club.bweakfast.foodora.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment() {
    @Inject
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FoodoraApp.daggerComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topRecipesGrid.recyclerView.isNestedScrollingEnabled = false
        topRecipesGrid.recyclerView.adapter = RecipesAdapter(getRandomRecipes(20), true)
        topRecipesGrid.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        if (userViewModel.isLoggedIn) {
            topRecommendations.visibility = View.VISIBLE
            topRecommendations.recyclerView.isNestedScrollingEnabled = false
            topRecommendations.recyclerView.adapter = RecipesAdapter(getRandomRecipes())
            topRecommendations.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        } else {
            topRecommendations.visibility = View.GONE
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
