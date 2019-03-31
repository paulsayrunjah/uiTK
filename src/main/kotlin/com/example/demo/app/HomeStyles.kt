package com.example.demo.app

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class HomeStyles : Stylesheet(){
    companion object {
        val home by cssclass()
        val leftPane by cssclass()
        val rightPane by cssclass()
    }

    init {

        home{
            prefWidth = Config.APP_WIDTH
            backgroundColor += c("#cccccc")
            padding = box(10.px)


        }

        leftPane{
            backgroundColor += Color.WHITE
            prefWidth = 600.px
        }

        rightPane{
            padding = box(10.px)
            backgroundColor += Color.WHITE
            prefWidth = 200.px

            label{
                textFill = c("#cccccc")
            }
        }


    }
}