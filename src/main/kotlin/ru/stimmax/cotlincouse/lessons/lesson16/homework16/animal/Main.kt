package ru.stimmax.cotlincouse.lessons.lesson16.homework16.animal

fun main() {
    val dog = Dog()
    dog.makeSound()

    val cat = Cat()
    cat.makeSound()

    val bird = Bird()
    bird.makeSound()

    val listAnimal = listOf(dog, cat, bird)
    listAnimal.forEach { it.makeSound() }
}