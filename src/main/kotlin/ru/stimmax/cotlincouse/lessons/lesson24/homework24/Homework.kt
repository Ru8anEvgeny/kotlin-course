package ru.stimmax.cotlincouse.lessons.lesson24.homework24

//Создай функцию, которая:
//принимает булево значение
//принимает функцию, принимающую строку и ничего не возвращающую
//возвращает целое число
fun arg1(a: Boolean, fun1: (String) -> Unit) {}

//Создай функцию расширения целого числа, которая:
//принимает функцию расширения целого числа, принимающую строку и возвращающую список строк
//возвращает список строк
fun Int.arg2(fun2: Int.(String) -> List<String>): List<String> {
    return fun2("")
}

//Создай функцию с двумя дженериками расширяющую первый дженерик, которая:
//принимает функцию расширяющую первый дженерик, ничего не принимает и возвращает второй дженерик
//возвращает второй дженерик
 fun <T, M> T.arg3(fun3: T.() -> M): M {
     return fun3()
 }

//Создай функцию, которая:
//принимает строку
//возвращает функцию, которая ничего не принимает и возвращает строку
fun arg4(a: String): () -> String{
    val fun4: () -> String = {a}
    return fun4
}

//Создай функцию расширяющую дженерик, которая:
//ничего не принимает
//возвращает функцию, принимающую строку и возвращающую дженерик
fun <T> T.arg5(): (String) -> T {
    val fun5: (String) -> T = {this}
    return fun5
}

object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}

fun String.colorize(color: String): String {
    return "$color$this${Colors.RESET}"
}

