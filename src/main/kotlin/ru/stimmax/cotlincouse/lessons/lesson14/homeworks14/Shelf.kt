package ru.stimmax.cotlincouse.lessons.lesson14.homeworks14

class Shelf(val capacity: Int, private val items: MutableList<String>) {
// val items - Список предметов
// capacity - максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
// name - название предмета


    fun addItem(name: String): Boolean { // // Добавление Предмета
        // нужно проверить поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
        // и добавить предмет, если есть место.
        // 1. вызываем проверку помещается ли предмет на полку
        if (canAccommodate(name)) { // если функция проверки вместимости возвращает true, то добавляем предмет в лист с предметами
            items.add(name)
            return true
        } else {
            return false
        }

    }


    fun removeItem(name: String): Boolean { // Удаление предмета
        if (items.contains(name)) { // говорим, если на полке содержится элемент name
            items.remove(name) // удаляем его из списка
            return true // возвращаем true
        } else {
            return false // иначе возвращаем false
        }

    }





    fun canAccommodate(name: String): Boolean { // Проверка Вместимости
        // нужно проверить, что сумма длинны букв name и списка items < чем capacity
        //1. посчитаем сумму
        val sum = name.length + items.map { it.length }.sum()
        // Взяли длину элементов name. Лист items преобразовали в список длин каждого элемента листа и сложили их
        if (sum <= capacity) { // говорим если сумма длинны букв name и списка items < чем capacity, значит предмет помещается на полку
            return true
        } else {
            return false
        }

    }


    // Проверка наличия предмета (containsItem):
    //Принимает название предмета
    //Возвращает true если такой предмет есть

    fun containsItem(name: String): Boolean {
        return items.contains(name)
    }

    // Получение списка предметов (getItems):
    //Возвращает неизменяемый список предметов
    fun getItems() = items.toList()




}