package ru.stimmax.cotlincouse.lessons.lesson16.homework16.printer

fun main() {
    val laserPrinter = LaserPrinter()
    laserPrinter.print("Тестовый текст")

    val inkjetPrinter = InkjetPrinter()
    inkjetPrinter.print("Этот тест предназначен для проверки работы струйного принтера с разноцветными словами на разных фонах. Слова должны быть яркими и хорошо заметными!")
}