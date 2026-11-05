package com.example.fragmentyautori

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AutorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AutorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_autor, container, false)
        val autor = AutorFragmentArgs.fromBundle(requireArguments()).autorName
        var desc = ""

        when (autor) {
            resources.getString(R.string.autor1) -> {
                desc = resources.getStringArray(R.array.authors_list_desc)[0]
            }
            resources.getString(R.string.autor2) -> {
                desc = resources.getStringArray(R.array.authors_list_desc)[1]
            }
            resources.getString(R.string.autor3) -> {
                desc = resources.getStringArray(R.array.authors_list_desc)[2]
            }
        }

        val textLabel = view.findViewById<TextView>(R.id.autorDesc)
        textLabel.text = desc

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AutorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}