package com.analytics.core.util

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import java.util.*

actual val networkHttpClient: HttpClient
    get() = HttpClient(OkHttp)