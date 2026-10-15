package com.example.activitylifecycle


import android.app.Activity
import android.content.Intent

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class AktivitaA : AppCompatActivity() {
    private var URL_LINK:String = "https://feit.uniza.sk";
    private val TAG: String = "Zivotny cyklus";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.aktivita_a)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent: Intent? = result.data
                if (intent!=null) {
                    URL_LINK = intent.getStringExtra(Intent.EXTRA_TEXT).toString();
                    Log.d("Url from aktivity B: ", URL_LINK)
                }
            }
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            // Explicit

            val intent = Intent(this, AktivitaB::class.java)
            intent.putExtra(Intent.EXTRA_TEXT, URL_LINK)
            startForResult.launch(intent)
        }


        val btnActivityWeb = findViewById<Button>(R.id.button)
        btnActivityWeb.setOnClickListener {
            // Implicit
            Log.d("Run WEB ", URL_LINK)
            startActivity(Intent((Intent.ACTION_VIEW), URL_LINK.toUri()))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "AktivitaA - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "AktivitaA - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "AktivitaA - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "AktivitaA - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "AktivitaA - onDestroy")
    }

}