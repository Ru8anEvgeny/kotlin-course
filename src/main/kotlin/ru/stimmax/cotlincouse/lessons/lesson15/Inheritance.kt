package ru.stimmax.cotlincouse.lessons.lesson15
// Наследование - один из 4 принципов ООП, который позволяет 1 классу унаследовать свойства и методы
// другого класса.

// Основной класс Транспортное Средство
abstract class Vehicle(
    val maxWeight: Int, // макс грузоподъемность
    val passengerCapacity: Int, // кол-во пассажиров которое может вместиться
    val serialNumber: String // серийный номер
) {
    open fun startMovement() {
        println("Транспортное средство начало движение")
    }
    open fun stopMovement() {
        println("Транспортное средство остановлено")
    }
}

// Класс Колесное транспортное средство, наследуется от класса Транспортное средство
open class WheeledVehicle(
    maxWeight: Int, // обеспечили теми же самыми характеристиками что и были
    passengerCapacity: Int,
    serialNumber: String,
    val wheelCount: Int // добавили кол-во колес
) : Vehicle(maxWeight, passengerCapacity, serialNumber){} // : - значит наследуемся.


// Подкласс колесного ТС, наследуется от класс Колсное транспортное средство
class Car(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    val engineType: String,// добавили поле тип двигателя
    val bodyType: String // добавили поле тип кузова
    // не указали wheelCount в конструкторе класса Car, а захардкодили конструкторе класса от которого наследуемся
): WheeledVehicle(maxWeight, passengerCapacity, serialNumber, 4) {
    fun turnOnLights() {
        println("Включены габариты")
    }

    fun turnOffLights() {
        println("Габариты выключены")
    }

    fun activateTurnSignal(direction: String) {
        println("Поворотник включен: $direction")
    }

}

// Создали класс велосипеда, его наследуем от колесного транспортного средства
class Bicycle(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String
) : WheeledVehicle(maxWeight, passengerCapacity, serialNumber, 2) {
    fun pedal() {
        println("педали крутятся")
    }
}

fun main() {
    val car = Car(
        400,
        5,
        "1123132213",
        "ДВС",
        "кабриолет")

    car.startMovement() // вызвали метод у объекта класса Кар, который наследуется от класса Vehicle


}


// Класс который отмечен специальным словом Open - значит что он готов к наследованию.
// Абстрактный класс - значит что создать объект этого класса нельзя. Обозначать стоит те классы объект которых создавать не имеет смысла
// Можно помечать методы как абстрактные.