package com.example.marvelheroes.repository

import com.example.marvelheroes.data.model.Data
import com.example.marvelheroes.data.remote.HeroesDataSource
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(private val heroesDataSource: HeroesDataSource): HeroesRepository {
    override suspend fun getListHeroes(): Data = heroesDataSource.getListHeroes()
}