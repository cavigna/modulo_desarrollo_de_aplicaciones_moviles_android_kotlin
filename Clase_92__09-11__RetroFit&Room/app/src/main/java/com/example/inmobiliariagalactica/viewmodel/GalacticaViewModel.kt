package com.example.inmobiliariagalactica.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inmobiliariagalactica.model.Terreno
import com.example.inmobiliariagalactica.repository.Repositorio
import kotlinx.coroutines.launch

class GalacticaViewModel(private val repositorio: Repositorio) : ViewModel(){

    init {
        listadoTerrenos()

    }

    private val _listaTerreno = MutableLiveData<List<Terreno>>()
    val listaTerreno: LiveData<List<Terreno>> = _listaTerreno

    fun listadoTerrenos(){
        viewModelScope.launch {
            _listaTerreno.postValue(repositorio.listadoTerrenos())
        }
    }

    suspend fun prueba(): List<Terreno>{
        return repositorio.listadoTerrenos()
    }

}