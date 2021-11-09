package com.example.inmobiliariagalactica.application

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.inmobiliariagalactica.db.BaseDeDatos
import com.example.inmobiliariagalactica.network.ApiService
import com.example.inmobiliariagalactica.repository.Repositorio
import com.example.inmobiliariagalactica.viewmodel.GalacticaModelFactory

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GalacticaApplication : Application() {

    private val retrofitClient  by lazy {
        Retrofit.Builder()
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


    val baseDeDatos by lazy { BaseDeDatos.getDataBase(this) }
    val repository by lazy { Repositorio(retrofitClient, baseDeDatos.dao()) }



    val galFactory = GalacticaModelFactory(repository)

    //val viewModel : GalacticaViewModel = ViewModelProvider(this, galFactory)


}