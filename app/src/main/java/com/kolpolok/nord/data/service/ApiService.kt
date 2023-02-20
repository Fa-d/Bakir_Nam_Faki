package com.kolpolok.nord.data.service

import com.kolpolok.nord.data.client.ApiClient
import com.kolpolok.nord.model.login.LoginRequest
import com.kolpolok.nord.model.login.suc.LoginSuccessResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(private val apiClient: ApiClient) {
    suspend fun getLoginDetails(
        loginRequest: LoginRequest
    ): LoginSuccessResponse {
        return withContext(Dispatchers.IO) {
            val response = apiClient.login(
                loginRequest.hitUrl,
                loginRequest.appId,
                loginRequest.brand,
                loginRequest.bundle2,
                loginRequest.countryCode,
                loginRequest.deviceType,
                loginRequest.isRooted,
                loginRequest.model,
                loginRequest.osName,
                loginRequest.osPlatform,
                loginRequest.osVersion,
                loginRequest.pass,
                loginRequest.rId,
                loginRequest.rLevel,
                loginRequest.udid,
                loginRequest.username,
                loginRequest.vpnAppVersion,
                loginRequest.playerId
            )
            response.body()!!
        }
    }

/*    baseUrl: String,
    appId: String,
    brand: String,
    bundle2: String,
    countryCode: String,
    deviceType: String,
    isRooted: String,
    model: String,
    osName: String,
    osPlatform: String,
    osVersion: String,
    pass: String,
    rId: String,
    rLevel: String,
    udid: String,
    username: String,
    vpnAppVersion: String,
    playerId: String*/
}