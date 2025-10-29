package ru.stimmax.cotlincouse.lessons.lesson16.homework16.shape

fun main() {
    val circle = Circle(12.0)
    println(circle.area())

    val square = Square(7.5)
    println(square.area())

    val triangle = Triangle(12.1, 14.6, 45)
    println(triangle.area())

    val shape = listOf(circle, square, triangle)
    shape.forEach { println(it.area()) }

}

