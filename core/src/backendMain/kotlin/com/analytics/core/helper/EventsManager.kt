package com.analytics.core.helper

import com.analytics.core.model.Event

actual object EventsManager {

    actual fun manage(event: Event) {
        throw IllegalAccessException("backend will not send events")
    }
}