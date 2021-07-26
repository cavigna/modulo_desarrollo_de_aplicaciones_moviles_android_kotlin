# MODULO 4 | Desarrollo de Aplicaciones Móviles Android Kotlin | Ignacio Cavallo



https://github.com/cavigna/modulo_desarrollo_de_aplicaciones_moviles_android_kotlin

## Clase 60 | 23-07

Ejercicio Mostrado en clase
# RESULTADO

![](fragmento.gif)




# CODIGO


## `MainActivity.kt`
```kotlin
package com.example.fragmentomasnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragmentomasnav.databinding.ActivityMainBinding
import com.example.fragmentomasnav.fragments.Avion
import com.example.fragmentomasnav.fragments.Barco
import com.example.fragmentomasnav.fragments.Taxi

class MainActivity : AppCompatActivity() {    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.taxi_item -> irFragmento(Taxi())
                R.id.avion_item -> irFragmento(Avion())
                R.id.barco_item -> irFragmento(Barco())
            }
            true
        }
    }

    fun irFragmento(fragmento: Fragment) {
        if (fragmento != null) {
            val transaccion = supportFragmentManager
                .beginTransaction()
                .replace(R.id.contenedor, fragmento)
                .commit()
        }

    }
}


```


![](resultado.png)