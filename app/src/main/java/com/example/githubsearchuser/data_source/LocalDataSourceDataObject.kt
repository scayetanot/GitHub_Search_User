package com.example.githubsearchuser.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.githubsearchuser.data.RoomDataConverter
import com.example.githubsearchuser.data.model.GitHubUserListResult

@Database(entities = [GitHubUserListResult::class], version = 1)
@TypeConverters(RoomDataConverter::class)
abstract class LocalDataSourceDataObject : RoomDatabase() {

    abstract fun localDataObject(): LocalDataSourceRoomDb

    companion object {
        @Volatile
        private var INSTANCE: LocalDataSourceDataObject? = null

        fun getDatabase(context: Context): LocalDataSourceDataObject {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext, LocalDataSourceDataObject::class.java, "user_db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}