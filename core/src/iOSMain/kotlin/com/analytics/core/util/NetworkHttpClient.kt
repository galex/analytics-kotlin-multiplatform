package com.analytics.core.util

import com.analytics.core.model.Event
import com.analytics.core.network.model.ActionResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

actual val networkHttpClient: HttpClient
    get() = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json(encodeDefaults = false)).apply {
                setMapper(Event::class, Event.serializer())
                setMapper(ActionResponse::class, ActionResponse.serializer())
            }
        }
    }