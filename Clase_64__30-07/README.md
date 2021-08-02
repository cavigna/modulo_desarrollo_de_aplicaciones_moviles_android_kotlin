# MODULO 4 | Desarrollo de Aplicaciones Móviles Android Kotlin | Ignacio Cavallo



https://github.com/cavigna/modulo_desarrollo_de_aplicaciones_moviles_android_kotlin

## Clase 64 | 30-07
Para mi reflexión, básicamente voy a hacer lo mismo que se viene haciendo las ultimas clases, repetición de patrones que no aportan en nada. Por eso repito:
>La clase de hoy viene repitiendo la misma lógica de las últimas semanas. El profesor hace aparición a las 8:30 para saludar, dar alguna directiva y de ahí silencio total. Luego regresa a las 10 para avisarnos del break, y finalmente aparece a las 12:30 para despedirse. Literalmente habla o dice algo 10 minutos de 4 horas.  

Es por ello que empiezo a trabajar con el ejercicio del profesor que incluye APIRest, que nos enseñará la semana que viene..., cuando hubo tiempo de sobra para empezar con los temas esta semana.


### Estoy demasiado frustrado, y por ello es que mis reflexiones son cada vez más negativas. Nuevamente pido disculpas por ello, espero que alguién lea esto y podamos construir un cambio en el tiempo que nos queda de cursado.


 Ejercicio Propuesto por el Prof.

 ![](ejer.png)
# RESULTADO

![](hilos.gif)




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


![](resultado.png)