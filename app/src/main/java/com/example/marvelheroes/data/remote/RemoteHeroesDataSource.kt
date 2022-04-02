package com.example.marvelheroes.data.remote

import com.example.marvelheroes.application.AppConstants
import com.example.marvelheroes.data.model.Data
import com.example.marvelheroes.data.model.DataSeries
import com.example.marvelheroes.repository.WebService
import javax.inject.Inject

class RemoteHeroesDataSource @Inject constructor(private val webService: WebService) {

    suspend fun getListHeroes(): Data =
        webService.getListHeroes(1, AppConstants.PUBLIC_API_KEY, AppConstants.MD5)

    suspend fun getListSeriesByHeroe(idHeroe: Int): DataSeries =
        webService.getListSeriesByHeroe(idHeroe, 1, AppConstants.PUBLIC_API_KEY, AppConstants.MD5)

}