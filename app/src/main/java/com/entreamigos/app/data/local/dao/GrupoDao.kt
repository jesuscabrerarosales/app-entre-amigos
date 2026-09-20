package com.entreamigos.app.data.local.dao

import androidx.room.*
import com.entreamigos.app.data.local.entity.GrupoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GrupoDao {

    @Query("SELECT * FROM grupos ORDER BY fechaCreacion DESC")
    fun observarGrupos(): Flow<List<GrupoEntity>>

    @Query("SELECT * FROM grupos WHERE id = :grupoId")
    fun observarGrupo(grupoId: Long): Flow<GrupoEntity?>

    @Insert
    suspend fun insertar(grupo: GrupoEntity): Long

    @Update
    suspend fun actualizar(grupo: GrupoEntity)

    @Delete
    suspend fun eliminar(grupo: GrupoEntity)
}
