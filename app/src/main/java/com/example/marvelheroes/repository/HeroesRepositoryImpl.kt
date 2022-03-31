package com.example.marvelheroes.repository

import android.util.Log
import com.example.marvelheroes.core.InternetCheck
import com.example.marvelheroes.core.toHeroEntity
import com.example.marvelheroes.core.toSerieEntity
import com.example.marvelheroes.data.local.LocalHeroDataSource
import com.example.marvelheroes.data.model.Heroe
import com.example.marvelheroes.data.model.Item
import com.example.marvelheroes.data.remote.RemoteHeroesDataSource
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteHeroesDataSource,
    private val localDataSource: LocalHeroDataSource,
    private val internetCheck: InternetCheck
) : HeroesRepository {

    override suspend fun getListHeroes(): List<Heroe> {

        return if (internetCheck.isConnected) {
            remoteDataSource.getListHeroes().data.results.forEach { heroe ->
                localDataSource.saveHero(heroe.toHeroEntity())
                heroe.series?.items?.forEach { serie ->
                   Log.e("a", heroe.name)
                    //saveSeries(serie, heroe.id)
                    localDataSource.saveSeries(serie.toSerieEntity(idHero = heroe.id))
                }
            }
            localDataSource.getListHeroes()
        } else {
            return localDataSource.getListHeroes()
        }
    }

    override suspend fun getSeriesByHeroe(idHero: Int): List<Item> {
      return localDataSource.getSeriesByHeroe(idHero)
    }

    private suspend fun saveSeries(item: Item, idHero: Int){
        localDataSource.saveSeries(item.toSerieEntity(idHero))
    }
}