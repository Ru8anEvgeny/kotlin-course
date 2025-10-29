package ru.stimmax.cotlincouse.lessons.lesson16.homework16.animal

abstract class Animal {

    open fun makeSound() {
        println("This animal makes no sound.")
    }
     protected fun colorText(text: String, color: String) {
         printColor(text, color)
     }

}