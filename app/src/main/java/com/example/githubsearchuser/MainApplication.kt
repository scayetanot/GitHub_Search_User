package com.example.githubsearchuser

import android.app.Application
import com.example.githubsearchuser.di.component.AppComponents
import com.example.githubsearchuser.di.modules.AppModule
import com.example.githubsearchuser.di.modules.StorageModule
import com.example.githubsearchuser.utils.InternetUtil

open class MainApplication : Application() {

    companion object {
        lateinit var appComponents: AppComponents
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDagger(this)
        InternetUtil.init(this)
    }

    private fun initDagger(app: MainApplication): AppComponents =
        DaggerAppComponents.builder()
            .appModule(AppModule(app))
            .storageModule(StorageModule(app))
            .build()
}