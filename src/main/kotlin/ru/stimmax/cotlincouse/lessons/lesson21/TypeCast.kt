package ru.stimmax.cotlincouse.lessons.lesson21

//cast - это преобразование или приведения типов
// Проверка типов - оператор is и !is - проверяет, что переменная является каким либо типом
fun main() {
    val obj: Any = "Hello"
    if (obj is String) {
        obj.length
        println("Объект - строка")
    }

    if (obj is Double) { // код внутри не выполнится т.к obj не является Double
        obj.plus(12)
        println(obj)
    }

    if (obj !is Int) {
        println("Объект не является целым числом")
    }

    // оператор as выполняет преобразование типов
    val num: Any = 123
    //val str: String = num as String// выбросит исключение т.к был тип инт а мы хотели преобразовать его в стринг

    val str2: String? = num as? String // str2 будет равна null
    println(str2)

    val mixedList: List<Any> = listOf("Kotlin", 42, 4.14, "JAVA", true) // создали список из объектов разных типов
    for (item in mixedList) { // проходимся по списку
        when(item) { // проверяем с помощью is
            is String -> println("$item - строка с длинной ${item.length}")
            is Int -> println("$item - целое число")
            is Double -> println("$item - вещественное число")
            else -> println("неизвестный тип")
        }
    }

    val car = Car()
    checkSmartCast(car)

    val flyingCar = FlyingCar()
    checkSmartCast(flyingCar)


}

// пример работы с интерфейсами
interface Drivable {
    fun drive()
}

interface Flyable {
    fun fly()
}

open class Car : Drivable {
    override fun drive() {
        println("Едет как автомобиль")
    }
}


class FlyingCar : Car(), Flyable {
    // тут будет так же доступна функция drive т.к класс наследуется от Car
    override fun fly() {
        println("Летит как самолет")
    }
}


fun checkSmartCast(drivable: Drivable) {
    drivable.drive()
    if (drivable is Flyable) { // drivable может быть так же типом Flyable, потому что класс FlyingCar
        // инмплементирует интерфейс Flyable, но при этом наследуется от Car(), который в свою очередь
        // имплементирует интерфейс Drivable

        drivable.fly() // выполнится метод, т.к drivable может быть и типом Flyable, потому, что есть класс
        //FlyingCar
    } else {
        println("Этот объект не может летать")
    }
}

fun check(drivable: Drivable) {
    drivable.drive()
    (drivable as? Flyable)?.fly() ?: println("Этот объект не может летать")
}