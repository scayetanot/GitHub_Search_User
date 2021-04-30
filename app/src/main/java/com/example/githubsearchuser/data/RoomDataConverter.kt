package com.example.githubsearchuser.data

import androidx.room.TypeConverter
import com.example.githubsearchuser.data.model.GitHubUserListResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type

class RoomDataConverter : Serializable {

    @TypeConverter
    fun stringFromObject(list: GitHubUserListResult?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun getObjectFromString(jsonString: String?): GitHubUserListResult? {
        val listType: Type = object : TypeToken<GitHubUserListResult?>() {}.type
        return Gson().fromJson(jsonString, listType)
    }

    @TypeConverter
    fun stringFromListObject(list: List<GitHubUserListResult?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun getListObjectFromString(jsonString: String?): List<GitHubUserListResult?>? {
        val listType: Type = object : TypeToken<ArrayList<GitHubUserListResult?>?>() {}.type
        return Gson().fromJson(jsonString, listType)
    }
}