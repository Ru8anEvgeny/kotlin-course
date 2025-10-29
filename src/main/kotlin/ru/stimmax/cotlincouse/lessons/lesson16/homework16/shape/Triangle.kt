package ru.stimmax.cotlincouse.lessons.lesson16.homework16.shape

class Triangle(
    private val sidA: Double,
    private val sidB: Double,
    private val sinC: Int
) : Shape() {
    override fun area(): Double {
        return (sidA * sidB * sinC) / 2

    }
}