package com.example.inmobiliariagalactica.network

import com.example.inmobiliariagalactica.model.Terreno
import retrofit2.http.GET

interface ApiService {
    @GET("realestate/")
    suspend fun listadoTerrenos(): List<Terreno>
}