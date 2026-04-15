package com.javier.zodiac_app.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.javier.zodiac_app.data.Horoscope
import com.javier.zodiac_app.R

class DetailActivity : AppCompatActivity() {

    lateinit var nameTextView: TextView
    lateinit var imageView: ImageView
    lateinit var descTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //acceso al id de horoscopo en detalle (usar !! es para decirle que si o si paso el id)
        val id = intent.getStringExtra("HOROSCOPE_ID")!!

        val horoscope = Horoscope.Companion.getById(id)!!
        Log.i("ZODIAC", "${getString(horoscope.name)} -> ${getString(horoscope.dates)}")

        // Conectamos con XML
        nameTextView = findViewById(R.id.nameTextView)
        imageView= findViewById(R.id.imageView)
        descTextView= findViewById(R.id.descTextView)

        nameTextView.text = getString(horoscope.name)
        imageView.setImageResource(horoscope.image)
        descTextView.text = getString(horoscope.desc)

        supportActionBar?.setTitle(horoscope.name)
        supportActionBar?.setSubtitle(horoscope.dates)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_favorite_selected) ESTO ES PARA UN ICONO PERSONALIZADO
    }

    // decimos cual es el menu bar que queremos cargar en el action bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_detail, menu)
        return true
    }

    // Que hacemos cuando se pulse una opcion del menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            android.R.id.home->{
                // Esto cierra una activity
                finish()
                true
            }
            R.id.menu_favorite -> {
                // Marcar el horoscopo como favorito
                Log.i("ZODIAC", "Menu favorite")
                true
            }
            R.id.menu_share -> {
                // Compartir el horoscopo
                Log.i("ZODIAC", "Menu compartido")
                share()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun share(){
        val sendIntent = Intent()
        sendIntent.setAction(Intent.ACTION_SEND)
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
        sendIntent.setType("text/plain")

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}