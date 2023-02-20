package com.kolpolok.nord.data.repository

import com.kolpolok.nord.data.service.ApiService
import com.kolpolok.nord.model.login.LoginRequest
import com.kolpolok.nord.model.login.suc.LoginSuccessResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class APIRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getLoginDetails(loginRequest: LoginRequest): LoginSuccessResponse {
        return withContext(Dispatchers.Default) {
            apiService.getLoginDetails(loginRequest)
        }
    }


}