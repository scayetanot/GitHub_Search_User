package com.example.githubsearchuser.di.component

import android.content.Context
import com.example.githubsearchuser.ui.MainActivity
import com.example.githubsearchuser.di.modules.*
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        CoroutinesModule::class,
        StorageModule::class
    ]
)

interface AppComponents {
    fun context(): Context

    fun retrofit(): Retrofit

    fun appDataObject(): LocalDataSourceRoomDb
    fun appDataBase(): LocalDataSourceDataObject

    fun inject(mainActivity: MainActivity)
}