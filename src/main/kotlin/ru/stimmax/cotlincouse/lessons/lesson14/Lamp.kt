package ru.stimmax.cotlincouse.lessons.lesson14

class Lamp(var shine: Boolean) {

    fun turnOn() {
        shine = true
    }

    fun turnOff() {
        shine = false
    }

    fun toggle() {
        shine = !shine
        if (shine) {
            println("Лампа была включена")
        } else {
            println("Выключена")
        }

    }
}