package com.example.githubsearchuser.data_source

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.githubsearchuser.api.ApiService
import com.example.githubsearchuser.data.ResultList
import com.example.githubsearchuser.data.model.GitHubUserListResult
import com.example.githubsearchuser.data.model.User
import com.example.githubsearchuser.data.model.UserInfo
import com.example.githubsearchuser.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.util.*

class RemoteDataSourceImpl(
    private val api: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
    ) : RemoteDataSource {
    override suspend fun getUsersList(
        name: String?): ResultList<List<GitHubUserListResult>> =
        withContext(ioDispatcher) {
            val request = api.searchUsers(name)
            val userList: List<GitHubUserListResult> = request.forEach(
                it.

            )
            ResultList.Success(userList)
        }

    override suspend fun getUserInfo(name: String): ResultList<UserInfo> {
        withContext(ioDispatcher) {
            val request = api.getUsernameInfo(name)
            ResultList.Success(request)
            ResultList.Error(null)
        }
    }
}