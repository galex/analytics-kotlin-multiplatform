package com.analytics.backend.database.service

import com.analytics.backend.database.DatabaseFactory.dbQuery
import com.analytics.backend.database.tables.Events
import com.analytics.core.model.Event
import com.analytics.core.model.Platform
import com.analytics.core.model.Screen
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

object EventService {

    suspend fun findAll(): List<Event>? = dbQuery {

        Events.selectAll().map {
            toEvent(it)
        }
    }

    suspend fun create(event: Event): Int? = dbQuery {

        return@dbQuery Events.insert {
            it[name] = event.name
            it[screen] = event.screen.name
            it[platform] = event.platform.name
            it[timestamp] = event.timestamp
            it[createdAt] = System.currentTimeMillis()
        } get Events.id
    }

    private fun toEvent(row: ResultRow) = Event(
        id = row[Events.id],
        name = row[Events.name],
        screen = Screen.valueOf(row[Events.screen]),
        timestamp = row[Events.timestamp],
        platform = Platform.valueOf(row[Events.platform]),
        createdAt = row[Events.createdAt]
    )
}