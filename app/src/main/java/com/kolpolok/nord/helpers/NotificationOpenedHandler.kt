package com.kolpolok.nord.helpers

import android.content.Context
import android.content.Intent
import com.kolpolok.nord.ui.login.MainActivity
import com.onesignal.OSNotificationOpenedResult
import com.onesignal.OneSignal.OSNotificationOpenedHandler

class NotificationOpenedHandler(var mContext: Context) : OSNotificationOpenedHandler {
    override fun notificationOpened(osNotificationOpenedResult: OSNotificationOpenedResult) {
        val intent = Intent(mContext, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        mContext.startActivity(intent)
    }
}