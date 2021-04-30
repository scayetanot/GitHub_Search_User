package com.example.githubsearchuser.data

sealed class ResultList<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultList<T>()
    data class Error(val exception: Exception) : ResultList<Nothing>()
}