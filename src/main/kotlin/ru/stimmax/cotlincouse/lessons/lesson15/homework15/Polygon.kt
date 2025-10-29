package ru.stimmax.cotlincouse.lessons.lesson15.homework15

open class Polygon( // производный класс - многоугольник от класса Геометрические фигуры
    name: String, // имя многоугольника
    val numberOfSides: Int // кол-во сторон
): GeometricFigure(name)