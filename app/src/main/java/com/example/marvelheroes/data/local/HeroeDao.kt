package com.example.marvelheroes.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvelheroes.data.model.Item

@Dao
interface HeroeDao {

    @Query("SELECT * FROM HeroeEntity")
    suspend fun getAllHeroes(): List<HeroeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHeroe(heroeEntity: HeroeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSeries(seriesEntity: SeriesEntity)

    @Query("SELECT *FROM SeriesEntity where idHeroe = :id")
    suspend fun getAllSeriesByHero(id: Int): List<Item>

}