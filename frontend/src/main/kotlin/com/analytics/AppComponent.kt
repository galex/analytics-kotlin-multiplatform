package com.analytics

import com.analytics.core.helper.AnalyticsConfig
import com.analytics.screens.mainFrame
import com.analytics.screens.util.getBaseUrl
import com.ccfraser.muirwik.components.Colors
import com.ccfraser.muirwik.components.createMuiThemeFunction
import com.ccfraser.muirwik.components.currentTheme
import com.ccfraser.muirwik.components.mMuiThemeProvider
import com.ccfraser.muirwik.components.styles.ThemeOptions
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class AppComponent : RComponent<RProps, RState>() {

    init {

        AnalyticsConfig.baseUrl = getBaseUrl()
    }

    private var themeColor = "light"

    @Suppress("UnsafeCastFromDynamic")
    override fun RBuilder.render() {

        val themeProps: ThemeOptions = js("({palette: { type: 'placeholder', primary: {main: 'placeholder'}}, typography: {useNextVariants: 'placeholder'}})")
        themeProps.apply {
            palette?.type = themeColor
            palette?.primary.main = Colors.LightBlue.shade500.toString()
            typography?.useNextVariants = true
        }

        currentTheme = createMuiThemeFunction(themeProps)

        mMuiThemeProvider(currentTheme) {
            mainFrame()
        }
    }
}

fun RBuilder.app() = child(AppComponent::class) {}



