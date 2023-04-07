package com.codely.demo

import java.time.LocalDate
import java.time.Period
import kotlin.system.exitProcess

const val WELCOME_MESSAGE = "Welcome to kotlin skeleton!!!"

class Codelyber {
    fun greet() = WELCOME_MESSAGE
}

fun playingWithNulls() {
    println("Please enter a date in the format <yyyy-mm-dd>:")
    val enteredDate: String? = null
//    val date = LocalDate.parse(enteredDate ?: "1982-11-21")
//    val date = LocalDate.parse(enteredDate!!)

    enteredDate?.let {
        val date = LocalDate.parse(it)
        println("The date you entered is: $date and the day of the week is: ${date.dayOfWeek}")
    }
}
fun main() {
    println("Please enter a date in the format <yyyy-mm-dd>:")
    val line = supportNullableString(readLine())
    if (line == null) {
        println("You didn't enter a date")
        exitProcess(1)
    }
    val date = LocalDate.parse(line)
    println("You entered: $date")
    val currentDate = LocalDate.now()
    val difference = Period.between(date, currentDate)
    println("The difference: ${difference.years} years")
}

fun supportNullableString(line: String?) = line