package com.javier.zodiac_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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


class HoroscopeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val signImagesView: ImageView =itemView.findViewById(R.id.singImageView)
    val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    val datesTextView: TextView = itemView.findViewById(R.id.datesTextView)

    fun render(horoscope: Horoscope){
        nameTextView.setText(horoscope.name)
        datesTextView.setText(horoscope.dates)
        signImagesView.setImageResource(horoscope.image)
    }
}