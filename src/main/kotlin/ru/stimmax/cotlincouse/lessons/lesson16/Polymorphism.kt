package ru.stimmax.cotlincouse.lessons.lesson16

import java.awt.Color

// Полиморфизм - принцип позволяющий одному и тому же методу работать по разному в зависимости от
// контекста и достигается 2 мя способами перегрузкой  или переопределением

// переопределением когда производный класс во время наследования будет менять реализацию метода.

// Перегрузка - способ что-то делать с разными наборами данных.

object Colors { // Объект список цвета текста
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[30m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}
object Background {//Объект список цвета фона
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[40m"
    const val RED = "\u001B[41m"
    const val GREEN = "\u001B[42m"
    const val YELLOW = "\u001B[43m"
    const val BLUE = "\u001B[44m"
    const val PURPLE = "\u001B[45m"
    const val CYAN = "\u001B[46m"
    const val WHITE = "\u001B[47m"
}
fun printColored(text: String, color: String, backgroundColor: String = "") { // Метод который текст печатает в цвете.
    println("$color$backgroundColor$text${Colors.RESET}")
}
abstract class MusicalInstrument { // Абстрактный класс музыкальных инструментов

    abstract fun playNote(note: String) // метод который проигрывает строку в которую можно передать какую-то ноту.

    protected fun shortNote(note: String, color: String) {// защищенный метод. Короткая нота. Protected - значит метод будет доступен внутри класса наследника.
        // Но не доступен снаружи, например в функции мейн
        printColored("Play short note $note", color)
    }
    protected fun longNote(note: String, color: String) {// защищенный метод. Длинная нота
        printColored("Play long note $note", color)
    }
}

class Violin(): MusicalInstrument() {
    override fun playNote(note: String) { // Что бы понять что метод переопределен к fun добавляется метод override
        longNote(note, Colors.YELLOW ) // передали в функцию ноту, которую принимаем в методе, и цвет взяли из объекта Colors

    }

}

class Drum : MusicalInstrument() {
    override fun playNote(note: String) {
        shortNote(note, Colors.RED)

    }
}


// Перегрузка методов

class Printer{ // Создали класс Принтер
    fun print(text: String) { // Функция принимает текст и печатает его
        println(text)
    }

    fun print(text: String, color: String) { // Принимает текст и цвет
        printColored(text, color) // Вызывает функцию которая печатает текст в цвете
    }

    fun print(text: String, color: String, backgroundColor: String) { // принимает текст, цвет и фон
        printColored(text, color, backgroundColor) // вызываем функцию которая печатает текст в цвете с определенным фоном
    }

    fun print(text: Array<String>) { // принимает массив из текстов
        text.forEach { println(it) } // каждую строку печатает с новой строки

    }

    fun print(text: Map<String, String>) { // принимает словарь из текста и цвета
        text.forEach{ printColored(it.key, it.value) } // проходим по словарю и вызываем функцию печати текста в цвете
        // для каждого ключа и значения


    }


}



fun main() {
    val violin = Violin()
    violin.playNote("C")

    val drum = Drum()
    drum.playNote("C")

    val analysable: List<MusicalInstrument> = listOf(violin, drum) // создали лист из музыкальных инструментов

    val notes = "ABCDE" // создали список нот
    notes.forEach { note -> // говорим пройтись по списку нот, каждая нота == note
        analysable.forEach {it.playNote(note.toString())} // для каждой ноты пройдись по инструментам и вызови команду playNote
    }

    val printer = Printer()
    printer.print("Print")
    printer.print("Print", Colors.BLUE)
    printer.print(arrayOf("print", "print, print"))
    printer.print("Print", Colors.BLACK, Background.RED)
    printer.print(mapOf("Print" to "22"))


}




