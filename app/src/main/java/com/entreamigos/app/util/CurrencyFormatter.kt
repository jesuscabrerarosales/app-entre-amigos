package com.entreamigos.app.util

import java.util.Locale

object CurrencyFormatter {
    fun formatear(monto: Double): String = String.format(Locale("es", "PE"), "S/ %,.2f", monto)
}
