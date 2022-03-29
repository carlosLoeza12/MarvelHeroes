package com.example.marvelheroes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelheroes.data.model.Item
import com.example.marvelheroes.databinding.ItemHeroeCollectionsBinding

class HeroesCollectionAdapter(private val listCollections: List<Item>
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
        fun bind(collection: Item) {
            itemBinding.txtNameCollection.text = collection.name
        }
    }
}