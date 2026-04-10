package com.javier.zodiac_app

class Horoscope(
    val id: String,
    val name: Int,
    val dates: Int,
    val image: Int


) {
    // static en java
    companion object {
        // nos traemos la lista a la clase horoscope para poder usarla en todas partes
        val horoscopeList: List<Horoscope> = listOf(
            Horoscope("aries", R.string.horoscope_name_aries, R.string.horoscope_date_aries, R.drawable.aries),
            Horoscope("taurus", R.string.horoscope_name_taurus, R.string.horoscope_date_taurus, R.drawable.taurus),
            Horoscope("gemini", R.string.horoscope_name_gemini, R.string.horoscope_date_gemini, R.drawable.gemini),
            Horoscope("cancer", R.string.horoscope_name_cancer, R.string.horoscope_date_cancer, R.drawable.cancer),
            Horoscope("leo", R.string.horoscope_name_leo, R.string.horoscope_date_leo, R.drawable.leo),
            Horoscope("virgo", R.string.horoscope_name_virgo, R.string.horoscope_date_virgo, R.drawable.virgo),
            Horoscope("libra", R.string.horoscope_name_libra, R.string.horoscope_date_libra, R.drawable.libra),
            Horoscope("scorpio", R.string.horoscope_name_scorpio, R.string.horoscope_date_scorpio, R.drawable.scorpio),
            Horoscope("sagittarius", R.string.horoscope_name_sagittarius, R.string.horoscope_date_sagittarius, R.drawable.sagittarius),
            Horoscope("capricorn", R.string.horoscope_name_capricorn, R.string.horoscope_date_capricorn, R.drawable.capricorn),
            Horoscope("aquarius", R.string.horoscope_name_aquarius, R.string.horoscope_date_aquarius, R.drawable.aquarius),
            Horoscope("pisces", R.string.horoscope_name_pisces, R.string.horoscope_date_pisces, R.drawable.pisces)
        )

        fun getById(id: String): Horoscope? {
            horoscopeList.find {
                it.id == id
            }
        }
    }

}