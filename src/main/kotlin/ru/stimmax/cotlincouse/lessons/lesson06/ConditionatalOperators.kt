package ru.stimmax.cotlincouse.lessons.lesson06

fun main() {
    val number: Int = 10
    if (number > 5) { // если условия в скобках тру то мы должны выполнить условия которые в скобках
        println("Число больше 5")
    }


    if (number % 2 == 0) {
        println("Число четное")
    } else { // если операция в скобках равна false выполнится то что в esle - ИНАЧЕ
        println("Число нечетное")
    }

    if (number < 0) {
        println("Число отрицательное")
    } else if (number == 0) {
        println("Число ранвно 0")
    } else {
        println("Число положительное")
    }

    // Тип данных для обозначения диапазона
    val intRange = 1..10 // объявили последовательность
    val intRangeUntil = 1 until 10 // диапазон в котором последний элемент не включается
    val downTo = 10 downTo 1// диапазон в обратную сторону
    val charRange = 'd'..'r' // диапазон из чаров. Диапазон может быть так же из других типов данных

    //операторы вхождения или невхождения числа элемента в диапазона
    val inRange = 2 in intRange // проверили что 2 входит в диапазон переменной  intRange,  вернет тру
    val notInRange = 1 !in intRange // проверили что 1 НЕвходит в диапазон intRange, ,  вернет тру

    // when - когда
    val score = 90
    when { // первый вариант когда используем без аргумента.
        score in 90..100 -> println("Отлично")
        score in 80..89 -> println("Хорощо")
        score in 70..79 -> println("Удовлетворительно")
        else -> println("Надо подучить")
    }
    // если работаем с 1 объектом, то можно записать так
    when (score) {
        2 -> println("2")
        in 90..100 -> println("отлично")
        in 80..89 -> println("хорошо")
        in 70..79 -> println("удовл")
        else -> println("надо подучить")
    }

    // использование условного оператора как выражение
    val a = 6
    val b = 7
    val max = if (a > b) a else b // будет b

    // Действия они же функции они же методы

    val result = when (score) { // поместили объект в значение result
        in 90..100 -> "отлично"
        in 80..89 -> "хорошо"
        in 70..79 -> "удовл"
        else -> "надо подучить"

    }

//    example1(199)
//    example2(20,true)

}

//
//fun example1(arg: Int) {
//    if (arg in 0 until 6) {
//        println("Ночь")
//    } else if (arg in 6..11) {
//        println("Утро")
//    } else if (arg in 12..17) {
//        println("День")
//    } else if (arg in 18..23) {
//        println("Вечер")
//    } else {
//        println("Время введено некорректно")
//    }
//
//}

//fun example2(arg1: Int, arg2: Boolean ) {
//    if (arg1 > 30 || arg1 < -20) {
//        println("Возьми машину")
//    } else if (arg1 >= 15 && !arg2) {
//        println("Иди пешком")
//    } else {
//        println("Едь на общественном транспорте")
//    }
//}

