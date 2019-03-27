package com.analytics.core.view

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class MyViewComponent: RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        +"Some awesome view here1"
    }
}