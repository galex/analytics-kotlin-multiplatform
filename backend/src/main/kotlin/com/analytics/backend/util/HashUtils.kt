@file:Suppress("EXPERIMENTAL_API_USAGE")

package com.analytics.backend.util

import io.ktor.util.hex
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec


private val hashKey = hex("a819b57a326945c1968fd5236511")
private val hmacKey = SecretKeySpec(hashKey, "HmacSHA1")

fun String.hash(): String {
    val hmac = Mac.getInstance("HmacSHA1")
    hmac.init(hmacKey)
    return hex(hmac.doFinal(toByteArray(Charsets.UTF_8)))
}