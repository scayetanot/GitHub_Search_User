package com.example.githubsearchuser.repository

import com.example.githubsearchuser.data.ResultList
import com.example.githubsearchuser.data.model.GitHubUserListResult

interface AppRepository {
    suspend fun getUserList(username: String): ResultList<List<GitHubUserListResult>>

}