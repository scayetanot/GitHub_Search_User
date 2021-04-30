package com.example.githubsearchuser.data.model

import androidx.room.Entity

@Entity(tableName = "GitHubUserList", primaryKeys = ["login"])
data class GitHubUserListResult (
    val login: String?,
    val avatar_url: String,
    val public_repos: Int
)