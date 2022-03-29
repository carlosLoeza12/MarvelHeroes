package com.example.marvelheroes.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Data(val data: Results)

data class Results(val results: List<Heroe>)
@Parcelize
data class Heroe(val id: Int,
                 val name: String,
                 val description: String,
                 val thumbnail: Thumbnail,
                 var urmImg: String,
                 val comics: ItemsCollection,
                 val stories: ItemsCollection,
                 val events: ItemsCollection,
                 val series: ItemsCollection
): Parcelable

@Parcelize
data class Thumbnail(
    val path: String,
    val extension: String
) : Parcelable

@Parcelize
data class ItemsCollection(val items: List<Item>): Parcelable

@Parcelize
data class Item(val name: String): Parcelable


