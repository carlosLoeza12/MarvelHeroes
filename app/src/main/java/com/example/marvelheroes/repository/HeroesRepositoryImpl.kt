package com.example.marvelheroes.repository

import android.util.Log
import com.example.marvelheroes.core.InternetCheck
import com.example.marvelheroes.core.toHeroEntity
import com.example.marvelheroes.core.toHeroeSeriesEntity
import com.example.marvelheroes.data.local.LocalHeroDataSource
import com.example.marvelheroes.data.model.Heroe
import com.example.marvelheroes.data.model.HeroesSeries
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
            }
            localDataSource.getListHeroes()
        } else {
            return localDataSource.getListHeroes()
        }
    }

    override suspend fun getListSeriesByHeroe(idHero: Int): List<HeroesSeries> {
         return if(internetCheck.isConnected){
            remoteDataSource.getListSeriesByHeroe(idHero).data.results.forEach { heroeSeries ->
                localDataSource.saveHeroeSerie(heroeSeries.toHeroeSeriesEntity(idHero))
            }
            localDataSource.getListHeroesSeries(idHero)
        } else{
            return localDataSource.getListHeroesSeries(idHero)
        }
    }

}