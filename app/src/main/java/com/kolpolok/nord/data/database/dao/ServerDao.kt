package com.kolpolok.nord.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kolpolok.nord.data.database.model.ServerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ServerDao {
    @Query("SELECT * FROM ServerEntity")
    fun getAllServerList(): List<ServerEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addServers(item: ServerEntity)
}