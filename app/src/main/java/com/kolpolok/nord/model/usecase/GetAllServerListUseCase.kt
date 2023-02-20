package com.kolpolok.nord.model.usecase

import com.kolpolok.nord.data.database.model.ServerEntity
import com.kolpolok.nord.data.repository.databaserepo.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllServerListUseCase @Inject constructor(private val repository: DatabaseRepository) {
    operator fun invoke(): Flow<List<ServerEntity>> = flow {
        emit(repository.getAllServerList())
    }
}