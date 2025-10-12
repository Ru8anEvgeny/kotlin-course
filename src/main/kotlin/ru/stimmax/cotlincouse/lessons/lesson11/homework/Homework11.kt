package ru.stimmax.cotlincouse.lessons.lesson11.homework

//Задачи на сигнатуру метода
//Напишите сигнатуру метода в которую входит модификатор доступа, название функции, список аргументов
// с типами и возвращаемое значение. В теле метода можешь сделать возврат объекта нужного типа если это
// требуется для устранения ошибок.

//1. Не принимает аргументов и не возвращает значения.
fun a1(){}
//2. Принимает два целых числа и возвращает их сумму.
fun a2(arg1: Int, arg2: Int): Int {
    return arg2 + arg1
}
// 3. Принимает строку и ничего не возвращает.
fun a3(arg1: String){

}
// 4. Принимает список целых чисел и возвращает среднее значение типа Double.
fun a4(arg: List<Int>): Double {
    val result = arg.sum() / arg.size
    return result.toDouble()
}
// 5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и
// доступна только в текущем файле.
private fun a5(arg: String?): Int? {
    return arg?.length
}

// 6. Не принимает аргументов и возвращает nullable вещественное число.
fun a6(): Double? {
    return null
}

// 7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun a7(arg: List<Int?>){

}
// 8. Принимает целое число и возвращает nullable строку.
fun a8(arg: Int): String? {
    return null
}

// 9. Не принимает аргументов и возвращает список nullable строк.
fun a9(): List<String>? {
    return null
}

// 10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun a10(arg1: String?, arg2: Int?): Boolean? {
    return true
}

// Задачи на написание кода
//Напишите валидную сигнатуру метода а так же рабочий код для задач.

//11. Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(arg: Int): Int {
    return arg * 2
}

//12. Создайте функцию isEven, которая принимает целое число и возвращает true,
// если число чётное, и false в противном случае.

fun isEven(arg: Int): Boolean {
    return arg % 2 == 0
}

// 13. Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
// Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(n: Int){
    if (n < 1) {
        return
    }
    for (i in 1..n) {
        println(i)

    }
}

// 14. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое
// отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(arg: List<Int>): Int? {
    for (i in arg) {
        if (i < 0) {
            return i
        }
    }
     return null
}

// 15. Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и
// выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью
// return без возврата значения.

fun processList(arg: List<String?>){
    for (i in arg.indices) {
        if (arg[i] == null){
            return
        }
        println(arg[i])

    }
}

fun main() {
    println(multiplyByTwo(10))
    println(isEven(27))
    printNumbersUntil(-17)
    println (findFirstNegative(listOf(1,2,3,4,-5)))
    processList(listOf("asd", "asdadaa", null))
}