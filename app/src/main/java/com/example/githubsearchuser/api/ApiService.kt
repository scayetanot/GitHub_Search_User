package com.example.githubsearchuser.api

import com.example.githubsearchuser.data.model.User
import com.example.githubsearchuser.data.model.UserInfo
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @GET("/users")
    @Headers("application/vnd.github.v3+json")
    suspend fun getAllUsers(): List<User>

    @GET("/users/{username}")
    @Headers("application/vnd.github.v3+json")
    suspend fun getUsernameInfo(@Path("username") username: String?): UserInfo

    @GET("/search/q={username}")
    @Headers("application/vnd.github.v3+json")
    suspend fun searchUsers(@Path("username") username: String?): List<User>

}