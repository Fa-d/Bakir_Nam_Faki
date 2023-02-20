package com.kolpolok.nord.helpers

import com.kolpolok.nord.data.database.model.ServerEntity
import com.kolpolok.nord.model.login.suc.IpBundle

fun IpBundle.toServerEntity(): ServerEntity {

    return ServerEntity(
        bundleName = bundleName,
        ipName = ipName,
        ip = ip,
        ipId = ipId,
        note = note,
        typeTxt = typeTxt,
        priority = priority.toString(),
        config = config,
        type = type,
        network = network,
        isConnected = false,
        isAdblocker = isAdblocker,
        isFastServer = isFastServer,
        isFree = isFree,
        isGaming = isGaming,
        isFavorite = false,
        site = site,
        isOnlineStream = isOnlineStream,
        connectType = connectionType,
        sslIP = sslIp,
        countryCode = countryCode,
        countryName = countryName,
        platform = platform,
        vpnServerId = vpnServerId
    )

}