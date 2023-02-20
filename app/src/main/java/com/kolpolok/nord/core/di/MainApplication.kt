package com.kolpolok.nord.core.di

import android.app.Application
import com.kolpolok.nord.helpers.NotificationOpenedHandler
import com.kolpolok.nord.helpers.NotificationReceivedHandler
import com.onesignal.OneSignal
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //one signal
        OneSignal.setAppId("46c00520-fe0b-4f35-8f0b-3ad0d70fc5c7")
        OneSignal.initWithContext(this)
        OneSignal.setNotificationWillShowInForegroundHandler(
            NotificationReceivedHandler(
                applicationContext
            )
        )
        OneSignal.setNotificationOpenedHandler(NotificationOpenedHandler(this))
        OneSignal.addPermissionObserver {
            val device = OneSignal.getDeviceState()
            val userId = device!!.userId
            OneSignal.provideUserConsent(true)
        }
        // Get Device Token
        // Get Device Token
        val device = OneSignal.getDeviceState()!!
        val userId = device.userId
        /* val defaults = UserDefaults(applicationContext)
         if (!defaults.getOneSignalID().equalsIgnoreCase(userId)) {
             defaults.setOneSignalID(userId)
             defaults.save()
         }*/
    }
}