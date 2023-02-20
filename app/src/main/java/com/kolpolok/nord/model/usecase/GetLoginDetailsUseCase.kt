package com.kolpolok.nord.model.usecase

import com.kolpolok.nord.data.repository.APIRepository
import com.kolpolok.nord.model.login.LoginRequest
import com.kolpolok.nord.model.login.suc.LoginSuccessResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetLoginDetailsUseCase @Inject constructor(private val apiRepository: APIRepository) {
    operator fun invoke(loginRequest: LoginRequest): Flow<LoginSuccessResponse> = flow {
        emit(apiRepository.getLoginDetails(loginRequest))
    }
}