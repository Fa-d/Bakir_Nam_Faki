package com.kolpolok.nord.data.repository.databaserepo

import com.kolpolok.nord.data.database.dao.ServerDao
import com.kolpolok.nord.data.database.model.ServerEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DatabaseRepository @Inject constructor(private val serverDao: ServerDao) {

    suspend fun getAllServerList(): List<ServerEntity> = withContext(Dispatchers.Default) {
        val listCategory = serverDao.getAllServerList()
        if (listCategory.isEmpty()) {
            val categories = serverDao.getAllServerList()
            categories.forEach { _ ->

            }
            serverDao.getAllServerList().map {
                async {
                    it
                }
            }.awaitAll()
        } else {
            serverDao.getAllServerList().map {
                async {
                    it
                }
            }.awaitAll()
        }
    }


    suspend fun insertServer(serverList: List<ServerEntity>): Boolean {
        return withContext(Dispatchers.Default) {
            serverList.forEach {
                serverDao.addServers(it)
            }
            true
        }
    }
}