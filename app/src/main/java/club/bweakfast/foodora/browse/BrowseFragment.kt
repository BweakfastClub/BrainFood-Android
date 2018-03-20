package club.bweakfast.foodora.browse


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.R
import club.bweakfast.foodora.SpanningGridLayoutManager
import club.bweakfast.foodora.browse.category.CategoryAdapter
import kotlinx.android.synthetic.main.fragment_browse.*


/**
 * A simple [Fragment] subclass.
 */
class BrowseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_browse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryGrid.layoutManager = SpanningGridLayoutManager(context!!, 2)
        categoryGrid.adapter = CategoryAdapter()
    }

    companion object {
        fun newInstance() = BrowseFragment()
    }
}
