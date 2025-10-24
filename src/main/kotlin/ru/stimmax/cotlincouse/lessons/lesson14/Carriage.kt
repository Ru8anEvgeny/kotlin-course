package ru.stimmax.cotlincouse.lessons.lesson14

class Carriage(val capacity: Int, val type: String = "Плацкарт") { // класс принимает поля в конструкторе
    private val passengers = mutableMapOf<Int, Passenger>() // оле вне конструктора

    fun boardPassenger(passenger: Passenger, seat: Int) {
        if (passengers.size < capacity) {
            passengers[seat] = (passenger)
        }
    }

    fun passengerGetOff(seat: Int) {
        passengers.remove(seat)

    }
}