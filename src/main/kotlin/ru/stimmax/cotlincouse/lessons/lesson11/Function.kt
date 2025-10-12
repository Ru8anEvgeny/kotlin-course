package ru.stimmax.cotlincouse.lessons.lesson11

fun main() {
    sayHello() // () - оператор инвоук. Означающий выполнить действия
    greetUser("Evgeny")
    println(sum(10,15))
    printSum(111, 333)
    multiPlay(1,1)

}
// Способ записывания функции
//fun имяФункции(параметры): ТипВозвращаемогоЗначения {
//    Tело функции
//    return значения
//}

// модификаторы доступа private - значит функция доступна только в этом классе
// если функция ничего не возвращает, то не используем ретерн

fun sayHello() {
    println("Hello World")
}

// функция с аргументом. name - аргумент
fun greetUser(name: String) {
    println("Hello, $name")
}

fun sum(a: Int, b: Int) : Int {
    return a + b
}

fun printSum(a: Int, b: Int) {
    println("Sum of $a and $b is ${a + b}")
}

// Однострочные функции. Использовать когда функция выполняет како-то 1 действие.
fun multiPlay(a: Int, b: Int): Int = a + b

// модификаторы видимости пример. Нужны для ограничения видимости функции
private fun calculateDiscount(price: Double): Double {
    return price * 0.1
}

fun finalPrice(price: Double): Double {
    val discount = calculateDiscount(price)
    return price - discount
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b // говорим если, а больше верни а, иначе верни б
}

// return можно использовать как прерывание работы функции
fun findValue(numbers: List<Int>, target: Int) {
    for (number in numbers) {
        if (number == target) {
            println("Value found: $number")
            return
        }
    }
    println("Value not found")
}

// сигнатуры функций
// функция не ринимает аргументы и ничего не возвр
fun a1() {

}

// функция, которая не принимает аргументы и возврщ строку
fun a2(): String {
    return "Hello"
}

// принимает 1 строковый арг и не возврщ значений
fun a3(a3: String){

}

// принимает 2 арг типа дабл и возвращает знач типа дабл
fun a4(a1: Double, a2: Double): Double {
    return a1 + a2
}

// принимает нулл строку и возвр булево знаение
fun a5(a1: String?): Boolean {
    return true
}

// Функции с кодом. Принимает 2 числа и возвр сумму этих чисел
fun a6(a1: Int, b1: Int): Int{
    return a1 + b1
}

// Принимает 2 числа и возврщ большее из них
fun a7(a1: Int, a2: Int): Int {
    return if (a1 > a2) {
        a1
    } else a2
}
// принимает список чисел и выводит на печать только полож, если встречается отрицательное прекратить выполнение
fun a8(a: List<Int>){
    for (i in a) {
        if (i > 0) {
            println(i)
        }
        if (i < 0) {
           return
        }
    }
}

// принимает список строк и искомую стр, должна перебрать список и заменить 1е вхождение искомой строки на
fun a9(a: MutableList<String>, b: String){
    for (i in a.indices) {
        if (a[i].contains(b)) {
            a[i] = a[i].replace(b, b.uppercase())
            return
        }
    }
}








