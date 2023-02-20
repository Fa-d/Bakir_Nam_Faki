package com.kolpolok.nord.model.usecase

import com.kolpolok.nord.data.database.model.ServerEntity
import com.kolpolok.nord.data.repository.databaserepo.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InsertIntoDatabaseUseCase @Inject constructor(private val repository: DatabaseRepository) {
    operator fun invoke(serverEntity: List<ServerEntity>): Flow<Boolean> = flow {
        emit(repository.insertServer(serverEntity))
    }
}