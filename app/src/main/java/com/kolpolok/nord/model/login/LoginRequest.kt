package com.kolpolok.nord.model.login


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    var hitUrl: String = "",
    @SerializedName("app_id") var appId: String = "",
    @SerializedName("brand") var brand: String = "",
    @SerializedName("bundle2") var bundle2: String = "",
    @SerializedName("countryCode") var countryCode: String = "",
    @SerializedName("device_type") var deviceType: String = "",
    @SerializedName("isRooted") var isRooted: String = "",
    @SerializedName("model") var model: String = "",
    @SerializedName("osName") var osName: String = "",
    @SerializedName("osPlatform") var osPlatform: String = "",
    @SerializedName("osVersion") var osVersion: String = "",
    @SerializedName("pass") var pass: String = "",
    @SerializedName("rId") var rId: String = "",
    @SerializedName("rLevel") var rLevel: String = "",
    @SerializedName("udid") var udid: String = "",
    @SerializedName("username") var username: String = "",
    @SerializedName("vpnAppVersion") var vpnAppVersion: String = "",
    @SerializedName("player_id") var playerId: String = ""
)