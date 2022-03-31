package com.example.marvelheroes.repository

import com.example.marvelheroes.data.model.Heroe
import com.example.marvelheroes.data.model.Item

interface HeroesRepository {
    suspend fun getListHeroes(): List<Heroe>
    suspend fun getSeriesByHeroe(idHero: Int): List<Item>
}