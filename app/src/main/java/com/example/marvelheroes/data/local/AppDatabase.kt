package com.example.marvelheroes.data.local
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HeroeEntity::class, HeroeSeriesEntity::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun heroeDao(): HeroeDao
}