package com.example.movieapplicationdemo.api

import com.example.movieapplicationdemo.model.Movie
import com.example.movieapplicationdemo.utils.BASE_URL
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("movies.json")
    fun getMovies(): Observable<List<Movie>>

    companion object Factory {
        fun create(): ApiInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}