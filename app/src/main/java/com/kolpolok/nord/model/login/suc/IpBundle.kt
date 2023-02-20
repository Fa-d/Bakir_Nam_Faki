package com.kolpolok.nord.model.login.suc


import com.google.gson.annotations.SerializedName

data class IpBundle(
    @SerializedName("bundleName")
    var bundleName: String = "",
    @SerializedName("config")
    var config: String = "",
    @SerializedName("connection_type")
    var connectionType: Int = 0,
    @SerializedName("countryCode")
    var countryCode: String = "",
    @SerializedName("countryName")
    var countryName: String = "",
    @SerializedName("ip")
    var ip: String = "",
    @SerializedName("ip_id")
    var ipId: Int = 0,
    @SerializedName("ipName")
    var ipName: String = "",
    @SerializedName("is_adblocker")
    var isAdblocker: Int = 0,
    @SerializedName("is_fast_server")
    var isFastServer: Int = 0,
    @SerializedName("is_free")
    var isFree: Int = 0,
    @SerializedName("is_gaming")
    var isGaming: Int = 0,
    @SerializedName("is_online_stream")
    var isOnlineStream: Int = 0,
    @SerializedName("network")
    var network: Int = 0,
    @SerializedName("note")
    var note: String = "",
    @SerializedName("platform")
    var platform: String = "",
    @SerializedName("priority")
    var priority: Int = 0,
    @SerializedName("site")
    var site: String = "",
    @SerializedName("ssl_ip")
    var sslIp: String = "",
    @SerializedName("type")
    var type: Int = 0,
    @SerializedName("typeTxt")
    var typeTxt: String = "",
    @SerializedName("vpn_server_id")
    var vpnServerId: Int = 0
)