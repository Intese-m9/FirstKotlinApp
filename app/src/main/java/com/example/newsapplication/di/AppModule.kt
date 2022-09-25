package com.example.newsapplication.di

import com.example.newsapplication.data.api.NewsService
import com.example.newsapplication.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 object AppModule {

    @Provides
    fun baseUrl() = BASE_URL

    @Provides
    fun loggin() = HttpLoggingInterceptor()//необходим для вывода response в консоль
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun okHttpClient() = OkHttpClient.Builder()
        .addInterceptor(loggin())
        .build()
    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): NewsService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient())
            .build()
            .create()
}