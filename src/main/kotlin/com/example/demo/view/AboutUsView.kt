package com.example.demo.view

import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import tornadofx.*

class AboutUsView : View("") {
    override val root = vbox {
        style {
            prefWidth = 200.px
            prefHeight = 400.px
            backgroundColor += Color.ORANGE
        }
        vgrow = Priority.ALWAYS
        label ("About us"){  }
    }
}
