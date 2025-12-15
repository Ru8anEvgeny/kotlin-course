package ru.stimmax.cotlincouse.lessons.lesson25

// Скоуп функций - продолжение функционального программирования. Это небольшой набор специальный функций
// их смысл в том - что они позволяют вызывая их относительно любого объекта ,внутри этой функции
// выполнять действия над этим объектом

fun main() {
    val list = mutableListOf(1, 2, 3)
//    println(list.size)
//    list.add(3)
//    println(list.size)

    val s: Int = with(list) { // лямбда с рессивером или с контекстом. В нем поля и методы доступны на прямую у объекта
        // который передали в первый аргумент лямбды
        println(list.size)
        add(3)
        println(list.size)
        size
    }

//    list.add(5)
//    val result = list.sum()
    // run - вызывается относительно объекта
    val resultRun = list.run {
        add(5)
        sum()
    }

    // use предназначена для работы с ресурсами, которые нужно закрыть после использования,
    // например, с потоками ввода/вывода.
//    val s1 = File("example.txt").inputStream()
//    val content = s1.readBytes()
//    println(content)
//    s1.close()
//
//    // тот же код что и выше только с использованием use
//    File("example.txt").inputStream().use {
//        val comtent = it.readBytes()
//        println(content.size)
//    }

    // apply
    //Функция `apply` возвращает объект после выполнения блока кода. Удобна для инициализации объектов.

    val list1 = mutableListOf(1, 2, 3, 4, 5)
    list1.add(7)
    list1.add(8)

    val list2 = mutableListOf<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    println(list2)


    // also - Функция `also` аналогична `apply`, но внутри лямбды объект доступен через `it`.
// Полезна для выполнения дополнительных операций, не влияющих на объект.
    list2.also {
        println("Добавляем 7")
        println(it)
        it.add(10)
    }.add(7)

    println(list2)

    //let
    //Функция `let` позволяет выполнить блок кода и вернуть результат.
// Внутри лямбды объект доступен через `it`. Часто используется для обработки nullable-объектов.

    val str: String? = "Hello"
    str?.let {
        println(it.length) // выполнится только если str != null
    } ?: println("Строка null")






}
