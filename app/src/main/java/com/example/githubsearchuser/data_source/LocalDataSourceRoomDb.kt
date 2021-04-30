package com.example.githubsearchuser.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubsearchuser.data.model.GitHubUserListResult

@Dao
interface LocalDataSourceRoomDb {

    //As we are only pulling one restaurant, there is no need to use id
    //In a global system, id will need to be passed and use to pull the proper
    //restaurant from the Db
    //  @Query("SELECT * FROM Locations WHERE id = :id")
    @Query("SELECT * FROM GitHubUserList")
    suspend fun getUserList(name: String?): List<GitHubUserListResult>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserList(userList: GitHubUserListResult?)

    @Query("DELETE FROM GitHubUserList")
    suspend fun deleteAll()
}