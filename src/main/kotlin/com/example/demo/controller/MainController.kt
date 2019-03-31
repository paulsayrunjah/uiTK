package com.example.demo.controller

import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import tornadofx.*

class MainController : Controller(){
    fun goToView(rootContainer: VBox, view: View){
        rootContainer.clear()
        rootContainer += view
    }
}