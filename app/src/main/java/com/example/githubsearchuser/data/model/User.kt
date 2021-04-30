package com.example.githubsearchuser.data.model

data class User (
    val login: String?,
    val avatar_url: String
) {
    fun toGitHubUserListResult(nbRepos: Int = 0): GitHubUserListResult {
        return GitHubUserListResult(login, avatar_url,nbRepos)
    }
}