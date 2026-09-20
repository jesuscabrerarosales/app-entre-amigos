package com.entreamigos.app.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomDestino(val etiqueta: String, val icono: ImageVector, val ruta: String) {
    INICIO("Inicio", Icons.Filled.Home, Screen.Home.route),
    GRUPOS("Grupos", Icons.Outlined.Groups, "grupos"),
    CREAR("Crear", Icons.Filled.AddCircle, Screen.CrearGrupo.route),
    GASTOS("Gastos", Icons.Filled.ReceiptLong, "gastos"),
    PERFIL("Perfil", Icons.Filled.Person, Screen.Perfil.route)
}

@Composable
fun EntreAmigosBottomBar(rutaActual: String?, onNavegar: (BottomDestino) -> Unit) {
    NavigationBar {
        BottomDestino.values().forEach { destino ->
            NavigationBarItem(
                selected = rutaActual == destino.ruta,
                onClick = { onNavegar(destino) },
                icon = { Icon(destino.icono, contentDescription = destino.etiqueta) },
                label = { Text(destino.etiqueta) }
            )
        }
    }
}
