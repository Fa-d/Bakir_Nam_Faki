package com.kolpolok.nord.model.login


import com.google.gson.annotations.SerializedName

data class IappAndroidPackage(
    @SerializedName("feature_title")
    var featureTitle: String = "",
    @SerializedName("highlighted_text")
    var highlightedText: String = "",
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("price")
    var price: String = "",
    @SerializedName("sku_ids")
    var skuIds: String = "",
    @SerializedName("sub_title")
    var subTitle: String = ""
)