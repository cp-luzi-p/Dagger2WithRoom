package com.example.movieapplicationdemo.ui.movie

import android.view.View
import com.example.movieapplicationdemo.model.Movie

class MovieContract {

    interface MovieView {

        fun showProgress(show:Boolean)

        fun showErrorMessage(error: String)

        fun loadDataSuccess(movie: List<Movie>)
    }

    interface Presenter {
        fun attach(view: MovieView)

        fun detach()
        fun loadMovies()
    }
}