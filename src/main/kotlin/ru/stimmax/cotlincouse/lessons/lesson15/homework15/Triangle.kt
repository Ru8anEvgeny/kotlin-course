package ru.stimmax.cotlincouse.lessons.lesson15.homework15

class Triangle(
    val type: String, // тип треугольника
    val sideA: Int,
    val sideB: Int,
    val sideC: Int
): Polygon("Треугольник", 3) {
    fun cosA(sideA: Int, sideB: Int, sideC: Int): Double {
        val numerator = (sideB * sideB + sideC * sideC - sideA * sideA).toDouble()
        val denominator = (2 * sideB * sideC).toDouble()
        return numerator / denominator

    }
}