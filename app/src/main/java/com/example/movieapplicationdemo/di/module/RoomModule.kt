package com.example.movieapplicationdemo.di.module

import android.content.Context
import androidx.room.Room
import com.example.movieapplicationdemo.database.MovieDao
import com.example.movieapplicationdemo.database.MovieDatabase
import com.example.movieapplicationdemo.utils.DB_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MovieDatabase =
        Room.databaseBuilder(context, MovieDatabase::class.java, DB_NAME)
            .build()

    @Singleton
    @Provides
    fun provideUserDao(movieDatabase: MovieDatabase): MovieDao = movieDatabase.getMovieDao()

}