package com.example.movieapplicationdemo.ui.main

class MainContract {

    interface View {

        fun showMovieFragment()
    }

    interface Presenter {

        fun attach(view: View)

        fun detach()

    }
}