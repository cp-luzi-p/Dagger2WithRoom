package com.example.movieapplicationdemo.ui.main

import android.os.Bundle
import com.example.movieapplicationdemo.R
import com.example.movieapplicationdemo.ui.movie.MovieFragment
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() , MainContract.View{

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this@MainActivity)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attach(this)
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun showMovieFragment() {
       supportFragmentManager.beginTransaction()
           .replace(R.id.mainNavFragment, MovieFragment().newInstance(),MovieFragment.TAG)
           .commit()
    }
}

