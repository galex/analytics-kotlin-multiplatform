package com.analytics.core.model

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class Event(
    @Optional val id: Int? = 0,
    val name: String,
    val screen: Screen,
    val timestamp: Long,
    val platform: Platform,
    @Optional val createdAt: Long = 0
)