package com.entreamigos.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grupos")
data class GrupoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nombre: String,
    val emoji: String = "👥",
    val colorHex: String = "#1B5E4F",
    val fechaCreacion: Long = System.currentTimeMillis()
)
