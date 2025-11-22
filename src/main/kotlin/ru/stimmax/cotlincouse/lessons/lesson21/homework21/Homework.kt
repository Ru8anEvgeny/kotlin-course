package ru.stimmax.cotlincouse.lessons.lesson21.homework21
//Задача 1
//Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и
// вывести соответствующее сообщение:
//Для строки: "Это строка: [значение]".
//Для любого числа: "Это число: [значение]".
//Для списка: "Это список, количество элементов: [количество]".
//Для словаря: "Это словарь, количество пар: [количество]".
//Для остальных типов: "Неизвестный тип данных".
//Используйте оператор is для проверки типов.
fun analyzeDataType(arg: Any): String {
    return when(arg) {
        is String -> "Это строка: $arg"
        is Int -> "Это число: $arg"
        is List<*> -> "Это список, количество элементов: ${arg.size}"
        is Map<*,*> -> "Это словарь, количество пар: ${arg.size}"
        else -> "Неизвестный тип данных"
    }
}


//Задача 2
//Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка,
// если аргумент можно безопасно привести к типу List. В случае неудачного приведения функция должна
// возвращать -1. Используйте as? для безопасного приведения типа.
fun safeCastToList(arg: Any): Int {
    return (arg as? List<*>)?.size ?: -1
}

//Задача 3
//Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки,
// если аргумент можно привести к типу String. В случае, если аргумент равен null или не является строкой,
// функция должна возвращать 0.
fun getStringLengthOrZero(arg: Any?): Int {
    return (arg as? String)?.length ?: 0
}
//Создайте функцию-расширение класса Any toSquare. Функция гарантированно вызывается у числа
// (в виде числа или строки, например 4 или 4.2 или “4.2”) и должна вернуть квадрат этого числа.
// Если придёт число, его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать в число
// через функцию toDouble() и возвести в квадрат.

//fun Any.toSquare(): Int {
//    return when(this) {
//        is Int -> this * this
//        is Double -> this.toInt() * this.toInt()
//        is String -> (this.toDouble() * this.toDouble()).toInt()
//        else -> 0
//    }
//}
fun Any.toSquare(): Double {
    val number = (this as? Number)?.toDouble() ?: (this as String).toDouble()
    return number * number
}

//Задача 5
//Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех
// целочисленных (Int) и вещественных (Double) значений в списке. Все остальные типы должны быть проигнорированы.
fun sumIntOrDoubleValues(arg: List<Any>): Double {
    return arg.sumOf { (it as? Int)?.toDouble() ?: (it as? Double) ?: 0.0}
}

fun sumIntOrDoubleValues1(arg: List<Any>): Double {
   return arg.sumOf { value ->
        when(value) {
            is Int -> value.toDouble()
            is Double -> value
            else -> 0.0
        }
    }
}

//Задача 6
//Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к
// типу List<*>. Если приведение успешно, функция должна напечатать все строки из списка, если элемент
// не является строкой то вывести предупреждение об этом. Если приведение неудачно, должно быть выведено
// сообщение об ошибке, не прерывая выполнение программы.

fun tryCastToListAndPrint(arg: Any) {
    val result = (arg as? List<*>)?.map { it as? String ?: "Не является строкой" } ?: "Преобразование неудачно"
    println(result)

}

fun tryCastToListAndPrint1(arg: Any) {
    val result = arg as? List<*> ?: run {
        println("Приведение не удалось")
        return
    }

    for (it in result) {
        if (it is String) {
            println(it)
        } else {
            println("$it не является строкой")
        }
    }

}



fun main() {
    println(analyzeDataType(mapOf(1 to "1", 2 to "2")))
}