package com.example.marvelheroes.data.local

import com.example.marvelheroes.core.toHeroList
import com.example.marvelheroes.data.model.Heroe
import com.example.marvelheroes.data.model.Item
import javax.inject.Inject

class LocalHeroDataSource @Inject constructor(private val heroeDao: HeroeDao) {

    suspend fun getListHeroes(): List<Heroe> {
      return heroeDao.getAllHeroes().toHeroList()
    }

    suspend fun saveHero(heroeEntity: HeroeEntity){
        heroeDao.saveHeroe(heroeEntity)
    }

    suspend fun saveSeries(seriesEntity: SeriesEntity){
        heroeDao.saveSeries(seriesEntity)
    }

    suspend fun getSeriesByHeroe(idHeroe: Int): List<Item>{
       return heroeDao.getAllSeriesByHero(idHeroe)
    }

}