package com.kolpolok.nord.model.login


import com.google.gson.annotations.SerializedName

data class InAppPaymentPageData(
    @SerializedName("card_payment_packages")
    var cardPaymentPackages: List<CardPaymentPackage> = listOf(),
    @SerializedName("features_img_block")
    var featuresImgBlock: FeaturesImgBlock = FeaturesImgBlock(),
    @SerializedName("iapp_amazon_packages")
    var iappAmazonPackages: List<IappAmazonPackage> = listOf(),
    @SerializedName("iapp_android_packages")
    var iappAndroidPackages: List<IappAndroidPackage> = listOf(),
    @SerializedName("iapp_huawei_packages")
    var iappHuaweiPackages: List<IappHuaweiPackage> = listOf(),
    @SerializedName("iapp_ios_packages")
    var iappIosPackages: List<IappIosPackage> = listOf(),
    @SerializedName("premium_features_list")
    var premiumFeaturesList: List<String> = listOf()
)