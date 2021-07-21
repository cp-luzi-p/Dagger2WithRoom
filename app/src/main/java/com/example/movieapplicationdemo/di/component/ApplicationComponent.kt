package com.example.movieapplicationdemo.di.component

import android.app.Application
import com.example.movieapplicationdemo.BaseApp
import com.example.movieapplicationdemo.di.module.ActivityBuilder
import com.example.movieapplicationdemo.di.module.AppModule
import com.example.movieapplicationdemo.di.module.RoomModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
    ActivityBuilder::class,
    RoomModule::class,
    AppModule::class]
)

interface ApplicationComponent: AndroidInjector<BaseApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app:Application): Builder
        fun build(): ApplicationComponent
    }
}