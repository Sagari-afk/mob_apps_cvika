package com.example.cv7_fragmenty_nav_panely

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import androidx.core.net.toUri

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WebFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WebFragment : Fragment() {

    private var URL_LINK:String = "https://google.com";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_web, container, false)

        val customSwitch = view.findViewById<Switch>(R.id.switch_custom)

        val customUrl = view.findViewById<EditText>(R.id.editUrl)
        val spinnerUrls = view.findViewById<Spinner>(R.id.urls)

        customSwitch.setOnClickListener {
            if (customSwitch.isChecked) {
                customUrl.visibility = VISIBLE
                spinnerUrls.visibility = GONE
            } else {
                customUrl.visibility = GONE
                spinnerUrls.visibility = VISIBLE
            }
        }

        val openBtn = view.findViewById<Button>(R.id.otvor)

        openBtn.setOnClickListener {
            URL_LINK = if (customSwitch.isChecked) {
                customUrl.text.toString();
            } else {
                spinnerUrls.selectedItem.toString()
            }
            startActivity(Intent((Intent.ACTION_VIEW), URL_LINK.toUri()))
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WebFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}