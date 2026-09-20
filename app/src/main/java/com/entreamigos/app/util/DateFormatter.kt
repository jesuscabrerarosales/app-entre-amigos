package com.entreamigos.app.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateFormatter {
    private val formato = SimpleDateFormat("dd/MM/yyyy", Locale("es", "PE"))

    fun formatear(timestampMillis: Long): String = formato.format(Date(timestampMillis))
}
