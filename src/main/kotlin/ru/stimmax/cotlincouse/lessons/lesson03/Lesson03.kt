package ru.stimmax.cotlincouse.lessons.lesson03

const val wheels: Int = 4

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

    var score: Int? = 10
    var speed: Double? = null // null отсутствие значения. Нужно обозначить тип как  ?

    fun example1() {
        speed?.dec()// проверили с помощью ?, что тип может быть null
        score?.dec()
        count = 10
    }


    var count: Int = 0 // ограничивают работу с переменной
        get() {
            return if (field > 100) field else 0
        }
        set(value) {
            if (value >= 0) field = value
        }
    // get - регулирует то как будем получать значения из переменной
    // set - в него передается какое-то значение и он будет определять каким образом записать значение в переменную



    val vinCode: String = "ERTYUIOP%^&*"

    var colorCar: String = "RED"

    var mileAge: Int = 0

    lateinit var ownerName : String

    val utilReport: String by lazy {
        ""
    }




















}