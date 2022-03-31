package com.example.marvelheroes.di

import android.content.Context
import androidx.room.Room
import com.example.marvelheroes.application.AppConstants
import com.example.marvelheroes.data.local.AppDatabase
import com.example.marvelheroes.data.local.HeroeDao
import com.example.marvelheroes.repository.WebService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(AppConstants.okHttp.build())
            .build()

    @Singleton
    @Provides
    fun provideHeroeService(retrofit: Retrofit): WebService = retrofit.create(WebService::class.java)

    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context, AppDatabase::class.java,
            "hero_database"
        ).build()

    @Singleton
    @Provides
    fun provideHeroeDao(appDatabase: AppDatabase): HeroeDao = appDatabase.heroeDao()

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context

}