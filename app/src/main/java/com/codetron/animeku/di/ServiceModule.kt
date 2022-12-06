package com.codetron.animeku.di

import com.codetron.animeku.BuildConfig
import com.codetron.animeku.service.Config
import com.codetron.animeku.service.JikanApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceModule {

    fun getModules() = listOf(serviceModule)

    private val serviceModule = module {
        single {
            HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
        }

        single {
            OkHttpClient.Builder()
                .addInterceptor(get<HttpLoggingInterceptor>())
                .build()
        }

        single {
            Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single<JikanApiService> { get<Retrofit>().create(JikanApiService::class.java) }
    }

}