package sk.uniza.beeradviser

import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnFindBeer = findViewById<Button>(R.id.btnFindBeer)
        btnFindBeer.setOnClickListener {
            val spCountry = findViewById<Spinner>(R.id.spCountryOrigin)
            val report = findViewById<TextView>(R.id.report)
            val beerList = getBeers(spCountry.selectedItem.toString())
            val beers = beerList.reduce{str, item->str + '\n' + item}
            report.text = beers
            val img = findViewById<ImageView>(R.id.imageView)
            img.setImageResource(R.drawable.beers)
        }

        val btnFindVine = findViewById<Button>(R.id.btnFindVine)
        btnFindVine.setOnClickListener {
            val spCountry = findViewById<Spinner>(R.id.spCountryOrigin)
            val report = findViewById<TextView>(R.id.reportVine)
            val vineList = getVines(spCountry.selectedItem.toString())
            val vines = vineList.reduce{str, item->str + '\n' + item}
            report.text = vines
            val img = findViewById<ImageView>(R.id.imageView)
            img.setImageResource(R.drawable.vines)

        }
    }
    private fun getBeers(strCountry:String): List<String> {
        val res:Resources  = resources
        return when(strCountry) {
            "Slovakia" -> res.getStringArray(R.array.sk_beers).toList()
            "Czech Republic" -> res.getStringArray(R.array.cz_beers).toList()
            "Germany" -> res.getStringArray(R.array.de_beers).toList()

            else -> listOf(getString(R.string.no_beer))
        }
    }

    private fun getVines(strCountry: String): List<String> {
        val res:Resources  = resources
        return when(strCountry) {
            "Slovakia" -> res.getStringArray(R.array.sk_vines).toList()
            "Czech Republic" -> res.getStringArray(R.array.cz_vines).toList()
            "Germany" -> res.getStringArray(R.array.de_vines).toList()

            else -> listOf(getString(R.string.no_vine))
        }
    }
}


