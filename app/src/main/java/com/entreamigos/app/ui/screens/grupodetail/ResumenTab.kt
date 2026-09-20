package com.entreamigos.app.ui.screens.grupodetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.entreamigos.app.ui.components.DeudaItem
import com.entreamigos.app.ui.components.GastoItem
import com.entreamigos.app.ui.components.colorDeBalance
import com.entreamigos.app.util.CurrencyFormatter
import com.entreamigos.app.util.compartirResumenGrupo
import com.entreamigos.app.viewmodel.GrupoDetailUiState

@Composable
fun ResumenTab(uiState: GrupoDetailUiState, onRegistrarGastoClick: () -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Tu balance en este grupo", style = MaterialTheme.typography.bodyMedium)
                        val balance = uiState.balanceUsuarioActual
                        Text(
                            text = (if (balance >= 0) "+ " else "- ") + CurrencyFormatter.formatear(kotlin.math.abs(balance)),
                            style = MaterialTheme.typography.titleLarge,
                            color = colorDeBalance(balance)
                        )
                        Text(
                            text = if (balance > 0.005) "te deben" else if (balance < -0.005) "debes" else "estás al día",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    IconButton_CompartirResumen(uiState = uiState)
                }
            }
        }

        item { Text("¿Quién debe a quién?", style = MaterialTheme.typography.titleMedium) }

        if (uiState.deudas.isEmpty()) {
            item {
                Text(
                    "No hay deudas pendientes en este grupo.",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            items(uiState.deudas) { deuda ->
                val esHaciaUsuario = uiState.miembros.firstOrNull { it.esUsuarioActual }?.id == deuda.acreedor.id
                DeudaItem(deuda = deuda, esDeudaHaciaElUsuario = esHaciaUsuario)
            }
        }

        item {
            Button(onClick = onRegistrarGastoClick, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Filled.Add, contentDescription = null, modifier = Modifier.padding(end = 4.dp))
                Text("Registrar nuevo gasto")
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Actividad reciente", style = MaterialTheme.typography.titleMedium)
                TextButton(onClick = {}) { Text("Ver todo") }
            }
        }
        items(uiState.gastos.take(5)) { gasto -> GastoItem(gasto = gasto) }
    }
}

@Composable
private fun IconButton_CompartirResumen(uiState: GrupoDetailUiState) {
    val context = LocalContext.current
    TextButton(onClick = { compartirResumenGrupo(context, uiState) }) {
        Icon(Icons.Filled.Share, contentDescription = "Compartir resumen")
    }
}
