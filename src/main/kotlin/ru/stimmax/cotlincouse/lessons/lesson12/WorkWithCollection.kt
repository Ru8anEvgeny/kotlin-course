package ru.stimmax.cotlincouse.lessons.lesson12

fun main() {
    val numbers = listOf(-1, -2, -3, 4, -5, 8, 264)

    val positive = mutableListOf<Int>()

    // итерация коллекции
    numbers.forEach{ // forEach - это функция - цикл для коллекций
        // it - это специальная переменная в котлин для хранения
        // значения коллекции из текущей итерации
        val isPositive = it > 0
        if (isPositive) {
            positive.add(it)
        }
    }

    val result = numbers.filter { it > 0 } // сделали фильтр по неизменяемой коллекции numbers из которой
    println(result)// вычленили все элементы которые больше 0 и записали в новую неизменяемую кол-ю result

    // создаем переменную и говорим что значение коллекции в текущей итерации больше 0, дальше проверяем
    // если это так, то записываем это значение в мутабельный лист


    // метод Фильтр - метод для фильтрации данных
    val list = listOf(8, 56, 23, 666, 90, 1, 7, 10, 3) // создали лист
    val filter = list.filter {// создаем еще 1 объект в котором говорим пройдись по листу
        it in 1..17 // и отфильтруй числа от 1 до 17 и положи в переменную фильтр
    }
    println(filter) // результатом будет [8, 1, 7, 10]


    // Метод filterNot - делает все тоже самое что фильтр, но воспринимает выражение(условия фильтра)
    // наоборот. Например:
    val result1 = filter.filterNot { it > 3 } // Сохранит в result1 все элементы листа <= 3
    println(result1) // результат будет [1, 3]


    // метод filterNotNull()- метод без условий. Он отфильтрует все null значения. Пример:
    val array = arrayOf(1, null, 10, null, 15)
    val filterNotNull = array.filterNotNull()
    println(filterNotNull.sum()) // вывели сумму элементов коллекции filterNotNull- 26


    // получение 1-го или последнего элемента коллекции. Пример
    val first = listOf(-1, -10, 3, 7, 10)
    val firstResult = first.first{it > 0} // сначала выполним фильтр по листу first потом из этого фильтра вычленим 1 элемент
    println(firstResult)// будет 3

    val lastFirst = first.last()// получили последний элемент. Так же можно фильтровать
    // получение 1-го или последнего элемента коллекции удобно брать из множества. Т.к у них нет индексов

    // метод firstOrNull - выведет 1 элемент или null. Пример:
    val nullable = first.firstOrNull{it > 100}// в листе first нет элемента который больше 100. Поэтому результатом будет null
    println(nullable)

    // метод getOrElse - позволяет обратиться к элементу коллекции по индексу и в Фигурных скобках указать
    // что вернуть если такой индекс не будет найден. Пример:
    val elementOrElse = first.getOrElse(10){ -1 }
    // индекса 10 нет в листе first, поэтому результатом будет -1
    println(elementOrElse)


    // Преобразование коллекций. Означает, что будем проходить по элементам коллекции и каждый элемент
    // преобразовывать во что-то другое
    // преобразование выполняется методом map. Пример:

    val testMap = listOf(10, 1, 4, -2)
    val testMap1 = testMap.map { it + 1 } // прошлись по эллементам коллекции testMap и преобразовали ее
    // прибавив к каждому эллементу 1
    println(testMap1)

    val result2 =  testMap.map { it.toString() + " Число"} // преобразовали коллекцию testMap в строки
    println(result2)

    val result3 = testMap.map { it > 0 } // преобразовали коллекцию testMap в булево значение
    println(result3)


    // метод associate - создает словарь
    val numberSquareMap: Map<Int, Int> = testMap.associate { it to it * it }
    println(numberSquareMap) // преобразовали лист testMap в словарь numberSquareMap который содержит
    // ключ - элемент листа testMap, значение - квадрат элемента листа testMap

    // метод flatten - раскрывает списки и склеивает их в один. Пример:
    val multiList = listOf( // создали список у которого элементы являются списком
        listOf(1,2, -2),
        listOf(4,5,6)
    )

    val flattenList = multiList.flatten() // flatten - развернул все списки и записал их в 1.
    println(flattenList)

    // flatMap - метод с вложенным преобразователем данных
    val flattenListAfterMapping = multiList.flatMap { list ->
        list.map { it * 2 }
    }
    println(flattenListAfterMapping)


    // метод joinToString - склеивает элементы списка с помощью сепаратора. Сепаратор - это разделитель
    val joinToString = multiList.flatten().joinToString(" : ")
    println(joinToString) // сначала развернет вложенный список, а потом с помощью joinToString
    // поставит разделитель между элементами коллекции пробел и двоеточие

    // можно так же в joinToString передавай функцию в виде строки. Пример:
    val result5 = multiList.flatten().joinToString(" ") {"${it * 2}"}
    // сначала развернет вложенный список, а потом с помощью joinToString склеит его, далее
    // поставит разделитель между элементами пробел, и каждый элемент умножит на 2
    println(result5)


    // Сортировка - сортирует элементы коллекции по возрастанию. Для числовых от меньшего к большему.
    // У строковых в алфавитном порядке
    val result6 = multiList.flatten().sorted()
    println(result6) // отсортировали по возрастанию список multiList

    // Сортировка в обратном порядке
    val result7 = multiList.flatten().sortedDescending()
    println(result7)

    // можем получить длинну списка с помощью size
     println(result7.size)

    // можем проверить коллекцию на пустоту с помощью isEmpty - если она пустая возврщ - true
    if (result7.isEmpty()){
        println("Коллекция пустая")
    } else {
        println("В коллекции ${result7.size} значений")
    }

    // можем проверить что коллекция не пустая с помощью isNotEmpty
    if (result7.isNotEmpty()){
        println("В коллекции ${result7.size} элементов")
    } else {
        println("Коллекция пустая")
    }

    // contains - проверяет есть ли в коллекции какой либо элемент
    if (result7.contains(42)) {
        println("Содержит элемент 42")
    } else {
        println("Такого значения нет")
    }

    // in - проверяет входит ли какой либо элемент в коллекцию
    if (42 in result7) {
        println("Входит")
    } else {
        println("Не входит")
    }

    // containsAll - принимает список и так же проверяет, что все элементы списка содержатся в коллекции
    if (result7.containsAll(listOf(1,2,3))) {
        println("Элементы нашлись")
    } else {
        println("Элементы не найдены")
    }

    // метод sum - подходит только для числовых коллекций. Позволяет сложить элементы кол-и
    val sum = result7.sum()
    println(sum)


    // метод average - считает среднее арифметическое от коллекции
    val average = result7.average()
    println(average)

    // Можно получить макс и мин значения у числовых коллекций
    val min = result7.maxOrNull()// если список пуст вернет null
    println(min)

    val max = result7.maxOrNull()// если список пуст вернет null
    println(max)


    // метод groupBy - группирует коллекцию по определенному признаку. В результате создает словарь
    // в котором в качестве ключа будет название группы которое мы определяем для определенной
    // группы наших элементов, значения - список элементов которые относятся к этой конкретной группе
    val groupedBy: Map<String, List<Int>> = result7.groupBy { if (it > 0) "Positive" else "Negative" }
    println(groupedBy) // говорим разгруппируй коллекцию result7 по ключам Positive и Negative
    // если элемент коллекции больше 0, то запиши его к ключу Positive, если меньше то к ключу Negative



    // метод distinct() - позволяет отфильтровать из списка все уникальные значения
    val distinctNumber = listOf(1, 1, 4, 5, 7, 5).distinct()
    println(distinctNumber)






















}