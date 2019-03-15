package com.analytics.core.helper

actual object AnalyticsConfig {

    actual fun getBaseUrl(): String {
        throw IllegalAccessException()
    }
}