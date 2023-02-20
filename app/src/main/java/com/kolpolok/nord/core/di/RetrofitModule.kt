package com.kolpolok.nord.core.di

import android.app.Application
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kolpolok.nord.BuildConfig
import com.kolpolok.nord.data.client.ApiClient
import com.kolpolok.nord.helpers.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun getGson(): Gson {
        return GsonBuilder().setLenient().setPrettyPrinting().create()
    }

    @Provides
    @Singleton
    fun createCache(application: Application): Cache {
        val cacheSize = 5L * 1024L * 1024L //5MB
        return Cache(File(application.cacheDir, "${application.packageName}.cache"), cacheSize)
    }

    @Provides
    @Singleton
    fun createOkHttpClient(cache: Cache?, sharedPrefrence: SharedPreferences): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                val logging = httpLoggingInterceptor.apply {
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                }
                addInterceptor(logging)
            }
            addInterceptor(Interceptor { chain ->
                val original = chain.request()
                val token = sharedPrefrence.getString("accessToken", "")
                val requestBuilder = original.newBuilder()
                //     .header("Content-Type", "application/x-www-form-urlencoded")
                val request = requestBuilder.build()
                chain.proceed(request)
            })

            cache(cache)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(1, TimeUnit.MINUTES)
            connectTimeout(30, TimeUnit.SECONDS)
        }.build()
    }

    @Provides
    @Singleton
    fun retrofitInstance(baseUrl: String, gson: Gson, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            //.addCallAdapterFactory(NetworkResponseAdapterFactory()).baseUrl(baseUrl)
            .client(httpClient).build()
    }

    @Provides
    @Named("apiBase")
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        @Named("apiBase") BASE_URL: String, gson: Gson, httpClient: OkHttpClient
    ): ApiClient = retrofitInstance(
        baseUrl = BASE_URL, gson, httpClient
    ).create(ApiClient::class.java)

    /*@Singleton
    @Provides
    fun providesApiClient(retrofit: Retrofit): ApiClient = retrofit.create(ApiClient::class.java)*/

}