package com.entreamigos.app.ui.screens.grupodetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.entreamigos.app.ui.components.GastoItem
import com.entreamigos.app.viewmodel.GrupoDetailUiState

@Composable
fun GastosTab(uiState: GrupoDetailUiState, onRegistrarGastoClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (uiState.gastos.isEmpty()) {
            Text(
                text = "Aún no hay gastos registrados en este grupo.",
                modifier = Modifier.padding(24.dp).align(Alignment.TopStart),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp, 16.dp, 16.dp, 88.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(uiState.gastos, key = { it.id }) { gasto -> GastoItem(gasto = gasto) }
            }
        }

        FloatingActionButton(
            onClick = onRegistrarGastoClick,
            modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Registrar nuevo gasto")
        }
    }
}
