package com.adhiambo.themilkyway.common

import java.text.SimpleDateFormat
import java.util.*

object UiUtils {

    fun String.getMediumDate(): String {
        val inputFormat = SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss",
            Locale.getDefault()
        )
        val parseDate = inputFormat.parse(this)

        val outPutFormat = SimpleDateFormat(
            "yyyy-MM-dd",
            Locale.getDefault()
        )

        return outPutFormat.format(parseDate)
    }
}