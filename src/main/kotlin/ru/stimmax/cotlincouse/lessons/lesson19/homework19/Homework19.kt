package ru.stimmax.cotlincouse.lessons.lesson19.homework19

//Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент,
// если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.

fun <T> getMiddleElement(list: List<T>): T? {
    if (list.size % 2 == 0) {
        return null
    }
    return list[list.size / 2]
}

//Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления нового
// элемента и получения всех элементов в виде неизменяемого списка.

class ListHolder<T>(
    private val list: MutableList<T>
) {
    fun addElement(arg: T) {
        list.add(arg)
    }

    fun getElements(): List<T> {
        return list.toList()
    }
}

//Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
//элементов одного типа в элементы другого типа
//списка элементов одного типа в список элементов другого типа

interface Mapper<T, R> {
    fun transform(element: T): R
    fun transformList(element: List<T>): List<R>
}


//Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>.
// Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных
// слов. Метод преобразования списков с аналогичной механикой.

class PhrasesToListOfStrings() : Mapper<String, List<String>> {
    override fun transform(element: String): List<String> {
       return element.split(" ")
    }

    override fun transformList(element: List<String>): List<List<String>> {
        return element.map { it.split(" ") }

    }

}

//Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и
// возвращает словарь, в котором ключ и значения поменялись местами.
fun <K, V> transposition(map: Map<K, V>): Map<V, K> {
    return map.map { it }.associate { it.value to it.key }
}

// Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать элемент с
// типом дженерика и возвращать булево значение.
interface Validator<T> {

    fun validator(element: T): Boolean
}

//Создай класс StringValidator и имплементируй интерфейс Validator с типом String?.
// Реализуй проверку, что строка не является null, не пустая и не состоит из одних пробелов.
class StringValidator() : Validator<String?> {
    override fun validator(element: String?): Boolean {
        return !element.isNullOrBlank()
    }

}

//Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int.
// Реализуй проверку, что число чётное.
class OddValidator() : Validator<Int> {
    override fun validator(element: Int): Boolean {
        return element % 2 == 0
    }
}


//Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй интерфейс
// Validator типизированный по типу List с nullable типом дженерика класса
//Реализуй проверку:
//Ни один элемент списка не является null
//Ни один элемент приведённый к типу Double не равен 0.0

class ListValidator<T: Number>() : Validator<List<T?>> {
    override fun validator(element: List<T?>): Boolean {
       return element.all { it != null && it.toDouble() != 0.0}

    }

}



