package com.example.marvelheroes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marvelheroes.data.model.Heroe
import com.example.marvelheroes.databinding.ItemHeroeBinding

class HeroesAdapter(
    private val list: List<Heroe>,
    private val itemClickListener: OnHeroesClickListener
) : RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {

    interface OnHeroesClickListener{
        fun onHeroesClick(heroe: Heroe, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesAdapter.ViewHolder {
        val itemBinding = ItemHeroeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ViewHolder(itemBinding)
        itemBinding.root.setOnClickListener {
            val position = holder.adapterPosition.takeIf {
                it != -1
            } ?: return@setOnClickListener
            itemClickListener.onHeroesClick(list[position], position)
        }
        return holder
    }

    override fun onBindViewHolder(holder: HeroesAdapter.ViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ItemHeroeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(heroe: Heroe){
            binding.txtName.text = heroe.name
            val ruta = heroe.thumbnail.path.replace(
                "http",
                "https") + "." + heroe.thumbnail.extension
            heroe.urmImg = ruta
            binding.imgHeroe.load(ruta)
        }
    }

}