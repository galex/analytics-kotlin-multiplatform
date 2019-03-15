package com.analytics.core.util

import com.analytics.core.model.Platform
import java.lang.IllegalStateException

actual fun getSource(): Platform = throw IllegalStateException("Do not use EventsHelper from the backend, doesn't make sense!")