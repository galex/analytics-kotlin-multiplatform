package com.analytics.core.helper

import com.analytics.core.model.Event
import com.analytics.core.network.api.EventsAPI

actual object EventsManager {

    actual fun manage(event: Event) {

        // send it over the network
        EventsAPI.postEvent(AnalyticsConfig.getBaseUrl(), event) {
            println("sent the event, success = ${it.success}")
        }
    }
}