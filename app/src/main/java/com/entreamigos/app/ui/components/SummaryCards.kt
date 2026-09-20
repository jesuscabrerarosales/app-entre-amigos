package com.entreamigos.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.entreamigos.app.data.model.ResumenGeneral
import com.entreamigos.app.ui.theme.AzulInformativo
import com.entreamigos.app.ui.theme.RojoSaldoNegativo
import com.entreamigos.app.ui.theme.VerdeSaldoPositivo
import com.entreamigos.app.util.CurrencyFormatter

@Composable
fun ResumenGeneralRow(resumen: ResumenGeneral, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MiniResumenCard(
            titulo = "Total gastado",
            valor = CurrencyFormatter.formatear(resumen.totalGastado),
            color = VerdeSaldoPositivo,
            modifier = Modifier.weight(1f)
        )
        MiniResumenCard(
            titulo = "Te deben",
            valor = CurrencyFormatter.formatear(resumen.totalTeDeben),
            color = AzulInformativo,
            modifier = Modifier.weight(1f)
        )
        MiniResumenCard(
            titulo = "Debes",
            valor = CurrencyFormatter.formatear(resumen.totalDebes),
            color = RojoSaldoNegativo,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun MiniResumenCard(titulo: String, valor: String, color: androidx.compose.ui.graphics.Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.12f))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = valor, style = MaterialTheme.typography.titleMedium, color = color)
            Text(text = titulo, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}
