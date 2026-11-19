package com.example.grafikaekvalizer

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var kanalyArray: FloatArray = floatArrayOf(0.2f, 0.5f, 0.9f, 0.6f, 0.3f);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val equalizerView = findViewById<EkvalizerView>(R.id.equalizerView)

        equalizerView.setData(kanalyArray)


        findViewById<Button>(R.id.randomBtn)
            .setOnClickListener {
                kanalyArray = FloatArray(5) {
                    Random.nextFloat() * (1 - 0)
                }
                equalizerView.setData(kanalyArray)
            }


    }
}