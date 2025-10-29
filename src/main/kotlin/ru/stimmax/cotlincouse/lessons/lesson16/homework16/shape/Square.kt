package ru.stimmax.cotlincouse.lessons.lesson16.homework16.shape

class Square(
    private val side: Double
) : Shape() {
    override fun area(): Double {
        return side * side
    }
}