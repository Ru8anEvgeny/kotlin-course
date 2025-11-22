package ru.stimmax.cotlincouse.lessons.lesson21

import kotlin.math.absoluteValue

fun main() {
    val arg1: Any = "ERREEDD"
    println((arg1 as String).length)
    println((arg1 as? Int)?.plus(12))

    if (arg1 is String) {
        println("Строка")
    } else {
        println("Не является строкой")
    }

    println((arg1 as? Int ?: "Не является числом"))

    val arg2: Any = listOf("qwq", "str2", "str3")
    //println((arg2 as List<String>))

    //println((arg2 as List<Int>)[0].absoluteValue)
//
//    if (arg2 is List<*>) {
//        println(arg2)
//    } else {
//        println("не является списком")
//    }

//    if ((arg2 as List<*>).isNotEmpty() && arg2[0] is String) {
//        println(arg2)
//    }
//

    println((arg2 as? List<*>)?.firstOrNull() as? String ?: "Не является строкой")



}

fun tryMultiple(arg: Any): Int? {
    return when (arg) {
        is Int -> arg * 2
        is String -> arg.toInt() * 2
        else -> null
    }
}

fun tryMultiple1(arg: Any): Int? {
    return (arg as? Int)?.times(2) ?: ((arg as? String)?.toIntOrNull()?.times(2))
}