package com.kolpolok.nord.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kolpolok.nord.data.database.dao.ServerDao
import com.kolpolok.nord.data.database.model.ServerEntity

@Database(entities = [ServerEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ServerDatabase : RoomDatabase() {
    abstract fun getAllServerList(): ServerDao
}
