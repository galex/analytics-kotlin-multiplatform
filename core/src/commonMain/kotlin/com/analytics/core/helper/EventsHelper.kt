package com.analytics.core.helper

import com.analytics.core.model.Event
import com.analytics.core.model.Screen
import com.analytics.core.model.ScreenAction
import com.analytics.core.network.api.EventsAPI
import com.analytics.core.util.currentTimeMillis
import com.analytics.core.util.getSource

/**
 * Main Event Helper functions
 */
@Suppress("unused")
object EventsHelper {

    private fun logEvent(event: Event) {
        println("logging the event = $event")
        // every platform will implement its own logic
        EventsManager.manage(event)
    }

    fun enterScreen(screen: Screen) {
        logEvent(Event(name = ScreenAction.ENTER.name, screen = screen, timestamp = currentTimeMillis(), platform = getSource()))
    }

    fun exitScreen(screen: Screen) {
        logEvent(Event(name = ScreenAction.EXIT.name, screen = screen, timestamp = currentTimeMillis(), platform = getSource()))
    }
}