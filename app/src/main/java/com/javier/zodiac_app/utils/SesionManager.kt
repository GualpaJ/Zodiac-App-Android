package com.javier.zodiac_app.utils

import android.R
import android.content.Context
import android.content.SharedPreferences


class SesionManager (context: Context) {
    var sharedPref: SharedPreferences = context.getSharedPreferences("zodiac_session", Context.MODE_PRIVATE)

    //Obtenemos la lista de horoscopos favoritos guardados en memoria local
    fun getFavorites(): MutableSet<String> {
        return sharedPref.getStringSet("FAVORITE_HOROSCOPE", mutableSetOf())!!.toMutableSet()
    }

    // Guardamos la lista actualizada de favoritos
    fun saveFavorites(favorites: Set<String>){
        val editor = sharedPref.edit()
        editor.putStringSet("FAVORITE_HOROSCOPE", favorites)
        editor.apply()
    }

    // Añadimos a un horoscopo a favoritos
    fun addFavorite(id: String){
        val favorites = getFavorites()
        favorites.add(id)
        saveFavorites(favorites)
    }

    // Eliminamos un horoscopo de favoritos
    fun removeFavorite(id:String){
        val favorites = getFavorites()
        favorites.remove(id)
        saveFavorites(favorites)
    }

    // Verificamos si es favorito
    fun isFavoriteHoroscope(id:String): Boolean{
        return getFavorites().contains(id)
    }
}