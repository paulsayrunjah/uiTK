package com.example.demo.util

fun formatDateTable(date: String) : String{
    var x = "1994-02-23"
    var dat = date.split("-")
    return dat[1]+"/"+dat[2]+"/"+dat[0]
}