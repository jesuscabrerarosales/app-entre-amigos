package com.entreamigos.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.entreamigos.app.data.model.Miembro
import com.entreamigos.app.ui.theme.RojoSaldoNegativo
import com.entreamigos.app.ui.theme.VerdeSaldoPositivo

@Composable
fun AvatarInicial(nombre: String, colorHex: String, modifier: Modifier = Modifier, tamano: androidx.compose.ui.unit.Dp = 40.dp) {
    val color = runCatching { Color(android.graphics.Color.parseColor(colorHex)) }
        .getOrDefault(MaterialTheme.colorScheme.secondary)
    Box(
        modifier = modifier
            .size(tamano)
            .background(color, CircleShape)
            .semantics { contentDescription = "Avatar de $nombre" },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = nombre.trim().firstOrNull()?.uppercase() ?: "?",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
fun AvatarMiembro(miembro: Miembro, modifier: Modifier = Modifier) {
    AvatarInicial(nombre = miembro.nombre, colorHex = miembro.colorAvatarHex, modifier = modifier)
}

@Composable
fun colorDeBalance(monto: Double): Color = when {
    monto > 0.005 -> VerdeSaldoPositivo
    monto < -0.005 -> RojoSaldoNegativo
    else -> MaterialTheme.colorScheme.onSurfaceVariant
}
