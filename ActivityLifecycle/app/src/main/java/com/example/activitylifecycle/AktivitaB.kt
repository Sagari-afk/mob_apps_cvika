package com.example.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AktivitaB : AppCompatActivity() {
    private val TAG: String = "Zivotny cyklus";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.aktivita_b)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edit = findViewById<EditText>(R.id.edit);
        val inputIntent = intent;
        val strMsg: String = inputIntent.getStringExtra(Intent.EXTRA_TEXT).toString();
        edit.setText(strMsg)

        findViewById<Button>(R.id.button3).setOnClickListener {
            val edit = findViewById<EditText>(R.id.edit);

            runActivityA(edit);
        }
    }

    private fun runActivityA(edit: EditText) {
        val resultIntent = Intent();
        Log.d("New url sends: ", edit.text.toString())
        resultIntent.putExtra(Intent.EXTRA_TEXT, edit.text.toString())
        setResult(RESULT_OK, resultIntent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "AktivitaB - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "AktivitaB - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "AktivitaB - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "AktivitaB - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "AktivitaB - onDestroy")
    }
}