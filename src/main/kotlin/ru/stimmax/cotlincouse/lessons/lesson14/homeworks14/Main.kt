package ru.stimmax.cotlincouse.lessons.lesson14.homeworks14

fun main() {
    val party = Party("Location1", 100)
    party.details()

    val emotion = Emotion("Смех", 10)
    emotion.express()

    Moon.showPhase()
    Moon.isVisible = false
    Moon.showPhase()

    Product("Помидор", 100.0, 1)
    Product("Огурец", 55.5, 1)

    val concert = Concert("Group1", "DC", 225.1, 100, 5)
    //concert.details()
    concert.buyTicket()
    concert.details()
}

