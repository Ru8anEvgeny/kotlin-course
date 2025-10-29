package ru.stimmax.cotlincouse.lessons.lesson15.homework15

class Quadrilateral(
    sideA: Int,
    sideB: Int,
    sideC: Int,
    sideD: Int
): Polygon("Четырехугольник", 4) {
    fun perimeter(sideA: Int, sideB: Int, sideC: Int, sideD: Int) : Int {
         return sideA + sideB + sideC + sideD
    }
}