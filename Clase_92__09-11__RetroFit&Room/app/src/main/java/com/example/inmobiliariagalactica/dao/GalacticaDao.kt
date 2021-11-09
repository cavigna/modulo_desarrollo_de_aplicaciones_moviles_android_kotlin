package com.example.inmobiliariagalactica.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.inmobiliariagalactica.model.Terreno
import kotlinx.coroutines.flow.Flow


@Dao
interface GalacticaDao {

    @Insert
    suspend fun agregarListadoDB(listadoTerreno: List<Terreno>)

    @Query("SELECT * FROM terreno")
    fun listadoTerrenoDB() : Flow<List<Terreno>>
}