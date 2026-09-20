package com.entreamigos.app.data.repository

import android.content.Context
import com.entreamigos.app.data.local.AppDatabase

class AppContainer(context: Context) {

    private val database = AppDatabase.getInstance(context)

    val grupoRepository: GrupoRepository by lazy {
        GrupoRepository(
            grupoDao = database.grupoDao(),
            miembroDao = database.miembroDao(),
            gastoDao = database.gastoDao(),
            pagoDao = database.pagoDao()
        )
    }

    val gastoRepository: GastoRepository by lazy {
        GastoRepository(
            gastoDao = database.gastoDao(),
            miembroDao = database.miembroDao(),
            pagoDao = database.pagoDao(),
            grupoDao = database.grupoDao()
        )
    }
}
