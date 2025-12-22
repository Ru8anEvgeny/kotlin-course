package ru.stimmax.cotlincouse.lessons.lesson27.enums

import ru.stimmax.cotlincouse.lessons.lesson27.enums.Nums.*
import java.lang.IllegalArgumentException

object NumObject {
    const val ONE = "ONE"
    const val TWO = "TWO"
    const val THREE = "THREE"
}

// константы - сущности известные уже на момент компиляции кода

enum class Nums { // класс перечисления
    ONE,
    TWO,
    THREE,
    ;

}
// ; - означает что перечисление закончилось


fun num(num: Nums) {
    when(num){
        ONE -> println(1)
        TWO -> println(2)
        THREE -> println(3)
    }
}

// Конструкторы. ENUM как объект создать невозможно.
enum class DayOfWeek(val dayNumber: Int, val isWeekend: Boolean) {
    MONDAY(1, false),
    TUESDAY(2, false),
    WEDNESDAY(3, false),
    THURSDAY(4, false),
    FRIDAY(5, false),
    SATURDAY(6, true),
    SUNDAY(7, true);

    fun printDay() {
        if (isWeekend) println("$name is a weekend")
        else println("$name is a weekday")
    }

    // Когда пишем свой енам можем использовать компаньен обжект
    companion object {
        fun getDay(dayNumber: Int): DayOfWeek {
            return entries.firstOrNull{it.dayNumber == dayNumber}
                ?: throw IllegalArgumentException("Нет дня недели с номером $dayNumber")
        }
    }
}

// Особенность енамов - неизменяемость. Мы не можем в ран тайме его изменить.


enum class CoffeeType(val cost: Double, val coffeeBase: String, val recSugar: Int, val hasMilk: Boolean = false) {
    ESPRESSO(2.50,"Espresso",0),
    LATTE(3.00,"Latte", 2, true),
    CAPPUCCINO(2.75, "Cappuccino", 1, true),
    AMERICANO(2.25, "Americano", 0);

    fun description() = "The $coffeeBase ${if (hasMilk) "with" else "without"} milk cost \$$cost and is best with $recSugar spoons of sugar"
}

fun main() {
    NumObject.ONE
    NumObject.TWO
    NumObject.THREE

    DayOfWeek.SATURDAY.isWeekend
    DayOfWeek.MONDAY.printDay()
    // можем у енамов получить список все перечислений через entries
    DayOfWeek.entries.size
    val result = DayOfWeek.getDay(3)
    println(result) // WEDNESDAY



}