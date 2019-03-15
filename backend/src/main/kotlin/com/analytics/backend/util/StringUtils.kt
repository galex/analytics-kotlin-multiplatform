package com.analytics.backend.util

fun String.isNumber() = matches("-?\\d+(\\.\\d+)?".toRegex())