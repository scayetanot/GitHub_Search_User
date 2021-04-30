package com.example.githubsearchuser.data_source

import com.example.githubsearchuser.data.ResultList
import com.example.githubsearchuser.data.model.GitHubUserListResult
import com.example.githubsearchuser.data.model.UserInfo

interface RemoteDataSource {
    suspend fun getUsersList(name: String?): ResultList<List<GitHubUserListResult>>
    suspend fun getUserInfo(name: String): ResultList<UserInfo>
}