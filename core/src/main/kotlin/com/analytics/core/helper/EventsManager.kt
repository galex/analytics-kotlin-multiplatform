package com.analytics.core.helper

import android.app.Application
import com.analytics.core.model.Event
import com.analytics.core.network.api.EventsAPI
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual object EventsManager {

    lateinit var application: Application

    actual fun manage(event: Event) {

        // send it over the network
        EventsAPI.postEvent(AnalyticsConfig.getBaseUrl(), event) {
            println("sent the event, success = ${it.success}")
        }

        // database driver
        val driver: SqlDriver = AndroidSqliteDriver(AnalyticsDatabase.Schema, application, "test.db")
    }
}