package com.example.movieapplicationdemo.ui.movie

import com.example.movieapplicationdemo.api.ApiInterface
import com.example.movieapplicationdemo.database.MovieDao
import com.example.movieapplicationdemo.model.Movie
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MoviePresenter @Inject constructor(var movieDao: MovieDao) : MovieContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiInterface = ApiInterface.create()
    lateinit var view: MovieContract.MovieView

    override fun attach(view: MovieContract.MovieView) {
        this.view = view
    }

    override fun detach() {
       subscriptions.clear()
    }

    override fun loadMovies() {
        val subscribe = Observable.fromCallable { movieDao.getAllMovies() }
            .concatMap { dbUserList ->
                if (dbUserList.isEmpty())
                    api.getMovies().concatMap { apiMovieList ->
                        movieDao.insert(*apiMovieList.toTypedArray())
                        Observable.just(apiMovieList)
                    }
                else
                    Observable.just(dbUserList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: List<Movie> ->
                view.showProgress(false)
                view.loadDataSuccess(list.take(10))
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.message.toString())
            })

        subscriptions.add(subscribe)
    }
}