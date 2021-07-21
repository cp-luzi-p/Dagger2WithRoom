package com.example.movieapplicationdemo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapplicationdemo.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg movie: Movie)

    @Query("select * from tbl_Movie")
    fun getAllMovies(): List<Movie>

}