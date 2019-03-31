package com.example.demo.view

import com.example.demo.app.HomeStyles
import com.example.demo.model.Person
import com.example.demo.model.PersonMo
import com.example.demo.model.PersonModel
import com.example.demo.util.formatDateTable
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.control.DatePicker
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import org.controlsfx.control.Notifications
import tornadofx.*
import java.time.LocalDate


class HomeView : View("") {

    var personModel = PersonModel(PersonMo())
    var nameTextField: TextField by singleAssign()
    var birthdayTextField: DatePicker by singleAssign()

    var personList = mutableListOf(
            PersonMo(1,"Samantha Stuart",LocalDate.of(1981,12,4)),
            PersonMo(2,"Tom Marks",LocalDate.of(2001,1,23)),
            PersonMo(3,"Stuart Gills",LocalDate.of(1989,5,23)),
            PersonMo(3,"Nicole Williams", LocalDate.of(1998,8,11))
    ).observable()

    /*init {
        with(nameTextField){
            bind(personModel.name)
        }
    }*/
    override val root = vbox {
        vgrow = Priority.ALWAYS
        hbox {
            spacing = 10.0
            addClass(HomeStyles.home)
            vgrow = Priority.ALWAYS
            vbox {
                hgrow = Priority.ALWAYS
                addClass(HomeStyles.leftPane)
                tableview(personList) {
                    vgrow = Priority.ALWAYS
                    readonlyColumn("ID",PersonMo::id)
                    readonlyColumn("Name", PersonMo::name).remainingWidth()
                    readonlyColumn("Birthday", PersonMo::birthday)
                    readonlyColumn("Age",PersonMo::age)
                    columnResizePolicy = SmartResize.POLICY

                    onUserSelect { personMo ->
                        nameTextField.text = personMo.name
                        personModel.birthday = SimpleObjectProperty(personMo.birthday)
                        birthdayTextField.editor.text = formatDateTable(personMo.birthday.toString())

                    }
                }
            }
            vbox {
                hgrow = Priority.ALWAYS
                addClass(HomeStyles.rightPane)
                label("Add Person") {

                }

                form {
                    fieldset {
                        labelPosition = Orientation.VERTICAL
                        field ("ID"){
                            textfield (personModel.id).required()
                        }
                        field ("NAME"){
                            nameTextField = textfield (personModel.name)
                        }

                        field("BIRTHDAY") {
                            birthdayTextField = datepicker(personModel.birthday)
                        }

                        button ("Save"){
                            setOnAction {
                                    if (personModel.commit()){
                                        personList.add(PersonMo(personModel.id.value as Int, personModel.name.value, personModel.birthday.value))
                                    Notifications.create()
                                            .title("Customer saved!")
                                            .text("Okay")
                                            .owner(this)
                                            .position(Pos.TOP_LEFT)
                                            .showInformation()
                                }
                            }

                            disableProperty().bind(personModel.name.isBlank())
                        }
                    }
                }
            }
        }
    }
}
