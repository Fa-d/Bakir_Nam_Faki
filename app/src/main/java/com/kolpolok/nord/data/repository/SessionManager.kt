package com.kolpolok.nord.data.repository

import android.content.SharedPreferences
import javax.inject.Inject

class SessionManager @Inject constructor(private val preferences: SharedPreferences) {

    fun getUserName() = preferences.getString("userName", "")
    fun setUserName(value: String) {
        preferences.edit().putString("userName", value).apply()
    }

    fun getUserId() = preferences.getInt("userId", 0)
    fun setUserId(value: Int) {
        preferences.edit().putInt("userId", value).apply()
    }

    fun getAccessToken() = preferences.getString("accessToken", "")
    fun setAccessToken(value: String) {
        preferences.edit().putString("accessToken", value).apply()
    }

    fun getUserEmail() = preferences.getString("userEmail", "")
    fun setUserEmail(value: String) {
        preferences.edit().putString("userEmail", value).apply()
    }


    fun getPassword() = preferences.getString("password", "")
    fun setPassword(value: String) {
        preferences.edit().putString("password", value).apply()
    }


    fun getJoinDate() = preferences.getString("joinDate", "")
    fun setJoinDate(value: String) {
        preferences.edit().putString("joinDate", value).apply()
    }


    fun getIsLoggedIn() = preferences.getBoolean("isLoggedIn", false)
    fun setIsLoggedIn(value: Boolean) {
        preferences.edit().putBoolean("isLoggedIn", value).apply()
    }

}