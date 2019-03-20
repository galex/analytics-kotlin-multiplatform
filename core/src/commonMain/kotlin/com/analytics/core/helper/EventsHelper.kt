package com.analytics.core.helper

import com.analytics.core.model.Event
import com.analytics.core.model.Screen
import com.analytics.core.model.ScreenAction
import com.analytics.core.util.getCurrentTimeMillis
import com.analytics.core.util.getPlatform

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
        logEvent(Event(name = ScreenAction.ENTER.name,
            screen = screen,
            timestamp = getCurrentTimeMillis(),
            platform = getPlatform())
        )
    }

    fun exitScreen(screen: Screen) {
        logEvent(Event(name = ScreenAction.EXIT.name,
            screen = screen,
            timestamp = getCurrentTimeMillis(),
            platform = getPlatform()))
    }
}