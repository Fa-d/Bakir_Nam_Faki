package com.kolpolok.nord.model.login


import com.google.gson.annotations.SerializedName

data class FeaturesImgBlock(
    @SerializedName("href")
    var href: String = "",
    @SerializedName("href_com")
    var hrefCom: String = "",
    @SerializedName("img_url")
    var imgUrl: String = "",
    @SerializedName("img_url_com")
    var imgUrlCom: String = ""
)