package com.kolpolok.nord.data.client

import com.kolpolok.nord.model.login.suc.LoginSuccessResponse
import retrofit2.Response
import retrofit2.http.*


interface ApiClient {
    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST
    suspend fun login(
        @Url url: String,
        @Field("app_id") appId: String,
        @Field("brand") brand: String,
        @Field("bundle2") bundle2: String,
        @Field("countryCode") countryCode: String,
        @Field("device_type") deviceType: String,
        @Field("isRooted") isRooted: String,
        @Field("model") model: String,
        @Field("osName") osName: String,
        @Field("osPlatform") osPlatform: String,
        @Field("osVersion") osVersion: String,
        @Field("pass") pass: String,
        @Field("rId") rId: String,
        @Field("rLevel") rLevel: String,
        @Field("udid") udid: String,
        @Field("username") username: String,
        @Field("vpnAppVersion") vpnAppVersion: String,
        @Field("player_id") playerId: String
    ): Response<LoginSuccessResponse>
}