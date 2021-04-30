package com.example.githubsearchuser.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.githubsearchuser.MainApplication
import com.example.githubsearchuser.R
import com.example.githubsearchuser.utils.viewModelProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val appComponents by lazy { MainApplication.appComponents }


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        appComponents.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initObservers()
    }

    private fun getViewModel(): MainActivityViewModel {
        return viewModelProvider(viewModelFactory)
    }

    private fun initViews() {
        //getViewModel().getForeCast(latitude, longitude )
    }

    private initObservers() {

    }
}