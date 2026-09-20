package com.entreamigos.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.entreamigos.app.data.model.ActividadItem
import com.entreamigos.app.data.repository.GastoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class GastosGlobalViewModel(gastoRepository: GastoRepository) : ViewModel() {

    val actividad: StateFlow<List<ActividadItem>> = gastoRepository.observarActividadGlobal()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    class Factory(private val gastoRepository: GastoRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return GastosGlobalViewModel(gastoRepository) as T
        }
    }
}
