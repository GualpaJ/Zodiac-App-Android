package com.javier.zodiac_app.utils

import android.R
import android.content.Context
import android.content.SharedPreferences


class SesionManager (context: Context) {
    var sharedPref: SharedPreferences = context.getSharedPreferences("zodiac_session", Context.MODE_PRIVATE)

    fun setFavoriteHoroscope(id: String){
        val editor = sharedPref.edit()
        editor.putString("FAVORITE_HOROSCOPE",id)
        editor.apply()
    }

    fun getFavoriteHoroscope():String{
        return sharedPref.getString("FAVORITE_HOROSCOPE", "")!!
    }

    fun isFavoriteHoroscope(id:String): Boolean{
        return getFavoriteHoroscope()==id
    }
}