package com.example.marvelheroes.core

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.marvelheroes.data.local.HeroeEntity
import com.example.marvelheroes.data.local.HeroeSeriesEntity
import com.example.marvelheroes.data.model.Heroe
import com.example.marvelheroes.data.model.HeroesSeries

fun Activity.toolbar(toolbar: Toolbar){
    (this as AppCompatActivity).setSupportActionBar(toolbar)
    this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener {
        this.onBackPressed()
    }
    toolbar.navigationIcon?.setTint(Color.WHITE)
}

fun List<HeroeEntity>.toHeroList(): List<Heroe>{
    val resultList = mutableListOf<Heroe>()
    this.forEach { itemEntity ->
        resultList.add(itemEntity.toHero())
    }
    return resultList
}

fun HeroeEntity.toHero() : Heroe = Heroe(
    this.id,
    this.name,
    this.description,
    null,
    this.urmImg
)

fun Heroe.toHeroEntity() : HeroeEntity{
    val ruta = this.thumbnail?.path?.replace("http", "https")+"."+ this.thumbnail?.extension

    return HeroeEntity(
        this.id,
        this.name,
        this.description,
        ruta
    )
}

fun HeroesSeries.toHeroeSeriesEntity(idHeroe: Int): HeroeSeriesEntity{
    val ruta = this.thumbnail?.path?.replace("http", "https")+"."+ this.thumbnail?.extension
    return HeroeSeriesEntity(
        this.id,
        idHeroe,
        this.title,
        this.description, ruta)
}

fun List<HeroeSeriesEntity>.toHeroeSeriesList(): List<HeroesSeries>{
    val listSeries = mutableListOf<HeroesSeries>()
    this.forEach { serieEntity ->
        listSeries.add(serieEntity.toHeroeSerie())
    }
    return listSeries
}

fun HeroeSeriesEntity.toHeroeSerie(): HeroesSeries{
    return HeroesSeries(
        this.id,
        this.title,
        this.description,
        null,
        this.urlImg
    )
}

val Context.networkInfo: NetworkInfo?
    get() =
        (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo