package com.analytics.screens

import com.analytics.screens.dashboard.dashboard
import com.analytics.screens.event.events
import com.analytics.screens.home.home
import com.analytics.screens.util.RScreen
import com.ccfraser.muirwik.components.*
import com.ccfraser.muirwik.components.list.mList
import com.ccfraser.muirwik.components.list.mListItem
import com.ccfraser.muirwik.components.styles.Breakpoint
import com.ccfraser.muirwik.components.styles.down
import com.ccfraser.muirwik.components.styles.up
import kotlinext.js.jsObject
import kotlinx.css.*
import react.*
import styled.StyleSheet
import styled.css
import styled.styledDiv

interface MainFrameState : RState {
    var currentRScreen: RScreen
}

class MainFrameContainer : RComponent<RProps, MainFrameState>() {

    private object ComponentStyles : StyleSheet("ComponentStyles", isStatic = true) {
        val toolbar by css {
            toolbarJsCssToPartialCss( currentTheme.mixins.toolbar)
        }
    }

    private fun RBuilder.spacer() {
        // This puts in a spacer to get below the AppBar.
        styledDiv {
            css(ComponentStyles.toolbar)
        }
        mDivider {  }
    }

    override fun MainFrameState.init() {
        currentRScreen = RScreen.HOME
    }

    override fun RBuilder.render() {
        mCssBaseline()

        val drawerWidth = 180.px

        styledDiv {
            css {
                flexGrow = 1.0
                width = 100.pct
                zIndex = 1
                overflow = Overflow.hidden
                position = Position.relative
                display = Display.flex
            }

            styledDiv {
                // App Frame
                css { overflow = Overflow.hidden; position = Position.relative; display = Display.flex; width = 100.pct }

                mAppBar(position = MAppBarPosition.absolute) {
                    css {
                        zIndex = currentTheme.zIndex.drawer + 1
                    }
                    mToolbar {
                        mTypography("Analytics Example Frontend", variant = MTypographyVariant.h6, color = MTypographyColor.inherit) {
                            css { flexGrow = 1.0 }
                        }
                    }
                }

                val p: MPaperProps = jsObject { }
                p.asDynamic().style = kotlinext.js.js { position = "relative"; width = drawerWidth.value; display = "block"; height = "100%"; minHeight = "100vh" }
                mDrawer(true, MDrawerAnchor.left, MDrawerVariant.permanent, paperProps = p) {
                    css {
                        zIndex = 1
                    }

                    spacer()

                    mList {
                        css {
                            backgroundColor = Color(currentTheme.palette.background.paper)
                        }

                        mListItem("Home", iconName = "home", divider = false, onClick = { setState { currentRScreen = RScreen.HOME } })
                        mListItem("Dashboard", iconName = "dashboard", divider = true, onClick = { setState { currentRScreen = RScreen.DASHBOARD } })
                        mListItem("Events", iconName = "view_list", divider = true, onClick = { setState { currentRScreen = RScreen.EVENTS } })
                    }
                }

                // Main content area
                styledDiv {
                    css {
                        height = 100.pct
                        flexGrow = 1.0; minWidth = 0.px
                        backgroundColor = Color(currentTheme.palette.background.default)
                    }
                    spacer()
                    styledDiv {
                        css {
                            media(currentTheme.breakpoints.down(Breakpoint.sm)) {
                                height = 100.vh - 57.px
                            }
                            media(currentTheme.breakpoints.up(Breakpoint.sm)) {
                                height = 100.vh - 65.px
                            }

                            overflowY = Overflow.auto
                            padding(4.spacingUnits)
                            backgroundColor = Color(currentTheme.palette.background.default)
                        }


                        when(state.currentRScreen) {
                            RScreen.HOME -> home()
                            RScreen.DASHBOARD -> dashboard()
                            RScreen.EVENTS -> events()
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.mainFrame() = child(MainFrameContainer::class) {}