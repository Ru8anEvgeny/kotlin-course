package ru.stimmax.cotlincouse.lessons.lesson02


//18.График питания участников (зависит от поставщика питания, определяемого за неделю до начала)
var eventMealPlan: String = ""
    get() = when (field){
            "KFC" -> "14.00 -15.00"
            "DoDo" -> "15.00 - 16.00"
            else -> "Не определено"
        }



fun main() {
    eventMealPlan = "KFC"
    println(eventMealPlan)


}



