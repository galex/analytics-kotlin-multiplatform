package com.analytics.core.model

import kotlinx.serialization.Serializable

@Serializable
class EventList(val events: List<Event>)