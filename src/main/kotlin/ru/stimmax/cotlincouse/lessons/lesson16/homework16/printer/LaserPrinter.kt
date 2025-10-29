package ru.stimmax.cotlincouse.lessons.lesson16.homework16.printer

class LaserPrinter() : Printer() {
    override fun print(text: String) {
        val textSplit = text.split(" ")
        textSplit.forEach { printColor(it, Color.BLACK, Background.WHITE) }
    }
}