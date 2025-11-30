package ru.stimmax.cotlincouse.lessons.lesson22

import java.io.File

fun main() {
//    val arg: Int? = null - NullPointerException
//    arg!!

//    val arg2 = listOf(1, 2, 3) // ArrayIndexOutOfBoundsException - обратились к индексу которого нет
//    arg2[5]
    try {
        val arg2 = listOf(1, 2, 3, 4)
        println(arg2[10])
    } catch (e: ArrayIndexOutOfBoundsException) {
        throw MyException(e.message)
    }

//    val arg3: Any = 12 // ClassCastException - пытаемся привести не приводимые типы
//    arg3 as String
//
//    val arg: String = "123.ffg"
//    arg.toInt() // NumberFormatException - входящая строка не может быть преобразована в число

    //addMoney(-2) // IllegalArgumentException: Денег должно быть положительное кол-во

    // checkMoney(12.5) // IllegalStateException: Не должно быть даблом

//    val file = File("//https/ss/ss") // Создали объект типа файл куда положили путь к файлу
//    file.readText() // readText - должен считать этот файл. Но т.к его нет получим исключение FileNotFoundException

//    val list = mutableListOf<Int>()
//    while (true) {
//        list.add(Math.PI.toInt()) // будет исключение OutOfMemoryError
//    }


    //fun1() // Получим StackOverflowError



}

// След исключение IllegalArgumentException возникает когда в функцию пришли какие либо неправильные аргументы.
fun addMoney(value: Int) {
    require(value > 0) { // require - требуем что бы value > 0
        "Денег должно быть положительное кол-во" // этот текс добавится в исключение если require не будет соблюден
    }

}

//  IllegalStateException - Исключение которое возникает при неверном состоянии объекта
fun checkMoney(value: Number) {
    check(value !is Double) {
        "Не должно быть даблом"
    }
}

fun fun1() {
    fun1()
}

class MyException(message: String?) : RuntimeException(message)

