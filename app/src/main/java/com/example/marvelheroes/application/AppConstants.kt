package com.example.marvelheroes.application

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object AppConstants {
    //api Marvel
    const val BASE_URL = "https://gateway.marvel.com/v1/"
    const val PUBLIC_API_KEY = "51188fe7b34e4729249d7d6b6edab54c"
    const val PRIVATE_API_KEY = "dfd3f4aaf4f4c9e0579401c2492504256d3c9972"
    const val MD5 = "dc5f31b4c51d4645e736e4b9b71a42c2"
    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var okHttp = OkHttpClient.Builder().addInterceptor(logger)
    //SignIn
    const val RC_GOOGLE_SIGNING = 100
}