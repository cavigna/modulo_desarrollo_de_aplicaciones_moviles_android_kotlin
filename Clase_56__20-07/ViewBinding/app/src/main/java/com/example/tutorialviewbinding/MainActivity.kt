package com.example.tutorialviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.tutorialviewbinding.databinding.ActivityMainBinding


//import kotlinx.android.synthetic.main.activity_main.* ===> ERROR! DEPECREATED.

/*
*       **** TODO THE OLD WAY ****

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)


        val binding = ActivityMainBinding.inflate(layoutInflater)
        val textUno = findViewById<TextView>(R.id.textUno)
        textUno.setText("Dos")

        setContentView(binding.root)


        setContentView(binding.root)

        //binding.tv1.setText("Algo")
    }
}
*/

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater) //==> Generamos un Binding
        setContentView(binding.root) // ===> Definimos el contenido en el root de binding

        binding.textUno.setText("Esto es View Binding")

        binding.textUno.text = "Otra cosa mariposa"
        binding.textUno.textSize = 25.0F

        binding.buttonB.setText("este es un boton")

    }
}


//ActivityMainBinding.inflate(layoutInflater).apply {
//    setContentView(root)
//}