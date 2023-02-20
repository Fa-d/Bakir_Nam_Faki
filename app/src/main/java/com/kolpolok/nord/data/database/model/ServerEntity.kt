package com.kolpolok.nord.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ServerEntity(
/*    var id: Int = 0,*/
    var bundleName: String = "",
    var ipName: String = "",
    var ip: String = "",
    @PrimaryKey var ipId: Int = 0,
    var note: String = "",
    var typeTxt: String = "",
    var priority: String = "",
    var config: String = "",
    var type: Int = 0,
    var network: Int = 0,
    var isConnected: Boolean = false,
    var isAdblocker: Int = 0,
    var isFastServer: Int = 0,
    var isFree: Int = 0,
    var isGaming: Int = 0,
    var isFavorite: Boolean = false,
    var site: String = "",
    var isOnlineStream: Int = 0,
    var connectType: Int = 0,
    var sslIP: String = "",
    var countryCode: String = "",
    var countryName: String = "",
    var platform: String = "",
    var vpnServerId: Int = 0
)