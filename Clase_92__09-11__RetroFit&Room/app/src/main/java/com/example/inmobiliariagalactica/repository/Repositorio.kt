package com.example.inmobiliariagalactica.repository

import com.example.inmobiliariagalactica.dao.GalacticaDao
import com.example.inmobiliariagalactica.model.Terreno
import com.example.inmobiliariagalactica.network.ApiService

class Repositorio(private val api: ApiService, private val dao: GalacticaDao) {

    suspend fun listadoTerrenos() = api.listadoTerrenos()

    suspend fun agregarListadoDB(listaT : List<Terreno>) = dao.agregarListadoDB(listaT)
    fun listadoTerrenosDB() = dao.listadoTerrenoDB()

}