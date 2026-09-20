package com.entreamigos.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.entreamigos.app.data.local.entity.PagoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PagoDao {

    @Query("SELECT * FROM pagos WHERE grupoId = :grupoId ORDER BY fecha DESC")
    fun observarPagos(grupoId: Long): Flow<List<PagoEntity>>

    @Query("SELECT * FROM pagos")
    fun observarTodosLosPagos(): Flow<List<PagoEntity>>

    @Insert
    suspend fun insertar(pago: PagoEntity): Long
}
