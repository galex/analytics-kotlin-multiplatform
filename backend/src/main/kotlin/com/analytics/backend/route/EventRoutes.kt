package com.analytics.backend.route

import com.analytics.backend.database.service.EventService
import com.analytics.core.model.Event
import com.analytics.core.model.EventList
import com.analytics.core.network.model.ActionResponse
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.events() {

    route("/events") {

        get("/") {
            val events = EventService.findAll()
            if (events != null) {
                call.respond(HttpStatusCode.OK, EventList(events))
            } else {
                call.respond(HttpStatusCode.NoContent)
            }
        }

        post("/") {

            val event = call.receive<Event>()
            val eventId = EventService.create(event)
            call.respond(HttpStatusCode.OK, ActionResponse(eventId != null))
        }
    }
}