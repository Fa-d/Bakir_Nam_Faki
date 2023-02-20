package com.kolpolok.nord.core.di

import android.content.Context
import androidx.room.Room
import com.kolpolok.nord.core.database.ServerDatabase
import com.kolpolok.nord.data.database.dao.ServerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun serverListDao(serverDatabase: ServerDatabase): ServerDao = serverDatabase.getAllServerList()

    @Provides
    @Singleton
    fun provideTodoDatabase(@ApplicationContext appContext: Context): ServerDatabase =
        Room.databaseBuilder(appContext, ServerDatabase::class.java, "SERVERS").build()
}