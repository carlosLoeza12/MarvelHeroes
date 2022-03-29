package com.example.marvelheroes.data.remote

import com.example.marvelheroes.application.AppConstants
import com.example.marvelheroes.data.model.Data
import com.example.marvelheroes.repository.WebService

class HeroesDataSource(private val webService: WebService) {
    suspend fun getListHeroes(): Data = webService.getListHeroes(1, AppConstants.PUBLIC_API_KEY, AppConstants.MD5)
}