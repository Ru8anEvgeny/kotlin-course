package ru.stimmax.cotlincouse.lessons.lesson10

fun main() {

    val pair = 1 to "a" // to - этот метод позволяет задавать значения для пары ключ значения
    // словари map - это коллекции хранящие данные в виде ключа значение

    val emptyMap = mapOf<String, String>() // создали неизменяемый словарь
    val emptyMap1: Map<String, String> = mapOf()

    // варианты с инициализацией сразу
    val capitals = mapOf("Россия" to "Москва", "Франция" to "Париж")
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")

    // изменяемые словари
    val mutableMap = mutableMapOf("Россия" to "Москва", "Франция" to "Париж")
    mutableMap["Германия"] = "Берлин"// в [] передается ключ, после знака = передается значение
    // добавили в словарь mutableMap "Германия" to "Берлин"

    mutableMap["Германия"] = "Франкфурт" // изменили в словаре mutableMap значение ключа Германия

    mutableMap.remove("Франция") // Удаление. При удалении можно передать ключ и удалится ключ значения

    val capitalOfRussia = mutableMap["Россия"] // в переменную capitalOfRussia присвоили значение ключа Россия
    println(capitalOfRussia)


    // Перебор в цикле
    for ((country, capital) in capitals) { // в круглые скобки через запятую указываем название 2х переменных
        println("$country: $capital")
    }
    // Говорим пройдись в цикле фор по словарю capitals где country - ключ, capital - значение
    // И выведи по очереди все ключ значения в этом словаре


    if ("Россия1" in capitals) {
        println("Столица России: ${capitals["Россия"]} ")
    }

    // Говорим ЕСЛИ в словаре capitals есть ключ "Россия", то выведи значение этого ключа  {capitals["Россия"]}



    //  В качестве ключей может быть null. Так делать не нужно
    val mapWitchNull = mutableMapOf(null to 1)

    // значения могут быть не уникальны
    val map4 = mutableMapOf("a" to 1, "b" to 1, "c" to 1)


    val a1 = mapOf("Age1" to 21, "Age2" to 32)

    val a2 = mutableMapOf("key1" to "str1")
    a2["key2"] = "str2"
    println(a2)
    a2.remove("key1")
    println(a2)

    // написать цикл который выводит все из словаря а1
    for ((key, arg) in a1) {
        println("$key: $arg")
    }

















}

