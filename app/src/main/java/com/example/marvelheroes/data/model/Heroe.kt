package com.example.marvelheroes.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Data(val data: Results)

data class Results(val results: List<Heroe>)
@Parcelize
data class Heroe(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val thumbnail: Thumbnail? = null,
    var urmImg: String = "",
): Parcelable

@Parcelize
data class Thumbnail(
    val path: String,
    val extension: String
) : Parcelable

data class DataSeries(val data: ResultsSeries)

data class ResultsSeries(val results: List<HeroesSeries>)

data class HeroesSeries(
    val id: Int,
    val title: String,
    val description: String?,
    val thumbnail: Thumbnail?,
    val urmImg: String
)
