package ru.stimmax.cotlincouse.lessons.lesson17

class Lamp { // создали класс лампы

    private var isOn = false // создали приватное поле класса которое определяет вкл или выкл лампа

    fun turnOn() { // создали публичный метод для включения лампы
        isOn = true
    }

    fun turnOf() { // создали публичный метод для выключения лампы
        isOn = false
    }

    fun shine(): Boolean { // создали метод который возвращает состояние лампы
        return isOn
    }

}