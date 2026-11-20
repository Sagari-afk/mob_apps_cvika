package com.example.kalkulacka

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import kotlin.properties.Delegates

class VzdalenostFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_prevod, container, false);

        val desc = view.findViewById<TextView>(R.id.desc)
        val switchJednotky = view.findViewById<SwitchCompat>(R.id.switchJednotky)

        desc.text = "km<->míľa";
        switchJednotky.text = "km / míľa"


        val convertBtn = view.findViewById<Button>(R.id.convertBtn)
        convertBtn.setOnClickListener {
            val numToConvert = view.findViewById<EditText>(R.id.numToConvert)

            val convertedNum = convert(numToConvert.text.toString().toInt(), switchJednotky.isChecked)

            val convertedNumView = view.findViewById<TextView>(R.id.viewConvertedNum)
            convertedNumView.text = convertedNum .toString();
        }

        return view;
    }

    private fun convert(numToConvert: Int, switchJednotky: Boolean) : Double {
        var value by Delegates.notNull<Double>();

        value = if (switchJednotky) {
            numToConvert * 1.609;
        } else {
            numToConvert / 1.609;
        }

        return value
    }

}