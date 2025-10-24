package ru.stimmax.cotlincouse.lessons.lesson14.homeworks14

//Событие: вечеринка. Создайте класс Party, который описывает вечеринку.
// У него должны быть свойства location (String) и attendees (Int). Добавьте метод details(),
// который выводит информацию о месте проведения и количестве гостей.

class Party(private val location: String, private val attendees: Int) {

    fun details() {
        println("Место проведения $location и кол-во гостей $attendees")
    }

}