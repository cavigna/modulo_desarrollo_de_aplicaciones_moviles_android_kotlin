package com.example.inmobiliariagalactica.adapter


import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.inmobiliariagalactica.R
import com.example.inmobiliariagalactica.model.Terreno

class TerrenoListAdapter: ListAdapter<Terreno, GalacticViewHolder>(TerrenoComparator()) {

    var terrenoA = Terreno()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalacticViewHolder {
        return GalacticViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: GalacticViewHolder, position: Int) {
        val terreno = getItem(position)

        holder.unidorImagen(terreno)

        holder.binding.imageViewGal.setOnClickListener {
            terrenoA.type = terreno.type
            terrenoA.imgSrc = terreno.imgSrc
            terrenoA.price = terreno.price
            Navigation.findNavController(holder.itemView).navigate(R.id.action_homeFragment_to_detailsFragment)
        }
    }
}

class TerrenoComparator : DiffUtil.ItemCallback<Terreno>() {
    override fun areItemsTheSame(oldItem: Terreno, newItem: Terreno): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Terreno, newItem: Terreno): Boolean {
        return  oldItem.id == newItem.id

    }

}
