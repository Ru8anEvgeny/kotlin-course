//package ru.stimmax.cotlincouse.lessons.lesson20
//
//// Расширение классов - функция которая объявляется за пределами класса, но вызывается как буд-то
//// эта функция была частью этого класса.
//
//fun String.removeSpaces(): String { // функция расширения. Расширили класс String методом removeSpaces
//    length
//    return this.replace(" ", "_") // возвращаем строку в которой удалены пробелы заменены на подчеркивания
//
//}
//
//val result1 = "Hello World".removeSpaces()
//
//
//fun String.fun1(arg1: Int, arg2: Int): Boolean {
//    return true
//}
//
//fun List<Int>.fun2(str: String?) {
//}
//
//fun <K, V>Map<K, V>.fun3(key: K, value: V): V {
//    return value
//}
//
//fun Double?.fun3(): Int?{
//    return null
//}
//
//fun <T> Set<T>.fun4(arg: T): List<T> {
//    return this.toList()
//}
//
//fun Double.fun5(): String {
//    return "%,.2f".format(this)
//}
//
//fun String.fun6(): Int {
//    return this.split(" ").filter { it.isNotBlank() }.size
//}
//
//fun <T> T.fun9(): List<T> = listOf(this)
//
//
//fun main() {
//    println(4.122321.fun9())
//    "qweqqweewq".fun9()
//}