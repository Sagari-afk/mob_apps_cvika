package com.example.bodymassindexapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.lang.Double
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode", "UseValueOf")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val vypocitajBMIbtn = findViewById<Button>(R.id.vypocitajBMI)

        vypocitajBMIbtn.setOnClickListener {
            println("Clicked...")

            val vyska = findViewById<EditText>(R.id.vyska)
            val vaha = findViewById<EditText>(R.id.vaha)
            val pohlavie = findViewById<Switch>(R.id.pohlavie)

            val notOk = validateFields(vyska, vaha)

            if (notOk) {
                Toast.makeText(
                    this,
                    "Error: vyplnite vsetky polia!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener;
            }

            val BMI = countBMI(Double.parseDouble(vyska.text.toString()) * 0.01, Double.parseDouble(vaha.text.toString()));
            val summary = getSummary(BMI, pohlavie.isChecked)

            val vypocitane = findViewById<TextView>(R.id.vypocitane)
            vypocitane.text = BMI.toString()
            vypocitane.visibility = View.VISIBLE

            val summaryView = findViewById<TextView>(R.id.summary)
            summaryView.text = summary
            summaryView.visibility = View.VISIBLE
        }
    }

    private fun validateFields(vyska: EditText, vaha: EditText) : Boolean {
        println("Checking...")
        println(vyska.text.toString())
        println(vaha.text.toString())
        return vaha.text.toString().isEmpty() || vyska.text.toString().isEmpty() || vaha.text.toString() == "0" || vyska.text.toString() == "0"
    }

    private fun countBMI(vyska: kotlin.Double, vaha: kotlin.Double) : kotlin.Double {
        return (vaha / (vyska * vyska) * 10.0).roundToInt() / 10.0
    }

    private fun getSummary(BMI: kotlin.Double, pohlavie: Boolean) : String {
//      ak zena tak pohlavie je true a ku BMI sa prirata jednotka
        var bmiNew = BMI;
        if (pohlavie) {
            bmiNew = BMI + 1
        }
        val range = getRange(bmiNew)

        var summary = ""

        when(range) {
            1 -> summary = "Mate podvahu!"
            2 -> summary = "Mate normalnu hmotnost!"
            3 -> summary = "Mate nadvahu!"
            4 -> summary = "Mate obezitu 1 stupna!"
            5 -> summary = "Mate obezitu 2 stupna!"
            6 -> summary = "Mate obezitu 3 stupna!"
        }

        return summary
    }

    private fun getRange(num: kotlin.Double) : Int {
        if (num < 20) return 1
        if (num > 20 && num < 24.9) return 2
        if (num > 25 && num < 29.9) return 3
        if (num > 30 && num < 34.9) return 4
        if (num > 35 && num < 39.9) return 5
        if (num > 40) return 6

        return 0
    }
}