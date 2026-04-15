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
import com.javier.zodiac_app.utils.SesionManager

class DetailActivity : AppCompatActivity() {

    lateinit var horoscope: Horoscope
    lateinit var nameTextView: TextView
    lateinit var imageView: ImageView
    lateinit var descTextView: TextView

    lateinit var favoriteMenuItem : MenuItem

    lateinit var session : SesionManager

    var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        session = SesionManager(this)

        //acceso al id de horoscopo en detalle (usar !! es para decirle que si o si paso el id)
        val id = intent.getStringExtra("HOROSCOPE_ID")!!

        horoscope = Horoscope.Companion.getById(id)!!
        Log.i("ZODIAC", "${getString(horoscope.name)} -> ${getString(horoscope.dates)}")

        isFavorite = session.isFavoriteHoroscope(id)

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
        favoriteMenuItem = menu.findItem(R.id.menu_favorite)
        setFavoriteIcon()
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
                setFavorite()
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

    fun setFavoriteIcon(){
        if(isFavorite){
            favoriteMenuItem.setIcon(R.drawable.ic_favorite_selected)
        }else {
            favoriteMenuItem.setIcon(R.drawable.ic_favorite)
        }
    }
    // CAMBIA EL VALOR QUE HAY EN SESION
    fun setFavorite(){
        if(isFavorite){
            session.setFavoriteHoroscope("")
        }else{
            session.setFavoriteHoroscope(horoscope.id)
        }
        //interruptor para cambiar el valor
        isFavorite =!isFavorite
        setFavoriteIcon()
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