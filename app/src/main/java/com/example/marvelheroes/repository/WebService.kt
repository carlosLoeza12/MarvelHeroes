package com.example.marvelheroes.repository

import com.example.marvelheroes.application.AppConstants
import com.example.marvelheroes.data.model.Data
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("public/characters")
    suspend fun getListHeroes(
        @Query("ts") ts: Int,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Data
}

object RetrofitClient{

    val WebService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(AppConstants.okHttp.build())
            .build().create(WebService::class.java)
    }
}
