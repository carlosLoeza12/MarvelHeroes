package com.example.marvelheroes.repository

import com.example.marvelheroes.data.model.Data

interface HeroesRepository {
    suspend fun getListHeroes(): Data
}