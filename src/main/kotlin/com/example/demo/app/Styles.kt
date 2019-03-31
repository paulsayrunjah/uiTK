package com.example.demo.app

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*
import java.net.URI

class Styles : Stylesheet() {
    companion object {
        val mainView by cssclass()
        val topMainView by cssclass()
        val topButtons by cssclass()
        val closeButton by cssclass()
        val closeIcon by cssclass()



        fun closeIcon() = FontAwesomeIconView(FontAwesomeIcon.BARS).apply {
            glyphSize = 22
            addClass(closeIcon)
        }

        val mainContainer by cssclass()
        val drawer by cssclass()
        val drawerButtons by cssclass()
        val drawerWidth = 250.px
        val header by cssclass()
        val otherContent by cssclass()
    }

    init {
       mainView{
           backgroundColor += c("#cccccc")
           prefHeight = 600.px
           prefWidth = 800.px

           topMainView{
               backgroundColor += Color.WHITE
               prefHeight = 50.px
               spacing = 10.px
               padding = box(10.px)


               button and topButtons{

                   backgroundColor += c("#FFFFF1")
                   prefHeight = 45.px
                   textFill = Color.RED
                   and(hover){
                       backgroundColor += c("#cccccc")
                   }
               }

               closeButton{
                   backgroundColor += Color.WHITE
               }
           }

           closeIcon {
               fill = c("#cc9a9a")
               and(hover) {
                   fill = c("#af5b5e")
               }
           }

       }

        mainContainer{
            drawer {
                maxWidth = drawerWidth
                backgroundColor += Color.RED

                header {
                    //backgroundColor += Color.BLUE
                    prefWidth = drawerWidth
                    prefHeight = 200.px
                    //backgroundImage  += URI( "index.jpeg")
                }
            }
            otherContent{
                prefWidth = 800.px
                //backgroundColor += Color.GREEN
            }
        }

        drawerButtons{
            prefWidth = drawerWidth
            prefHeight = 48.px
            backgroundColor += Color.ALICEBLUE
        }
    }


}