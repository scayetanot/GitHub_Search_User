package com.example.githubsearchuser.repository

import com.example.githubsearchuser.data.RemoteDataNotFoundException
import com.example.githubsearchuser.data.ResultList
import com.example.githubsearchuser.data.model.GitHubUserListResult
import com.example.githubsearchuser.data_source.LocalDataSourceRoomDb
import com.example.githubsearchuser.data_source.RemoteDataSource
import com.example.githubsearchuser.di.IoDispatcher
import com.example.githubsearchuser.utils.InternetUtil
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AppRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSourceRoomDb,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : AppRepository {

    private val isInternetOn = InternetUtil.isInternetOn()

    override suspend fun getUserList(username: String): ResultList<List<GitHubUserListResult>> {
        return if (isInternetOn) {
            getUserListFromApi(username)
        } else {
            getUserListFromDb(username)
        }
    }

    private suspend fun getUserListFromApi(username: String) : ResultList<List<GitHubUserListResult>> {
        return when (val result = remoteDataSource.getUsersList(username)) {
            is ResultList.Success -> {
                val response = result.data
                withContext(ioDispatcher) {
                    // for the purpose of the App, all entities are deleted
                    //localDataSource.deleteAllForecast()
                   // localDataSource.setForecast(response)
                }
                ResultList.Success(response)
            }
            is ResultList.Error -> {
                ResultList.Error(RemoteDataNotFoundException())
            }
        }
    }

    private fun getUserListFromDb(username: String) : ResultList<List<GitHubUserListResult>> {

    }
}