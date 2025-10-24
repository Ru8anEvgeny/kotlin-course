package ru.stimmax.cotlincouse.lessons.lesson14.homeworks14

//Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию.
// У него должно быть свойство type (String) и intensity (Int). Добавьте метод express(),
// который выводит описание эмоции в зависимости от её типа и интенсивности.

class Emotion(val type: String, val intensity: Int) {

    fun express() {
        println("Эмоция типа $type имеет интенсивность $intensity")
    }


}