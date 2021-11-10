package com.example.inmobiliariagalactica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView.ScaleType.*
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.inmobiliariagalactica.databinding.ItemRowBinding
import com.example.inmobiliariagalactica.model.Terreno

class GalacticViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding = ItemRowBinding.bind(itemView)

    companion object {
        fun create(parent: ViewGroup): GalacticViewHolder{
            val layoutInflaterB = LayoutInflater.from(parent.context)
            val binding = ItemRowBinding.inflate(layoutInflaterB, parent, false)

            return GalacticViewHolder(binding.root)
        }
    }

    fun unidorImagen(terreno: Terreno){
        binding.imageViewGal.scaleType = FIT_XY

        binding.imageViewGal.load(terreno.imgSrc)

        /*
        with. load. into..
         */
    }

}
