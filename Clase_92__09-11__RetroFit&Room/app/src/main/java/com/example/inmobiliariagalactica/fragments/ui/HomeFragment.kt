package com.example.inmobiliariagalactica.fragments.ui

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.inmobiliariagalactica.adapter.TerrenoListAdapter
import com.example.inmobiliariagalactica.application.GalacticaApplication
import com.example.inmobiliariagalactica.databinding.FragmentHomeBinding
import com.example.inmobiliariagalactica.viewmodel.GalacticaModelFactory
import com.example.inmobiliariagalactica.viewmodel.GalacticaViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var application: Application

    private val viewModel : GalacticaViewModel by activityViewModels {
        GalacticaModelFactory((application as GalacticaApplication).repository)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        application = requireActivity().application

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val recyclerView = binding.recyclerView
        val adapter = TerrenoListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL,false)

        viewModel.listaTerrenosDB.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        viewModel.currentTerreno.value = adapter.terrenoA






        return binding.root
    }


}

/*
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
 */