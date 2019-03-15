package com.analytics

import com.analytics.backend.database.DatabaseFactory
import com.analytics.backend.route.*
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.application.log
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.http.content.files
import io.ktor.http.content.static
import io.ktor.http.content.staticRootFolder
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.velocity.Velocity
import io.ktor.velocity.VelocityContent
import java.io.File

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(@Suppress("UNUSED_PARAMETER") testing: Boolean = false) {

    DatabaseFactory.init()

    install(StatusPages)

    install(ContentNegotiation) {
        //register(ContentType.Application.Json, JsonSerializableConverter())
        gson {
            //setExclusionStrategies(ExcludeGsonFieldsStrategy())
            //serializeNulls()
        }
    }

    install(Velocity) {
        setProperty("resource.loader", "class");
        setProperty(
            "class.resource.loader.class",
            "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"
        )
        init()
    }

    routing {

        trace { application.log.trace(it.buildText()) }

        static("static") {
            staticRootFolder = File("static")
            files("css")
            files("js")
        }

        get("/") {
            val data = mapOf("name" to "Alex")
            call.respond(VelocityContent("templates/index.vl", data, "e"))
        }

        route("/api") {
            events()
        }
    }
}

