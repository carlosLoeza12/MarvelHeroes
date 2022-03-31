package com.example.marvelheroes.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class HeroeEntity(
    @PrimaryKey()
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "urlImg")
    var urmImg: String
) : Parcelable


@Entity()
@Parcelize
data class SeriesEntity(
    @PrimaryKey()
    val name: String,
    @ColumnInfo(name="idHeroe")
    val idHeroe: Int,
    @ColumnInfo(name = "resourceURI")
    val resourceURI: String
) : Parcelable