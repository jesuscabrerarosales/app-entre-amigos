package com.entreamigos.app.data.local.dao

import androidx.room.*
import com.entreamigos.app.data.local.entity.GastoEntity
import com.entreamigos.app.data.local.entity.GastoParticipanteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GastoDao {

    @Query("SELECT * FROM gastos WHERE grupoId = :grupoId ORDER BY fecha DESC")
    fun observarGastos(grupoId: Long): Flow<List<GastoEntity>>

    @Query("SELECT * FROM gastos ORDER BY fecha DESC")
    fun observarTodosLosGastos(): Flow<List<GastoEntity>>

    @Insert
    suspend fun insertarGasto(gasto: GastoEntity): Long

    @Insert
    suspend fun insertarParticipantes(participantes: List<GastoParticipanteEntity>)

    @Query("SELECT * FROM gasto_participantes WHERE gastoId = :gastoId")
    fun observarParticipantes(gastoId: Long): Flow<List<GastoParticipanteEntity>>

    @Query("SELECT * FROM gasto_participantes WHERE gastoId IN (SELECT id FROM gastos WHERE grupoId = :grupoId)")
    fun observarParticipantesDeGrupo(grupoId: Long): Flow<List<GastoParticipanteEntity>>

    @Query("SELECT * FROM gasto_participantes")
    fun observarTodosLosParticipantes(): Flow<List<GastoParticipanteEntity>>

    @Delete
    suspend fun eliminarGasto(gasto: GastoEntity)
}
