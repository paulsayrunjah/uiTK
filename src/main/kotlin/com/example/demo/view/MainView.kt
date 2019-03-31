package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.MainController
import javafx.animation.TranslateTransition
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.util.Duration
import tornadofx.*


class MainView : View("MianView") {
    val drawer = BorderPane()
    val mainContainer = VBox()
    val mainController: MainController by inject()
    val aboutUs : AboutUsView by inject()
    val homeView : HomeView by inject()
    val settings : SettingsView by inject()
    var isNavOpen = false


    init {

        mainContainer += homeView
        with(drawer){
            addClass(Styles.drawer)
            prepareSlideMenuAnimation(this)
            top = vbox {
                    addClass(Styles.header)
                background = Background(BackgroundImage(Image("index.jpeg", 250.0,200.0, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT))
            }

            center = vbox {
                style{
                    backgroundColor += c("yellow")
                }
                spacing = 5.0
                button ("Home"){
                    addClass(Styles.drawerButtons)
                    action {

                            prepareSlideMenuAnimation(drawer)
                        mainController.goToView(mainContainer, homeView)
                    }
                }
                button ("Settings"){
                    addClass(Styles.drawerButtons)
                    action {

                            prepareSlideMenuAnimation(drawer)
                        mainController.goToView(mainContainer, settings)
                    }
                }
                button ("About us"){
                    addClass(Styles.drawerButtons)
                    action {

                            prepareSlideMenuAnimation(drawer)
                        mainController.goToView(mainContainer, aboutUs)
                    }
                }
            }

            bottom = hbox {
                alignment = Pos.CENTER
                label ("SayrunJah INC"){
                    textFill = Color.WHITE
                }
            }
        }

        with(mainContainer){
            hgrow = Priority.ALWAYS
            addClass(Styles.otherContent)
        }



    }
    override val root = vbox {
        addClass(Styles.mainView)
        borderpane{
            addClass(Styles.topMainView)
            center = hbox {
                alignment = Pos.CENTER
                spacing = 10.0

                button("Home"){
                    addClass(Styles.topButtons)
                    action {
                        if(isNavOpen)
                            prepareSlideMenuAnimation(drawer)
                        mainController.goToView(mainContainer, homeView)
                    }

                }
                button("Settings"){
                    addClass(Styles.topButtons)
                    action {
                        if(isNavOpen)
                            prepareSlideMenuAnimation(drawer)
                        mainController.goToView(mainContainer, settings)
                    }

                }
                button("About us"){
                    addClass(Styles.topButtons)
                    action {
                        if(isNavOpen)
                            prepareSlideMenuAnimation(drawer)
                        mainController.goToView(mainContainer, aboutUs)
                    }


                }

                right = button(graphic = Styles.closeIcon()){
                    addClass(Styles.closeButton)
                    action {
                        prepareSlideMenuAnimation(drawer)
                    }
                }

            }
        }
        hbox {
            vgrow = Priority.ALWAYS
            stackpane {
                hgrow = Priority.ALWAYS
                addClass(Styles.mainContainer)
                alignment = Pos.TOP_LEFT


                this += mainContainer
                this += drawer
            }
        }

    }

    fun prepareSlideMenuAnimation(drawer: BorderPane) {
        val openNav = TranslateTransition(Duration(350.0), drawer)
        openNav.toX = 0.0
        val closeNav = TranslateTransition(Duration(350.0), drawer)

        if (drawer.translateX !== 0.0) {
            openNav.play()
            isNavOpen = true
        } else {
            closeNav.toX = -250.0
            closeNav.play()
            isNavOpen = false
        }

    }


}