package com.codely.demo

import java.time.LocalDate

const val WELCOME_MESSAGE = "Welcome to kotlin skeleton!!!"

class Codelyber {
    fun greet() = WELCOME_MESSAGE
}

fun main() {
    println("Please enter a date in the format <yyyy-mm-dd>:")
    val enteredDate: String? = null
//    val date = LocalDate.parse(enteredDate ?: "1982-11-21")
//    val date = LocalDate.parse(enteredDate!!)

    enteredDate?.let {
        val date = LocalDate.parse(it)
        println("The date you entered is: $date and the day of the week is: ${date.dayOfWeek}")
    }
}
