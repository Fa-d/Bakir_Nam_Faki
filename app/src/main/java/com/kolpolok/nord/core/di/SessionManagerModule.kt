package com.kolpolok.nord.core.di


import android.content.Context
import android.content.SharedPreferences
import com.kolpolok.nord.data.repository.SessionManager
import com.kolpolok.nord.data.repository.UrlSessionManager
import com.kolpolok.nord.helpers.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SessionManagerModule {
    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideSessionManager(preferences: SharedPreferences) = SessionManager(preferences)

    @Singleton
    @Provides
    fun provideUrlSessionManager(preferences: SharedPreferences) = UrlSessionManager(preferences)
}
