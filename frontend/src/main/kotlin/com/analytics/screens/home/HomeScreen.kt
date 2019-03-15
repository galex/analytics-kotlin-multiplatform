package com.analytics.screens.home

import com.analytics.core.helper.EventsHelper
import com.analytics.core.model.Screen
import com.analytics.screens.dashboard.DashboardScreen
import com.ccfraser.muirwik.components.MTypographyVariant
import com.ccfraser.muirwik.components.card.mCard
import com.ccfraser.muirwik.components.card.mCardContent
import com.ccfraser.muirwik.components.mGridContainer
import com.ccfraser.muirwik.components.mTypography
import kotlinx.css.JustifyContent
import kotlinx.css.px
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.css

class HomeScreen : RComponent<RProps, RState>() {

    override fun componentDidMount() {
        println("componentDidMount")
        EventsHelper.enterScreen(Screen.HOME)
    }

    override fun componentWillUnmount() {
        println("componentWillUnmount")
        EventsHelper.exitScreen(Screen.HOME)
    }


    override fun RBuilder.render() {

        mGridContainer {
            css {
                justifyContent = JustifyContent.center
            }

            mCard {
                css {
                    marginTop = 100.px
                    width = 460.px
                }

                mCardContent {

                    mTypography("Analytics Example Project", gutterBottom = true, variant = MTypographyVariant.h5, component = "h4")
                    mTypography("This project illustrates a complete full stack platform for analytics. Have fun! ", component = "p")
                }
            }
        }
    }
}

fun RBuilder.home() = child(HomeScreen::class) {}



