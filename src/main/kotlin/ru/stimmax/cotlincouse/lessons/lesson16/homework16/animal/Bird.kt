package ru.stimmax.cotlincouse.lessons.lesson16.homework16.animal

import ru.stimmax.cotlincouse.lessons.lesson16.printColored

class Bird : Animal() {
    override fun makeSound() {
        printColor("Tweet", Colors.CYAN)
    }
}