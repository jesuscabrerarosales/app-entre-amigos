package com.entreamigos.app.ui.screens.perfil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.entreamigos.app.BuildConfig

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = { Text("Perfil") })

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("EntreAmigos", style = MaterialTheme.typography.titleLarge)
            Text(
                "Gestión y control de gastos compartidos",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Card {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Estado del proyecto", style = MaterialTheme.typography.titleMedium)
                    Text("Versión ${BuildConfig.VERSION_NAME} · Primer entregable (~25% de avance)")
                    Text("Arquitectura: MVVM + Jetpack Compose + Room")
                }
            }

            Card {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Integrantes", style = MaterialTheme.typography.titleMedium)
                    Text("Rodrigo Gino Alejandro Castillo")
                    Text("Jose Moises Alvines Villegas")
                    Text("Marycielo Mengoa Oliveros")
                    Text("Maciel Bresia Contreras Yauri")
                }
            }

            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("ODS 12 — Producción y consumo responsables", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "EntreAmigos promueve el consumo responsable al ayudar a un grupo de " +
                            "personas a repartir gastos de forma justa y transparente, evitando " +
                            "malentendidos y fomentando acuerdos claros sobre el dinero compartido."
                    )
                }
            }

            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Transparencia sobre el uso de IA", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "Como parte del uso responsable de herramientas de inteligencia artificial " +
                            "(sílabo, Semana 3), el equipo declara que utilizó un asistente de IA como " +
                            "apoyo a la productividad durante el desarrollo (generación de código base y " +
                            "documentación), revisando y adaptando manualmente cada parte del proyecto."
                    )
                }
            }
        }
    }
}
