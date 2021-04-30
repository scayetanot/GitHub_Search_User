package com.example.githubsearchuser.ui

import androidx.lifecycle.ViewModel
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl
) : ViewModel() {


}