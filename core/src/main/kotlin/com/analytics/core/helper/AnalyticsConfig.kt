package com.analytics.core.helper

actual object AnalyticsConfig {

    private var baseUrl: String? = null

    fun setBaseUrl(value: String) {
        baseUrl = value
    }

    actual fun getBaseUrl(): String {
        return baseUrl!!
    }
}