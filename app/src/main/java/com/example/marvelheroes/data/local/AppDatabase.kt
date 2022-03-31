package com.example.marvelheroes.data.local
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HeroeEntity::class, SeriesEntity::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun heroeDao(): HeroeDao
}