package com.example.inmobiliariagalactica.viewmodel

import androidx.lifecycle.*
import com.example.inmobiliariagalactica.model.Terreno
import com.example.inmobiliariagalactica.repository.Repositorio
import kotlinx.coroutines.launch

class GalacticaViewModel(private val repositorio: Repositorio) : ViewModel(){

    init {
        listadoTerrenos()

    }

    val currentTerreno = MutableLiveData<Terreno>()

    private val _listaTerreno = MutableLiveData<List<Terreno>>()
    val listaTerreno: LiveData<List<Terreno>> = _listaTerreno

    val listaTerrenosDB = repositorio.listadoTerrenosDB().asLiveData()

    fun listadoTerrenos(){
        viewModelScope.launch {


            repositorio.agregarListadoDB(repositorio.listadoTerrenos())
        }
    }

    suspend fun prueba(): List<Terreno>{
        return repositorio.listadoTerrenos()
    }

}