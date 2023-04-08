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
fun playingWithScopeFunctions() {
    println("Please enter a date in the format <yyyy-mm-dd>:")
    supportNullableString(readlnOrNull()).takeUnless {
        it.isNullOrEmpty() || it.isBlank()
    }?.let {
        LocalDate.parse(it)
    }.also {
        if (it == null) {
            println("You entered an invalid date")
            exitProcess(1)
        }
    }?.also {
        println("You entered: $it")
    }?.run {
        calculateDifference()
    }
}

fun supportNullableString(line: String?) = line

private fun LocalDate.calculateDifference() = with(Period.between(this, LocalDate.now())) {
    when {
        years > 18 -> println("You are an adult: $years years")
        years > 0 -> println("The difference: $years years")
        months > 0 -> println("The difference: $months months")
        days > 0 -> println("The difference: $days days")
        else -> println("The difference: 0")
    }
}

fun main() {
    App(Reader(), Writer(), Clock()).execute()
}
