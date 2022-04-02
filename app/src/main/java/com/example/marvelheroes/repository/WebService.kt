package com.example.marvelheroes.repository

import com.example.marvelheroes.data.model.Data
import com.example.marvelheroes.data.model.DataSeries
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {
    @GET("public/characters")
    suspend fun getListHeroes(
        @Query("ts") ts: Int,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Data

    @GET("public/characters/{id}/series")
    suspend fun getListSeriesByHeroe(
        @Path("id")idHeroe: Int,
        @Query("ts") ts: Int,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): DataSeries

}