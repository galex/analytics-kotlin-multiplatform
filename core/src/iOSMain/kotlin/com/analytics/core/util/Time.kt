package com.analytics.core.util

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970

actual fun getCurrentTimeMillis(): Long {
    // [[NSDate date] timeIntervalSince1970];
    return NSDate().timeIntervalSince1970().toLong()
}