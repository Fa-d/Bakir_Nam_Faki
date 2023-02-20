package com.kolpolok.nord.model.login


import com.google.gson.annotations.SerializedName

data class LoginErrorResponse(
    @SerializedName("alert_message") var alertMessage: String = "",
    @SerializedName("in_app_payment_page_data") var inAppPaymentPageData: InAppPaymentPageData = InAppPaymentPageData(),
    @SerializedName("is_required_email_verified") var isRequiredEmailVerified: Boolean = false,
    @SerializedName("message") var message: String = "",
    @SerializedName("premium_purchase_alert") var premiumPurchaseAlert: Boolean = false,
    @SerializedName("response_code") var responseCode: Int = 0,
    @SerializedName("should_show_support") var shouldShowSupport: Boolean = false,
    @SerializedName("status_code") var statusCode: Int = 0
)