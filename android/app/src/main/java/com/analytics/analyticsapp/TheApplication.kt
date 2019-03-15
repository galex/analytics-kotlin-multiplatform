package com.analytics.analyticsapp

import android.app.Application
import com.analytics.core.helper.AnalyticsConfig

/**
 * @author Alexander Gherschon
 */
class TheApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AnalyticsConfig.setBaseUrl("http://10.0.0.3:8000")
    }
}