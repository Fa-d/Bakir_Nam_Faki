package com.kolpolok.nord.model.login.suc


import com.google.gson.annotations.SerializedName

data class BannerData(
    @SerializedName("app_home_img")
    var appHomeImg: String = "",
    @SerializedName("display_type")
    var displayType: String = "",
    @SerializedName("end_after")
    var endAfter: String = "",
    @SerializedName("onclick_url")
    var onclickUrl: String = "",
    @SerializedName("start_after")
    var startAfter: String = ""
)