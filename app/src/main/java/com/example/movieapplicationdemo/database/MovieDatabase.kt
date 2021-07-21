package com.example.movieapplicationdemo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapplicationdemo.model.Movie
import com.example.movieapplicationdemo.utils.VERSION

@Database(entities = [Movie::class], version = VERSION, exportSchema = false)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun getMovieDao(): MovieDao

}