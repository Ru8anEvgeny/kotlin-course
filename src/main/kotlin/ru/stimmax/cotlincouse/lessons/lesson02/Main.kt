package ru.stimmax.cotlincouse.lessons.lesson02

fun main() {
    var eventMealPlan: String = ""
    get() = when (field) {
        "KFC" -> "14.00 - 15.00"
        "DoDo" -> "13.00 - 14.00"
        else -> "Не определено"
    }



}



