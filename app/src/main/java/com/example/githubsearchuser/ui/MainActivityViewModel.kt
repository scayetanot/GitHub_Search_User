package com.example.githubsearchuser.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubsearchuser.data.ResultList
import com.example.githubsearchuser.data.model.GitHubUserListResult
import com.example.githubsearchuser.repository.AppRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl
) : ViewModel() {

    private var _resultList = MutableLiveData<List<GitHubUserListResult>>()
    var resultList: LiveData<List<GitHubUserListResult>> = _resultList

    private var _errorMessage = MutableLiveData<String>()
    var errorMessage: LiveData<String> = _errorMessage

    fun getGitHubUsers(name: String) {
        viewModelScope.launch {
            try {
                when (val response = repositoryImpl.getUserList(name)) {
                    is ResultList.Success -> {
                        _resultList.postValue(response.data)
                    }
                    is ResultList.Error -> {
                        _errorMessage.postValue(response.exception.toString())
                    }
                }
            } catch (e: java.lang.Exception) {
                _errorMessage.postValue(e.message)
                }
            }
        }
    }
}