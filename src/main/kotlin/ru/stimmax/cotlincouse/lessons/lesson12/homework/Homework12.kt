package ru.stimmax.cotlincouse.lessons.lesson12.homework

fun main() {
    //Задачи на приведение коллекции к значению
    //1. Проверить, что размер коллекции больше 5 элементов.
    val baseList = mutableListOf<Int>()
    baseList.addAll(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, -1, -6))
    if (baseList.size > 5) {
        println("размер коллекции больше 5 элементов.")
    } else {
        println("размер коллекции меньше 5 элементов.")
    }
//2. Проверить, что коллекция пустая
    println(baseList.isEmpty())
//3.  Проверить, что коллекция не пустая
    println(baseList.isNotEmpty())
//4. Взять элемент по индексу или создать значение если индекса не существует
    val arg4 = baseList.getOrElse(30) { 40 }
    println(arg4)

// 5. Собрать коллекцию в строку
    println(baseList.joinToString(" "))

// 6. Посчитать сумму всех значений
    val arg6 = baseList.sum()
    println(arg6)

// 7. Посчитать среднее
    val arg7 = baseList.average()
    println(arg7)

// 8. Взять максимальное число
    val arg8 = baseList.maxOrNull()
    println(arg8)
// 9. Взять минимальное число
    val arg9 = baseList.minOrNull()
    println(arg9)
// 10. Взять первое число или null
    val arg10 = baseList.firstOrNull() { it > 10 }
    println(arg10)

// 11. Проверить что коллекция содержит элемент
    if (baseList.contains(23)) {
        println("Элемент найден")
    } else {
        println("Элемент не найден")
    }

//Задачи на обработку коллекций
// 12. Отфильтровать коллекцию по диапазону 18-30
    val list = listOf(8, 56, 23, 666, 90, 1, 7, 10, 3, 18, 30)
    val filter = list.filter {
        it in 18..30
    }
    println(filter)
// 13. Выбрать числа, которые не делятся на 2 и 3 одновременно
    val arg11 = mutableListOf<Int>()
    list.forEach {
        if (it % 2 != 0 && it % 3 != 0) {
            arg11.add(it)
        }
    }
    println(arg11)

// 14. Очистить текстовую коллекцию от null элементов
    val textCollection = arrayOf("Stkr1", null, "Atr2", null, "Str3", "Str3")
    val arg12 = textCollection.filterNotNull()
    println(arg12)
// 15. Преобразовать текстовую коллекцию в коллекцию длин слов
    val arg15 = arg12.map { it.length }
    println(arg15)

// 16. Преобразовать текстовую коллекцию в мапу, где ключи - перевёрнутые слова, а значения - длина слов
    val arg16 = arg12.associate { it.reversed() to it.length }
    println(arg16)

// 17. Отсортировать список в алфавитном порядке
    val arg17 = arg12.sorted()
    println(arg17)

// 18. Взять первые 3 элемента списк
    val arg18 = arg12.take(3)
    println(arg18)
// 19. Распечатать квадраты элементов списка
    arg12.forEach {
        val length = it.length
        println(length * length)
    }

// 20. Группировать список по первой букве слов
    val arg20 = arg12.groupBy { it[0] }
    println(arg20)

// 21. Очистить список от дублей
    val arg21 = arg12.distinct()
    println(arg21)

// 22. Отсортировать список по убыванию
    val arg22 = arg12.sortedDescending()
    println(arg22)
// 23.  Взять последние 3 элемента списка
    val arg23 = arg12.takeLast(3)
    println(arg23)

// Задача 24. Характеристика числовой коллекции
    println(processNumbers(listOf()))
    println(processNumbers(listOf(1, 2, 3, 4)))
    println(processNumbers(listOf(0, 1, 2, 3, 555, 567, 123)))
    println(processNumbers(listOf(10000, 20000, 30000, 40, 14, 12)))
    println(processNumbers(listOf(10, 10, 10, 10, 10, 10)))
    println(processNumbers(listOf(10, 11, 12, 13, 14, 15, 16, 17, 18, 19)))
    println(processNumbers(listOf(-15, -20, -11, -40, -50)))
    println(processNumbers(listOf(1001, 1020, 1010, 1002, 1003, 1004)))
    println(processNumbers(listOf(1, 2, 3, 33, 44, 14, 17)))
    println(processNumbers(listOf(1, 2, 3, 4, 5)))


//Задача 25. Анализ учебных оценок
    val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    println(analyzeGrades(grades))

//26. Создание каталога по первой букве
    val list1 = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
    )
    println(groupByFirstLetter(list1))




}

// Задача 24. Характеристика числовой коллекции
// Напиши функцию, которая принимает коллекцию чисел и возвращает строку с характеристикой коллекции
// используя конструкцию when

fun processNumbers(listInt: List<Int>): String {
    val result =  when {
        listInt.isEmpty() -> "Пусто"
        listInt.size < 5 -> "Короткая"
        listInt.first() == 0 -> "Стартовая"
        listInt.sum() > 10000 -> "Массивная"
        listInt.average().toInt() == 10 -> "Сбалансированная"
        listInt.joinToString("").length == 20 -> "Клейкая"
        listInt.max() < -10 -> "Отрицательная"
        listInt.min() > 1000 -> "Положительная"
        listInt.containsAll(listOf(3, 14)) -> "Пи***тая"
        else -> "Уникальная"
    }
    return result
}

// 25. Напиши функцию, которая принимает список чисел и возвращает список чисел.
//Напиши функцию, которая принимает список чисел и возвращает список чисел.
//Пример данных: val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
//Цель: Отфильтровать удовлетворительные оценки (>=60), отсортировать оставшиеся по возрастанию
// и взять первые 3. Вызывай методы обработки и фильтрации последовательно один из другого,
// чтобы результат предыдущего метода являлся основой для следующего.

fun analyzeGrades(listInt: List<Int>): List<Int> {
    val result = listInt
        .filter { it >= 60 }
        .sorted()
        .take(3)
    return result

}

//26. Напиши функцию, которая принимает список строк и возвращает словарь с ключом - буквой и
// значением - списком строк.
//Цель: Привести все слова в списке к нижнему регистру, сгруппировать в каталог по первой букве
//используя метод groupBy

fun groupByFirstLetter(listString: List<String>): Map<Char, List<String>> {
    val result = listString
        .map { it.lowercase() }
        .groupBy { it.first() }
    return result

}

//Задание 27. Подсчёт средней длины слов в списке
//Напиши функцию, которая принимает список строк и возвращает строку.
//Начальные значения взять из предыдущей задачи.
//Цель: Перевести все слова в количество букв, подсчитать среднее значение. Вернуть форматированный текст с двумя
// знаками после запятой, используя функцию format и подходящий шаблон.

fun averageWordLength(listString: List<String>): String {
    val result = listString
        .map { it.length }
        .average()
    return String.format("%.2f", result)



}


