package club.bweakfast.foodora

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_processing.*

private const val ARG_MESSAGE = "message"

/**
 * A simple [Fragment] subclass.
 * Use the [ProcessingFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ProcessingFragment : Fragment() {
    private lateinit var message: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        message = arguments.getString(ARG_MESSAGE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_processing, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingMessage.text = message
    }

    companion object {
        @JvmStatic
        fun newInstance(message: String) = ProcessingFragment().apply {
            val args = Bundle().apply {
                putString(ARG_MESSAGE, message)
            }
            arguments = args
        }
    }
}
