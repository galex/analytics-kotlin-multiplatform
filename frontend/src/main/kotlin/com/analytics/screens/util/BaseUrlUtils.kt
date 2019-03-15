package com.analytics.screens.util

import kotlin.browser.window

fun getBaseUrl(): String {
    val protocol = window.location.protocol
    val hostname = window.location.hostname
    val port = window.location.port
    var url = "$protocol//$hostname"
    if (port != "80") url += ":$port"
    return url
}