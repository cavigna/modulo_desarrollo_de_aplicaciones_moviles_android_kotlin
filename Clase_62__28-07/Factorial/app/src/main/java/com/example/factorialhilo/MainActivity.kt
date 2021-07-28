package com.example.factorialhilo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import com.example.factorialhilo.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.button.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val numeroUsuario = binding.editTextNumber.text.toString()
                val numerodos = numeroUsuario.toInt()
                val resultado = factorial(numerodos).toString()
                binding.textviewResultado.text = resultado

            }
        }

    }


     suspend  fun factorial(n: Int): Int {
        Log.v("Tokio", "$n")
        return if( n==0) 1 else n * factorial(n - 1)
    }


}