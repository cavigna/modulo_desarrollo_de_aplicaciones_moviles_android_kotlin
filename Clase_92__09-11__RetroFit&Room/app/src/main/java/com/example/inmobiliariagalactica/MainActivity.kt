package com.example.inmobiliariagalactica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.inmobiliariagalactica.application.GalacticaApplication
import com.example.inmobiliariagalactica.databinding.ActivityMainBinding
import com.example.inmobiliariagalactica.viewmodel.GalacticaModelFactory
import com.example.inmobiliariagalactica.viewmodel.GalacticaViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

   private val viewModel : GalacticaViewModel by viewModels{
        GalacticaModelFactory((application as GalacticaApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}

/*
https://android-kotlin-fun-mars-server.appspot.com/realestate
 */