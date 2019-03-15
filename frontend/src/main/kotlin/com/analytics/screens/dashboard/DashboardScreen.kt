package com.analytics.screens.dashboard

import com.analytics.core.helper.EventsHelper
import com.analytics.core.model.Screen
import com.analytics.screens.MainFrameContainer
import com.ccfraser.muirwik.components.mTypography
import react.*

class DashboardScreen : RComponent<RProps, RState>() {

    override fun componentDidMount() {
        println("componentDidMount")
        EventsHelper.enterScreen(Screen.DASHBOARD)
    }

    override fun componentWillUnmount() {
        println("componentWillUnmount")
        EventsHelper.exitScreen(Screen.DASHBOARD)
    }

    override fun componentDidCatch(error: Throwable, info: RErrorInfo) {
        println("componentDidCatch")
        EventsHelper.exitScreen(Screen.DASHBOARD)
    }

    override fun RBuilder.render() {

        mTypography("Dashboard Screen here!")
    }
}

fun RBuilder.dashboard() = child(DashboardScreen::class) {}