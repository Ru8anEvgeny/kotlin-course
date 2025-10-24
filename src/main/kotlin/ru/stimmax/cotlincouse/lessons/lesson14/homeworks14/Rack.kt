package ru.stimmax.cotlincouse.lessons.lesson14.homeworks14


//Характеристики: Класс Rack (Стеллаж)
//Список полок (shelves): хранит полки стеллажа.
//Максимальное количество полок.

class Rack(val shelves: MutableList<Shelf>, val maxSelf: Int ) {

    // Добавление Полки (addShelf)
    //Добавляет новую полку в стеллаж. Говорим, что функция принимает объект класса Shelf
    //Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен
    // или была попытка добавить полку которая уже установлена.
    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.contains(shelf) || shelves.size > maxSelf) {
            return false
        }
        shelves.add(shelf)
        return true

    }

//    Удаление Полки (removeShelf):
//    Принимает индекс полки для удаления.
//    Удаляет полку по указанному индексу.
//    Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
    fun removeShelf(indexShelf: Int): List<String?>{
        if (indexShelf in shelves.indices) { // если индекс есть в списке индексов
            shelves.removeAt(indexShelf) // удаляем индекс из списка
            val result = shelves[indexShelf].getItems()// обращаемся к конкретной полке индексу и вызываем у нее метод getItems
            return result
        } else {
            return emptyList() // пустой лист
        }
    }

//Добавление Предмета (addItem):
//Добавляет предмет на первую свободную полку.
//Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
    fun addItem(name: String): Boolean {
        if (shelves.isEmpty()) { // проверили есть ли вообще полки. Если список полок пустой сразу false
            return false
        }
        for (shelf in shelves) { // идем по всем полкам
            shelf.containsItem(name) // проверяем можем ли добавить предмет на текущую полку
            return shelf.addItem(name) // если нашли подходящую полку добавляем на нее наш предмет
        }
    return false // возвращаем если в цикле не нашлась подходящая полка в которую можем добавить предмет

    }

// Удаление Предмета (removeItem):
//Находит и удаляет только один предмет с любой полки.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
fun removeItem(name: String): Boolean {
    if (shelves.isEmpty()) { // проверили есть ли полки.
        return false
    }
    for (shelf in shelves) {// проходимся по всем полкам
        if (shelf.containsItem(name)) { // если у конкретной полки содержится предмет
            return shelf.removeItem(name) // Удаляем его.  removeItem - метод из класса Shelf
        }
    }
    return false // если в цикле не нашли подходящий элемент который входит в полку

}

//Проверка наличия предмета на стеллаже (containsItem):
//Возвращает true если предмет есть на одной из полок
    fun containsItem(name: String): Boolean {
        for (shelf in shelves) {
            return shelf.containsItem(name)
        }
    return false
    }

// Получение списка полок (getShelves):
//Возвращает неизменяемый список полок
    fun getShelves(shelves: MutableList<Shelf>) = shelves.toList()

// Печать Содержимого (printContents):
//Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость,
// список предметов. Информацию выводить в наглядном читаемом виде
    fun printContents(){
        for (i in shelves.indices) { // проходимся по индексам полок
            val capacity = shelves[i].capacity // находим макс вместимость
            val accessiblePlace = capacity - shelves[i].getItems() // находим оставшуюся вместимость
                .map { it.length }
                .sum()
            val meta = "$i вместимость: $capacity доступно: $accessiblePlace"
            val items = shelves[i].getItems().joinToString()
            println(meta)
            println("Предметы: $items")
            println()
        }
    }

    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) {
            return emptyList()
        }
        val notReplacedItems = mutableListOf<String>()
        val otherShelves = shelves - shelves[index]
        for (item in shelves[index].getItems()) {
            if (otherShelves.none { it.addItem(item) }) {
                notReplacedItems.add(item)
            }
        }
        shelves.removeAt(index)
        return notReplacedItems.toList()
    }






}