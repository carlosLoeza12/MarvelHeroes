package com.example.marvelheroes.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HeroeEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "urlImg")
    var urmImg: String
)

@Entity
data class HeroeSeriesEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name="idHeroe")
    val idHeroe: Int,
    @ColumnInfo(name="title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "urlImg")
    val urlImg: String
)