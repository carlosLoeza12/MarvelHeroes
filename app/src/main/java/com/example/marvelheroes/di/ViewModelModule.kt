package com.example.marvelheroes.di

import com.example.marvelheroes.repository.HeroesRepository
import com.example.marvelheroes.repository.HeroesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindRepoImpl(heroesRepositoryImpl: HeroesRepositoryImpl): HeroesRepository
}