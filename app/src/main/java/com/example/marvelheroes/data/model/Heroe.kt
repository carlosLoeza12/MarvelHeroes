package com.example.marvelheroes.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Data(val data: Results)

data class Results(val results: List<Heroe>)
@Parcelize
data class Heroe(val id: Int = 0,
                 val name: String = "",
                 val description: String = "",
                 val thumbnail: Thumbnail? = null,
                 var urmImg: String = "",
                 val comics: ItemsCollection? = null,
                 val stories: ItemsCollection? = null,
                 val events: ItemsCollection? = null,
                 val series: ItemsCollection? =null
): Parcelable

@Parcelize
data class Thumbnail(
    val path: String,
    val extension: String
) : Parcelable

@Parcelize
data class ItemsCollection(val items: List<Item>): Parcelable

@Parcelize
data class Item(val name: String, val resourceURI: String): Parcelable


