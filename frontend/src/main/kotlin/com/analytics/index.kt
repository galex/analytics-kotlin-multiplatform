@file:Suppress("UnsafeCastFromDynamic")

package com.analytics

import react.dom.render
import kotlin.browser.document

@JsModule("react-hot-loader")
private external val hotModule: dynamic
private val hot = hotModule.hot
private val module = js("module")

fun main() {

    val hotWrapper = hot(module)
    render(document.getElementById("root")) {
        hotWrapper(app())
    }
}
