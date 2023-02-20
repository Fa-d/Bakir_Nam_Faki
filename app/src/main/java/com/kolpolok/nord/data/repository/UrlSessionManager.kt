package com.kolpolok.nord.data.repository

import android.content.SharedPreferences
import javax.inject.Inject

class UrlSessionManager @Inject constructor(private val preferences: SharedPreferences) {
    fun getAppUrl() = preferences.getString("appUrl", "")
    fun setAppUrl(value: String) = preferences.edit().putString("appUrl", value).apply()
    fun getPaymentUrl() = preferences.getString("paymentUrl", "")
    fun setPaymentUrl(value: String) = preferences.edit().putString("paymentUrl", value).apply()

}