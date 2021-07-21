package com.example.movieapplicationdemo.ui.main

import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter @Inject constructor() : MainContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    lateinit var view: MainContract.View


    override fun detach() {
        compositeDisposable.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showMovieFragment() // as Default
    }
}