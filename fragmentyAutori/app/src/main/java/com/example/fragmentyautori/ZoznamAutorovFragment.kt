package com.example.fragmentyautori

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class ZoznamAutorovFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_zoznam_autorov,
            container, false)

        val btnAutor1 = view.findViewById<Button>(R.id.autor1)
        val btnAutor2 = view.findViewById<Button>(R.id.autor2)
        val btnAutor3 = view.findViewById<Button>(R.id.autor3)

        btnAutor1.setOnClickListener {
            val autor = resources.getString(R.string.autor1)

            val action = ZoznamAutorovFragmentDirections
                .actionZoznamAutorovToAutorFragment(
                    autor
                )

            view.findNavController()
                .navigate(action)
        }

        btnAutor2.setOnClickListener {
            val autor = resources.getString(R.string.autor2)

            val action = ZoznamAutorovFragmentDirections
                .actionZoznamAutorovToAutorFragment(
                    autor
                )

            view.findNavController()
                .navigate(action)
        }

        btnAutor3.setOnClickListener {
            val autor = resources.getString(R.string.autor3)

            val action = ZoznamAutorovFragmentDirections
                .actionZoznamAutorovToAutorFragment(
                    autor
                )

            view.findNavController()
                .navigate(action)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ZoznamAutorov.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ZoznamAutorovFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}