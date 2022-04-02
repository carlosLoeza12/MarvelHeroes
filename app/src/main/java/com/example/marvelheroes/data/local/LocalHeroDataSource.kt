package com.example.marvelheroes.data.local

import com.example.marvelheroes.core.toHeroList
import com.example.marvelheroes.core.toHeroeSeriesList
import com.example.marvelheroes.data.model.Heroe
import com.example.marvelheroes.data.model.HeroesSeries
import javax.inject.Inject

class LocalHeroDataSource @Inject constructor(private val heroeDao: HeroeDao) {

    suspend fun getListHeroes(): List<Heroe> {
      return heroeDao.getAllHeroes().toHeroList()
    }

    suspend fun saveHero(heroeEntity: HeroeEntity){
        heroeDao.saveHeroe(heroeEntity)
    }

    suspend fun saveHeroeSerie(heroeSeriesEntity: HeroeSeriesEntity){
        heroeDao.saveHeroeSerie(heroeSeriesEntity)
    }

    suspend fun getListHeroesSeries(idHeroe: Int): List<HeroesSeries>{
        return heroeDao.getAllHeroesSeries(idHeroe).toHeroeSeriesList()
    }

}