package com.example.marvelheroes.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HeroeDao {

    @Query("SELECT * FROM HeroeEntity")
    suspend fun getAllHeroes(): List<HeroeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHeroe(heroeEntity: HeroeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHeroeSerie(heroeSeriesEntity: HeroeSeriesEntity)

    @Query("SELECT * FROM HeroeSeriesEntity WHERE idHeroe = :idHeroe")
    suspend fun getAllHeroesSeries(idHeroe: Int): List<HeroeSeriesEntity>

}