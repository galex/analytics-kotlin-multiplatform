package com.analytics.analyticsapp

import android.app.Application
import com.analytics.core.helper.AnalyticsConfig

/**
 * @author Alexander Gherschon
 */
class TheApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AnalyticsConfig.setBaseUrl("http://192.168.54.71:8000")
    }
}