package com.analytics.core.helper

import com.analytics.core.model.Event

expect object EventsManager {

    fun manage(event: Event)
}