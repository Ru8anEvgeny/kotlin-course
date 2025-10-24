package ru.stimmax.cotlincouse.lessons.lesson14.homeworks14
// Природное явление: луна. Создайте объект Moon, который будет представлять Луну.
// Добавьте свойства isVisible (Boolean), чтобы отображать, видна ли Луна в данный момент, и phase (String),
// чтобы отображать текущую фазу Луны (например, "Full Moon", "New Moon"). Добавьте метод showPhase(),
// который выводит текущую фазу Луны.
object Moon {
    var isVisible: Boolean = true
    var phase: String = "Луна полная"

    fun showPhase() {
        if (isVisible) {
            println("Видна луна и сейчас $phase")
        } else {
            println("Луны сейчас не видно")

        }
    }

}