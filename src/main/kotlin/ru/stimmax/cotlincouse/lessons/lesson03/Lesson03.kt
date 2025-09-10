package ru.stimmax.cotlincouse.lessons.lesson03

class Lesson03 {

    val name: String = "Evgeni"// инициализировали переменную

    private var age: Int = 30 // целочисленное в определенном диапазоне. Если есть private, то можно использовать только внутри класса

    fun example() {
        age = 32  // принято использовать val
    }

    lateinit var phoneNumber: String // отложенная инициализация.

    val lazyValue: String by lazy { // ленивая инициализация
        "Hello, this is a lazy string!"
    }

    var score: Int = 10
    var speed: Double? = null // null отсутствие значения. Нужно обозначить тип как  ?




}