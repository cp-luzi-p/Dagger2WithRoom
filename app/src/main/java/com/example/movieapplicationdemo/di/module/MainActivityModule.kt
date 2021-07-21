package com.example.movieapplicationdemo.di.module

import com.example.movieapplicationdemo.ui.movie.MovieFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun provideMovieFragment(): MovieFragment

}