# MODULO 4 | Desarrollo de Aplicaciones Móviles Android Kotlin | Ignacio Cavallo



https://github.com/cavigna/modulo_desarrollo_de_aplicaciones_moviles_android_kotlin

## Clase 92 | 09-11

En la calse de hoy se propuso un ejercicio muy desafiante que consiste en aplicar lo aprendido en hasta el momento. Este consiste en hacer una llamda a una API, y con esa información gaurdarla de forma interna en una Base de Datos usando ROOM.
El principal desafio será combinar fuentes de datos de forma local como remotas, a partir del patrón de vista MODELO VISTA VISTA MODELO. Estas fuentes de datos estarán contenidas en un repositorio.



> ......







# CODIGO


## `MainActivity.kt`
```kotlin
package com.example.booksv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.booksv1.RetrofitInstance.retroService
import com.example.booksv1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        lifecycleScope.launchWhenCreated {
            val response = retroService.searchByName()
            val data = response.body()!!

            if (response.isSuccessful){
                Log.v("Libros", response.body().toString())
                binding.tvprueba.text = data.items.get(0).volumeInfo.title

            }
        }
    }

    private fun getBookByName(){
        lifecycleScope.launch{

        }
    }
}


```


