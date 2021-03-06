package com.example.marvelheroes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marvelheroes.data.model.HeroesSeries
import com.example.marvelheroes.databinding.ItemHeroeCollectionsBinding

class HeroesCollectionAdapter(private val listCollections: List<HeroesSeries>
) : RecyclerView.Adapter<HeroesCollectionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesCollectionAdapter.ViewHolder {
       val itemBinding = ItemHeroeCollectionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HeroesCollectionAdapter.ViewHolder, position: Int) {
        holder.bind(listCollections[position])
    }

    override fun getItemCount(): Int = listCollections.size

    inner class ViewHolder(private val itemBinding: ItemHeroeCollectionsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(series: HeroesSeries) {
            itemBinding.txtSerieName.text = series.title
            itemBinding.txtSerieDescription.text = series.description
            itemBinding.imgSerie.load(series.urmImg)
        }
    }
}
