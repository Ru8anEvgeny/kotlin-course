package ru.stimmax.cotlincouse.lessons.lesson16.homework16.animal

class Cat: Animal() {
    override fun makeSound() {
        colorText("Meow", Colors.BLUE)
    }
}