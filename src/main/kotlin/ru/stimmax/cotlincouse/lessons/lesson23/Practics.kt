package ru.stimmax.cotlincouse.lessons.lesson23

fun test(){
    println("Hello")
}

fun stringLength(str: String): Int{
    return str.length
}

fun String.test5(num: Int, char: Char): Boolean {
    return length < num && contains(char)
}

fun <T> T.test10(arg: T) {
    println(arg)
}


fun main() {

//    val test10 = fun <T> T.(arg: T) {
//        println(arg)
//    }

    val test5 = fun String.(num: Int, char: Char): Boolean {
        return length < num && contains(char)
    }

    val test6: String.(Int, Char) -> Boolean = {num, char ->
        length < num && contains(char)
    }


    val test = fun() { // анонимная функция
        println("Hello")
    }

    val test1: () -> Unit = { // лямбда функция
        println("Hello")
    }

    test1()

    val test2 = {
        println("Hello")
    }
    test2()

    val stringLength = fun (str: String): Int {
        return str.length
    }

    val stringLength1: (String) -> Int = { str ->
        str.length
    }

    val stringLength2 = {str: String ->
        str.length
    }

}