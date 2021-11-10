package com.example.inmobiliariagalactica.viewmodel

import androidx.lifecycle.*
import com.example.inmobiliariagalactica.model.Terreno
import com.example.inmobiliariagalactica.network.ApiService
import com.example.inmobiliariagalactica.repository.Repositorio
import kotlinx.coroutines.launch

class GalacticaViewModel(private val repositorio: Repositorio) : ViewModel() {


    //val repo2 = Repositorio()
    //var listaTerrenosDB:LiveData<List<Terreno>>
    val listaTerrenosDB = repositorio.listadoTerrenosDB().asLiveData()


    var _uno = MutableLiveData<Int>()
    val uno :LiveData<Int> = _uno

    val currentTerreno = MutableLiveData<Terreno>()
    val conteoDB = repositorio.conteoDB()
    var pruebaDB = MutableLiveData<Int>(0)

    init {
        checkIfDBEmpty()
        listadoTerrenos()
        //pruebaDB = MutableLiveData(repositorio.listadoTerrenosDB().asLiveData().value?.size)
        //listaTerrenosDB = repositorio.listadoTerrenosDB().asLiveData()

    }




    //var pruebaDB = MutableLiveData(10)

    fun listadoTerrenos() {
        viewModelScope.launch {

            repositorio.agregarListadoDB(repositorio.listadoTerrenosAPI())
        }
    }

    fun checkIfDBEmpty() {

        viewModelScope.launch {
//            val prueba =repositorio.listadoTerrenosDB().toList().size
            pruebaDB.value = repositorio.listadoTerrenosDB().asLiveData().value?.size
//
//            if (prueba == 0){
//                repositorio.agregarListadoDB(repositorio.listadoTerrenos())
//            }

            if (listaTerrenosDB.value?.isEmpty() == true) {
                repositorio.agregarListadoDB(repositorio.listadoTerrenosAPI())
            }
        }

    }


}