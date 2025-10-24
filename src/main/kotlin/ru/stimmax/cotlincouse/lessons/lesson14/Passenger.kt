package ru.stimmax.cotlincouse.lessons.lesson14

import java.time.LocalDate
import java.time.Period

// Класс - это шаблон или чертеж который описывает состояние и поведение которыми обладает объект.
// этого класса. Класс состоит из полей атрибутов и методов функций

//

class Passenger( // в () указывается конструктор
    // В конструкторе содержится набор переменных, которые мы будем обязаны определить при создании объекта
    // этого класса
    val name: String,
    private val dateOfBirth: String,
    private var phone: String
) { // в {} указывается тело класса
    // Все что хранит данные это - ПОЛЯ
    private var age: Int = calculateAge()

    // Поведение класса. Каждый экземпляр каждого класса будет обладать определенным поведением.
    //Т.е действиями которые этот объект может выполнять над данными
    private fun calculateAge(): Int {// приватная функция - доступна только внутри класса
        return Period.between(
            LocalDate.parse(dateOfBirth),
            LocalDate.now()
        ).years
    }

    fun recalculateAge() {// публичная функция -
        age = calculateAge()
    }

}