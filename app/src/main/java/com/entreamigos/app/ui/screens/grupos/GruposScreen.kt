package com.entreamigos.app.ui.screens.grupos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.entreamigos.app.data.repository.GrupoRepository
import com.entreamigos.app.ui.components.GroupCard
import com.entreamigos.app.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GruposScreen(grupoRepository: GrupoRepository, onGrupoClick: (Long) -> Unit) {
    val viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory(grupoRepository))
    val grupos by viewModel.grupos.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = { Text("Mis grupos") })

        if (grupos.isEmpty()) {
            Text(
                text = "Todavía no tienes grupos.",
                modifier = Modifier.padding(24.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(grupos, key = { it.grupoId }) { grupo ->
                    GroupCard(resumen = grupo, onClick = { onGrupoClick(grupo.grupoId) })
                }
            }
        }
    }
}
