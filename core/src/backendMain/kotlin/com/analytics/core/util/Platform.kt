package com.analytics.core.util

import com.analytics.core.model.Platform
import java.lang.IllegalStateException

actual fun getPlatform(): Platform = throw IllegalStateException("Do not use EventsHelper from the backend, doesn't make sense!")