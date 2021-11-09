package com.example.inmobiliariagalactica.fragments.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.inmobiliariagalactica.R
import com.example.inmobiliariagalactica.application.GalacticaApplication
import com.example.inmobiliariagalactica.databinding.FragmentHomeBinding
import com.example.inmobiliariagalactica.viewmodel.GalacticaModelFactory
import com.example.inmobiliariagalactica.viewmodel.GalacticaViewModel
import kotlinx.coroutines.MainScope


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel : GalacticaViewModel by activityViewModels {
        GalacticaModelFactory((requireActivity().application as GalacticaApplication).repository)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

//        viewModel.listaTerreno.observe(viewLifecycleOwner, {
//            val terreno = it[0]
//
//            binding.textView.text = terreno.price.toString()
//
//            binding.imageView.load(terreno.imgSrc)
//        })


       lifecycleScope.launchWhenCreated {
           val algo = viewModel.prueba()

           Log.i("rpeuba", algo.toString())
       }
        return binding.root
    }


}