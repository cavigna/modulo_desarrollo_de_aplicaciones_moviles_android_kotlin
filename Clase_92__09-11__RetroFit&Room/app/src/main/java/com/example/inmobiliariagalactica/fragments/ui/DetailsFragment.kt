package com.example.inmobiliariagalactica.fragments.ui

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.inmobiliariagalactica.R
import com.example.inmobiliariagalactica.application.GalacticaApplication
import com.example.inmobiliariagalactica.databinding.FragmentDetailsBinding
import com.example.inmobiliariagalactica.viewmodel.GalacticaModelFactory
import com.example.inmobiliariagalactica.viewmodel.GalacticaViewModel


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    private lateinit var app : Application

    private val viewModel : GalacticaViewModel by activityViewModels{
        GalacticaModelFactory((app as GalacticaApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        app =  requireActivity().application

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)

        viewModel.currentTerreno.observe(viewLifecycleOwner, {
            binding.apply {
                imageView.load(it.imgSrc)
                textView.text =  it.type
                textView2.text = it.price.toString()

            }








        })

        return binding.root


    }

}