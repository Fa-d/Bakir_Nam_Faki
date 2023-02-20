package com.kolpolok.nord.core.di

import com.google.firebase.firestore.FirebaseFirestore
import com.kolpolok.nord.data.repository.FirebaseManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    //.collection("beta").document("apiBaseUrlList")*/
    @Provides
    @Singleton
    fun provideFireStoreInstance(): FirebaseManager {
        return FirebaseManager(FirebaseFirestore.getInstance())
    }

}