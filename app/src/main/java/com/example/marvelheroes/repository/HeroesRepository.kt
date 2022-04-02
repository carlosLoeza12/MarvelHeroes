package com.example.marvelheroes.repository

import com.example.marvelheroes.data.model.Heroe
import com.example.marvelheroes.data.model.HeroesSeries

interface HeroesRepository {
    suspend fun getListHeroes(): List<Heroe>
    suspend fun getListSeriesByHeroe(idHeroe: Int): List<HeroesSeries>
}