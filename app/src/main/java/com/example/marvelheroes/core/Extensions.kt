package com.example.marvelheroes.core

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.marvelheroes.data.local.HeroeEntity
import com.example.marvelheroes.data.local.SeriesEntity
import com.example.marvelheroes.data.model.Heroe
import com.example.marvelheroes.data.model.Item
import com.example.marvelheroes.data.model.ItemsCollection

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

fun Item.toSerieEntity(idHero: Int): SeriesEntity =
    SeriesEntity(name = this.name, idHeroe = idHero, resourceURI = this.resourceURI)


val Context.networkInfo: NetworkInfo?
    get() =
        (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo