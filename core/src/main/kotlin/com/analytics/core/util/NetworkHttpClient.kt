package com.analytics.core.util

import com.analytics.core.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import okhttp3.logging.HttpLoggingInterceptor

actual val networkHttpClient: HttpClient
    get() = HttpClient(OkHttp) {
        engine {
            if(BuildConfig.DEBUG)
            addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }

        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

actual fun currentTimeMillis(): Long = System.currentTimeMillis()