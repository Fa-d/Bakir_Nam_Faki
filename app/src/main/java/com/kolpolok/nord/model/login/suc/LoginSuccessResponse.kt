package com.kolpolok.nord.model.login.suc


import com.google.gson.annotations.SerializedName

data class LoginSuccessResponse(
    @SerializedName("banner_data")
    var bannerData: BannerData = BannerData(),
    @SerializedName("contact_email")
    var contactEmail: String = "",
    @SerializedName("dynamic_menu_data")
    var dynamicMenuData: String = "",
    @SerializedName("expire_in_days")
    var expireInDays: Int = 0,
    @SerializedName("expired_at")
    var expiredAt: String = "",
    @SerializedName("free_minutes")
    var freeMinutes: String = "",
    @SerializedName("has_inapp_purchase")
    var hasInappPurchase: Boolean = false,
    @SerializedName("ip_bundle")
    var ipBundle: List<IpBundle> = listOf(),
    @SerializedName("is_email")
    var isEmail: Int = 0,
    @SerializedName("is_online")
    var isOnline: Int = 0,
    @SerializedName("is_verified")
    var isVerified: Int = 0,
    @SerializedName("message")
    var message: String = "",
    @SerializedName("alert_message")
    var alertMessage: String = "",
    @SerializedName("response_code")
    var responseCode: Int = 0,
    @SerializedName("server_ip")
    var serverIp: String = "",
    @SerializedName("server_ip_du")
    var serverIpDu: String = "",
    @SerializedName("show_banner")
    var showBanner: Int = 0,
    @SerializedName("show_full_screen")
    var showFullScreen: Int = 0,
    @SerializedName("user_status")
    var userStatus: Int = 0,
    @SerializedName("user_type")
    var userType: Int = 0,
    @SerializedName("validity_date")
    var validityDate: String = ""
)