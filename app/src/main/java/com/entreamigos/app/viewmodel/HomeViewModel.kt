package com.entreamigos.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.entreamigos.app.data.model.ResumenGeneral
import com.entreamigos.app.data.model.ResumenGrupo
import com.entreamigos.app.data.repository.GrupoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(private val grupoRepository: GrupoRepository) : ViewModel() {

    val grupos: StateFlow<List<ResumenGrupo>> = grupoRepository.observarResumenGrupos()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    val resumenGeneral: StateFlow<ResumenGeneral> = grupoRepository.observarResumenGeneral()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            ResumenGeneral(0.0, 0.0, 0.0)
        )

    class Factory(private val grupoRepository: GrupoRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(grupoRepository) as T
        }
    }
}
