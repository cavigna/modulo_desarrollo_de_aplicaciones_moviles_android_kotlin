package com.example.inmobiliariagalactica.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.inmobiliariagalactica.repository.Repositorio

class GalacticaModelFactory(private val repositorio: Repositorio): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GalacticaViewModel(repositorio) as T
    }
}



