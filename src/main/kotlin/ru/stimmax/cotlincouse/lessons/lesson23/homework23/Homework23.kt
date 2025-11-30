package ru.stimmax.cotlincouse.lessons.lesson23.homework23

//1. Создай функцию, которая принимает список чисел и возвращает среднее арифметическое всех чётных чисел этого списка.
// С помощью require проверь, что список не пустой.
fun average(list: List<Int>): Int {
 require(list.isNotEmpty()) {
     "Список не должен быть пуст"
 }
    return list.filter { it % 2 == 0 }.average().toInt()
}
//1.1 Создай аналогичную анонимную функцию.
val average = fun (list: List<Int>): Int {
    require(list.isNotEmpty()) {
        "Список не должен быть пуст"
    }
    return list.filter { it % 2 == 0 }.average().toInt()
}

//1.2 Создай аналогичное лямбда выражение с указанием типа.
val average1: (List<Int>) -> Int = { list ->
    require(list.isNotEmpty()) {
        "Список не должен быть пуст"
    }
    list.filter { it % 2 == 0 }.average().toInt()
}

//1.3 Создай лямбда выражение без указания типа.
val average2 = {list: List<Int> ->
    require(list.isNotEmpty()) {
        "Список не должен быть пуст"
    }
    list.filter { it % 2 == 0 }.average()
}


//2. Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа. Сделай проверку,
// что входящее число больше нуля. Подсказка: для парсинга символа в число можно использовать функцию digitToInt()
fun sumInt(num: Int): Int {
require(num > 0) {
    "Число должно быть больше 0"
}
   return num.toString().map { it.digitToInt() }.sum()
}
//2. 1 Создай аналогичную анонимную функцию.
val sumInt = fun (num: Int): Int {
    require(num > 0) {
        "Число должно быть больше 0"
    }
    return num.toString().map { it.digitToInt() }.sum()
}

// 2.2 Создай аналогичное лямбда выражение с указанием типа.
val sumInt1: (Int) -> Int = {num ->
    require(num > 0) {"Число должно быть больше 0"}
    num.toString().sumOf { it.digitToInt() }
}

// 2.3 Создай лямбда выражение без указания типа.
val sumInt2 = {num: Int ->
    require(num > 0) {"Число должно быть больше 0"}
    num.toString().sumOf { it.digitToInt() }
}

// 3 Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел
// (встречающихся в списке более одного раза).
fun List<Int>.setInt(): Set<Int> {
    val set = mutableSetOf<Int>()
    val list = filter { !set.add(it) }
    return list.toSet()

}

// 3.1 Создай аналогичную анонимную функцию.
val setInt = fun List<Int>.(): Set<Int> {
    val set = mutableSetOf<Int>()
    val list = filter { !set.add(it) }
    return list.toSet()
}
// 3.2 Создай аналогичное лямбда выражение с указанием типа.
val setInt1: List<Int>.() -> Set<Int> = {
    val set = mutableSetOf<Int>()
    val list = filter { !set.add(it) }
    list.toSet()
}


fun main() {

   //1.4 Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).
   // average2(listOf())
    println(average2(listOf(1, 2, 4, 6, 8, 9, 11)))

    // 2.4 Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
    val int1 = 160
    val int2 = -100
    val int3 = 0
    println(sumInt2(int1))
// 3. Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
   val list1 = listOf(0, 1, 2, 3, 4, 5, -100, 0, 3, -5)
    println(list1.setInt1())


}