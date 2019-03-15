package com.analytics.core.helper

import kotlin.native.concurrent.AtomicReference
import kotlin.native.concurrent.freeze

actual object AnalyticsConfig {

    private val baseUrl =  AtomicReference<String?>(null)

    fun setBaseUrl(urlString: String) {
        baseUrl.value = urlString.freeze()
    }

    actual fun getBaseUrl(): String {
        return baseUrl.value!!
    }
}