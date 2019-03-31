package com.example.demo.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate
import java.time.Period

class Person(val id: Int, val name: String, val birthday: LocalDate) {
    val age: Int get() = Period.between(birthday, LocalDate.now()).years
}

class PersonMo{

    var age: Int = 0
    var id : Int = 0
    var name: String = ""
    var birthday: LocalDate? = null
    constructor()
    constructor(id: Int,  name: String, birthday: LocalDate){
        this.id = id
        this.name = name
        this.birthday = birthday
        age = Period.between(birthday, LocalDate.now()).years
    }
    val idProperty = SimpleIntegerProperty(this.id)
    val nameProperty = SimpleStringProperty(this.name)
    val birthdayProperty = SimpleObjectProperty<LocalDate>(this.birthday)
}

class PersonModel(var person: PersonMo) : ViewModel(){
    var id = bind { person.idProperty }
    var name = bind { person.nameProperty }
    var birthday = bind {person.birthdayProperty}
}