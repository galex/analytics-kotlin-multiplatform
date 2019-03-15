package com.analytics.core.network.api

import com.analytics.core.model.Event
import com.analytics.core.model.EventList
import com.analytics.core.network.model.ActionResponse
import com.analytics.core.util.API
import com.analytics.core.util.ApplicationDispatcher
import com.analytics.core.util.EVENTS
import com.analytics.core.util.networkHttpClient
import io.ktor.client.features.BadResponseStatusException
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.content.TextContent
import io.ktor.http.ContentType
import io.ktor.http.Url
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.stringify

object EventsAPI {

    fun getEvents(baseUrl: String, block: (EventList) -> Unit) {

        val address = Url("$baseUrl/$API/$EVENTS").toString()
        println("address = $address")
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                try {
                    val result: EventList = networkHttpClient.get {
                        url(address)
                    }
                    block(result)
                } catch (e: Exception) {
                    println(e)
                }
            }
        }
    }

    @UseExperimental(ImplicitReflectionSerializer::class)
    fun postEvent(baseUrl: String, event: Event, block: (ActionResponse) -> Unit) {
        val address = Url("$baseUrl/$API/$EVENTS").toString()
        println("address = $address")
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                try {
                    val result: ActionResponse = networkHttpClient.post {
                        url(address)
                        // An operation is not implemented: Obtaining serializer from KClass is not available on native due to the lack of reflection
                        body = TextContent(Json.stringify(Event.serializer(), event), contentType = ContentType.Application.Json)
                    }

                    block(result)

                } catch (e: Exception) {
                    println(e)
                    println(e.cause)
                }
            }
        }
    }
}