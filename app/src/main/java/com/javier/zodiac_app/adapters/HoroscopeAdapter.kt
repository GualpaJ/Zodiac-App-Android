package com.javier.zodiac_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.javier.zodiac_app.R
import com.javier.zodiac_app.data.Horoscope
import com.javier.zodiac_app.utils.SesionManager

class HoroscopeAdapter (var items: List<Horoscope>, val onItemClick: (Int)-> Unit) : RecyclerView.Adapter<HoroscopeViewHolder>() {
    // Cual es la vista para los elementos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        return HoroscopeViewHolder(view)
    }

    // Cuales son los datos para mostrar para el elmento en la posicion
    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        val horoscope = items [position]
        holder.render(horoscope)
        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
    }

    //Cuantos elementos tengo que mostrar
    override fun getItemCount(): Int {
        return items.size
    }

    //Pasamos un parametro que sera un list de horoscopo
    fun updateData(dataSet: List<Horoscope>){
        items =dataSet
        notifyDataSetChanged()
    }
}


class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val signImagesView: ImageView =view.findViewById(R.id.singImageView)
    val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    val datesTextView: TextView = view.findViewById(R.id.datesTextView)

    val favoriteImagesView: ImageView =view.findViewById(R.id.favoriteImageView)

    fun render(horoscope: Horoscope){
        nameTextView.setText(horoscope.name)
        datesTextView.setText(horoscope.dates)
        signImagesView.setImageResource(horoscope.image)
        //usamos una vista para el contexto , usamos el itemview porque es constante en el tiempo
        if(SesionManager(itemView.context).isFavoriteHoroscope(horoscope.id)){
            favoriteImagesView.visibility = View.VISIBLE
            // otra manera: favoriteImagesView.isVisible = true
        }else{
            favoriteImagesView.visibility = View.GONE
            // otra manera: favoriteImagesView.isVisible = false (esto lo pone gone)
        }
    }
}