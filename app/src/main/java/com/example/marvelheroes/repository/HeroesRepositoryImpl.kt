package com.example.marvelheroes.repository

import com.example.marvelheroes.data.model.Data
import com.example.marvelheroes.data.remote.HeroesDataSource

class HeroesRepositoryImpl(private val heroesDataSource: HeroesDataSource): HeroesRepository {
    override suspend fun getListHeroes(): Data = heroesDataSource.getListHeroes()
}