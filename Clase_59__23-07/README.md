# MODULO 4 | Desarrollo de Aplicaciones Móviles Android Kotlin | Ignacio Cavallo



https://github.com/cavigna/modulo_desarrollo_de_aplicaciones_moviles_android_kotlin

## Clase 59 | 23-07

Nuevamente, la clases no aportan en nada y eso agrava la falte de motivación propia y de mis compañeros. En fin, como no me gusta perder el tiempo, estoy aprendiendo sobre fragmentos, menús como también componentes de navegación.
# RESULTADO

![](fragments.gif)




# CODIGO


## `MainActivity.kt`
```kotlin
package com.example.fragmentoycajon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fragmentoycajon.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navView: NavigationView = findViewById(R.id.navigationView)

        val navigationHost =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        val navController = navigationHost.navController
        drawerLayout = findViewById(R.id.drawer_layout)
        navView.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp(appBarConfiguration) || return super.onSupportNavigateUp()
    }

}
```


![](resultado.png)