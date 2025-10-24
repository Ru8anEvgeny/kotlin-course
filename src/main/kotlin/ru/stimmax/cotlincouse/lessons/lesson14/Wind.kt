package ru.stimmax.cotlincouse.lessons.lesson14
// спрашиваем какая основная характеристика есть у ветра? - Скорость - ее передаем в конструкторе
class Wind(private var speed: Int) {

    fun convertToMetersPesSecond(): Int {
        return speed / 3.6.toInt()
    }

    fun setSpeed(speed1: Int) {
        if (speed1 < 0) {
            return
        } else {
            this.speed = speed1

        }
    }
}