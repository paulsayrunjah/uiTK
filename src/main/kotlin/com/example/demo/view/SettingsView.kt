package com.example.demo.view

import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import tornadofx.*

class SettingsView : View("") {
    override val root = vbox {
        style {
            prefWidth = 200.px
            prefHeight = 400.px
            backgroundColor += Color.BLUE
        }
        vgrow = Priority.ALWAYS
        label ("Settings"){  }
    }
}
