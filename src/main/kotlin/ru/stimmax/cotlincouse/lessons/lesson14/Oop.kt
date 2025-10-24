package ru.stimmax.cotlincouse.lessons.lesson14

import javax.sound.midi.MetaMessage

fun main() {
    val reservedSeatCarriage = Carriage(48) // создали экземпляр класса - Вагон. Обратились к классу Carriage и
    // Передали размер 48 мест. Не передали тип вагона - значит будет по умолчанию Плацкарт
    // Экземпляр класса - это объект. Теперь reservedSeatCarriage содежит в себе целый вагон



    val compartmentCarriage = Carriage(16, "Купе")
    // создали еще 1 вагон с вместимостью 16 и типом Купе


    val train = Train("Локомотив") // создали переменную для объекта Train.

    train.carriages.add(reservedSeatCarriage) // Добавили вагон К поезду, т.к к объекту train
    train.carriages.add(compartmentCarriage) // добавили еще 1 вагон

    //val passenger = Passenger("Alexandr", "04.09.1999", "+7111-111-11-11")

    Logger.log("qwqeqwe")

    Calculator.add(2, 5)

    val user1 = User(1, "User1")
    val user2 = user1.copy(name = "User2")

    val lamp = Lamp(true)
    lamp.toggle()
    lamp.toggle()

    val wind = Wind(10)




}


object Logger { // Объект.
    fun log(message: String) {
        println("Log: $message")
    }
}

class Calculator() {

    companion object {// сущность которая принадлежит классу Calculator
        fun add (a: Int, b: Int): Int {
            return a + b
        }
    }
}


data class User(val id: Int, val name: String) // дата класс специализируется на хранении данных
// У дата классов не должно быть логики.
