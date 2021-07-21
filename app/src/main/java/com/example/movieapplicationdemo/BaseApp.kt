package com.example.movieapplicationdemo

import com.example.movieapplicationdemo.di.component.ApplicationComponent
import com.example.movieapplicationdemo.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApp : DaggerApplication(){

    private lateinit var applicationComponent: ApplicationComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        applicationComponent = DaggerApplicationComponent.builder().application(this).build()
        applicationComponent.inject(this)
        return applicationComponent
    }
}