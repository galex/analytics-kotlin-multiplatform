package com.analytics.screens.event

import com.analytics.core.model.Event
import com.analytics.core.network.api.EventsAPI
import com.analytics.screens.home.HomeScreen
import com.analytics.screens.util.getBaseUrl
import com.ccfraser.muirwik.components.*
import com.ccfraser.muirwik.components.table.*
import kotlinx.css.Overflow
import kotlinx.css.pct
import kotlinx.css.px
import react.*
import styled.css


class EventsScreen : RComponent<RProps, EventsScreen.EventsState>() {

    interface EventsState: RState {
        var events: List<Event>?
    }

    override fun componentDidMount() {
        refresh()
    }

    private fun refresh() {
        EventsAPI.getEvents(getBaseUrl()) {
            setState {
                this.events = it.events
            }
        }
    }

    override fun RBuilder.render() {

        mButton("Refresh", variant = MButtonVariant.contained, color = MColor.secondary, onClick = { refresh() })

        mPaper {
            css {
                width = 100.pct
                marginTop = 6.spacingUnits
                overflowX = Overflow.auto
            }
            mTable {
                css { minWidth = 700.px }
                mTableHead {
                    mTableRow {
                        mTableCell { +"Name" }
                        mTableCell(align = MTableCellAlign.right) { +"Screen" }
                        mTableCell(align = MTableCellAlign.right) { +"Platform" }
                        mTableCell(align = MTableCellAlign.right) { +"Timestamp" }
                    }
                }
                mTableBody {
                    state.events?.forEach {event ->
                        mTableRow(key = event.id) {
                            mTableCell { + event.name }
                            mTableCell(align = MTableCellAlign.right) { +event.screen.name }
                            mTableCell(align = MTableCellAlign.right) { +event.platform.name }
                            mTableCell(align = MTableCellAlign.right) { +event.timestamp.toString() }
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.events() = child(EventsScreen::class) {}