package com.analytics.backend.database.tables

import org.jetbrains.exposed.sql.Table

object Events : Table() {
    val id = integer("id").primaryKey().autoIncrement()
    val name = varchar("name", 255)
    val screen = varchar("screen", 255)
    val timestamp = long("timestamp")
    val platform = varchar("platform", 255)
    val createdAt = long("created_at")
}