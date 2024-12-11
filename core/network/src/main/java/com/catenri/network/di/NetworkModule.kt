package com.catenri.network.di

import android.os.Build
import com.catenri.hogwartshall.core.network.BuildConfig
import com.catenri.network.service.CharactersClient
import com.catenri.network.service.CharactersService
import com.catenri.network.util.InstantConverter
import com.catenri.network.util.InstantParser
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.datetime.Instant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.math.log

private const val BASE_URL = "https://hp-api.onrender.com/api/"

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            okHttpClient.addInterceptor(loggingInterceptor)
        }

        return okHttpClient.build()
    }

    @Provides
    fun provideInstantConverter(instantParser: InstantParser) = InstantConverter(instantParser)

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        instantConverter: InstantConverter
    ): Retrofit {
        val gson = GsonBuilder()
            .registerTypeAdapter(Instant::class.java, instantConverter)
            .create()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): CharactersService {
        return retrofit.create(CharactersService::class.java)
    }

    @Provides
    @Singleton
    fun provideClient(service: CharactersService): CharactersClient {
        return CharactersClient(service)
    }
}