package ru.stimmax.cotlincouse.lessons.lesson16.homework16.shape

class Circle(
    private val radius: Double
) : Shape() {
    override fun area(): Double {
        return radius * radius * 3.14

    }
}