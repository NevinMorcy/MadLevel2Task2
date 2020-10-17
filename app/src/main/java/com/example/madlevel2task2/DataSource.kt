package com.example.madlevel2task2

data class DataSource (
    var Data: String,
    val boolean: Boolean
){

    companion object {

        val items = arrayOf(
            DataSource("A 'val' and 'var' are the same.", false),
            DataSource("Mobile Application Development grants 12 ETCS", true),
            DataSource("A Unit in Kotlin corresponds to a void in Java", true),
            DataSource("In Kotlin 'when' replaces the 'switch' operator in Java.", false),
        )

    }

}