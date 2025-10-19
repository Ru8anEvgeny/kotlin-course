package ru.stimmax.cotlincouse.lessons.lesson13

fun main() {
    val fruitsPrices = mapOf("apple" to 2.99, "banana" to 1.99, "cherry" to 3.99)

    // Словарь хранит объект типа Entry - вложенный тип внутри Map. Это тип которых хранит 2 типа ключ и значения

    // перебор элементов словаря
    for (entry in fruitsPrices.entries) { // Через entries - можем получить список
        println("Key: ${entry.key}, Value: ${entry.value}")
    }

    // деструктуризация данных
    for ((key, value) in fruitsPrices) {
        println("Ключ: $key, Значение: $value")
    }

    // что можем получить из словаря
    val entries: Set<Map.Entry<String, Double>> = fruitsPrices.entries // множество состоящее из Map.Entry
    // объектов, у которых ключ и значение
    println(entries)

    // Можем достать только ключи. Ключи в словаре должны быть уникальны. Поэтому Set- ножество
    val keys: Set<String> = fruitsPrices.keys
    println(keys)

    // Можем достать список всех значений. Collection - это интерфейс от которого наследуются списки
    val values: Collection<Double> = fruitsPrices.values
    println(values)


    // Методы получения элементов из словаря

    // getOrElse - дает возможность получить значение по ключу.
    val priseOfPearOrElse = fruitsPrices.getOrElse("pear") {9999999.99} // Если ключа нет то добавляем его
   // со значением указанным в фигурных скобках. Значение по умолчанию. Внутри можно выполнять различный код
    println(priseOfPearOrElse)



    // getValues - вернет значение ключа
    val priceOfApple = fruitsPrices.getValue("apple")
    println(priceOfApple)


    // getOrDefault - вернет значение по ключу или дефолтное значение, если такого ключа нет.
    val priceOfDefault = fruitsPrices.getOrDefault("pear", 0.0)
    println(priceOfDefault)


    // Можем создать новый словарь из сущ-го Напимер:
    val fruitsWithoutBanana = fruitsPrices - "banana" // создали новый словарь в котором нет ключа banana
    val fruitsWitchAddPineapple = fruitsPrices + ("pineapple" to 3.5) // создали новый словарь в который добавили
    // ключ pineapple со значением 3.5


    val mutableFruits = fruitsPrices.toMutableMap() // создали новый мутабельный словарь из неизменяемого уже имеющегося

    mutableFruits["kiwi"] = 2.75// добавили в словарь ключ kiwi

    mutableFruits.putAll(mapOf("lime" to 1.1, "avocado" to 1.9))// Добавили  словарь в словарь
    println(mutableFruits)

    val result = mutableFruits + mapOf("lime" to 1.1, "avocado" to 1.9)// Не добавляет новые элементы в словарь, а создает новый
    println(result)

    mutableFruits.remove("apple") // удаление элемента
    mutableFruits.clear()// очистка словаря


    // Проверки словаря
    // containsKey - проверка есть ли ключ в словаре. В есть true
    val containsApple = fruitsPrices.containsKey("apple")

    // containsValue - проверяет есть ли значение в ловаре
    val containsValue = fruitsPrices.containsValue(1.1)

    // is.Empty - проверяет пуст ли словарь. true/false
    val isEmpty = fruitsPrices.isEmpty()

    // isNotEmpty - проверяет НЕ пуст ли словарь. true/false
    val isNotEmpty = fruitsPrices.isNotEmpty()


    // Метод all проверяет выполняется ли для каждого элемента словаря условие заданное в фиг скобках. true/false
    val all = fruitsPrices.all { it.value > 1.0 } // проверяем каждое ли значение в словаре больше 1.0

    // метод any - проверяет выполняется ли условие заданное в  фиг скобках хотя бы для 1 элемента словаря. true/false
    val any = fruitsPrices.any { it.value < 1.0 } // проверяем, что хотя бы 1 значение в словаре меньше 1.0


    // метод non - не 1 из элементов словаря не должен соответствовать условиям заданным в фиг скобках

    val non = fruitsPrices.none{it.value > 10.0}


    // Фильтрация элементов - filter фильтрует словарь и возвращает новый словарь с отфильтрованными элементами.
    val filteredByPrice = fruitsPrices.filter { it.value > 1.0 && it.key.startsWith("e") }
    // говорим отфильтруй словарь по значениям которые больше 1.0 и ключи начинаются с е

    val filterByKeys = fruitsPrices.filterKeys { it.startsWith("a") }
    // говорим отфильтруй словарь по ключам которые начинаются с а

    val filterValues = fruitsPrices.filterValues { it < 2.0 }
    // говорим отфильтруй словарь по значениям которые меньше 2.0

    val filterNot = fruitsPrices.filterNot { it.key == "apple" && it.value > 10.0 }
    // говорим отфильтруй словарь по ключам которые НЕ равны apple и которые НЕ больше 10.0

    // count - количество элементов.
    val count = fruitsPrices.count{it.value > 1.5}
    // говорим отфильтруй словарь по элементам которые больше 1.5 и верни кол-во этих элементов


    // Преобразование словарей
    // mapValues - создает новый словарь в котором ключи остаются старыми, а значения преобразовываются
    val increasedPrised = fruitsPrices.mapValues { "${it.value * 1.1}" }
    //mapValues - работает с данными либо изменяет их либо преобразует в другой тип.
    // В данном случае создали новый словарь в котором умножили значения на 1.1, а потом преобразовали в тип String



    // mapKeys - работает только с ключами. Можем преобразовывать ключи, менять их данные, менять тип
    // Создается новый словарь
    val fruitsNames = fruitsPrices.mapKeys { it.key.uppercase() }
    // создали новый словарь в котором преобразовали ключи в верхний регистр



    // функция map - преобразует словарь в коллекцию, список
    val fruitsList: List<String> = fruitsPrices.map { "${it.key} cost ${it.value}" }
    println(fruitsList)



    // В обоих случаях создастся новый словарь
    val toMap = mutableFruits.toMap() // преобразовали изменяемы словарь в неизменяемый
    val toMutableMap = fruitsPrices.toMutableMap() // преобразовали неизменяемый словарь в изменяемый



    fruitsPrices.forEach{ (fruit, price) ->
        println("$fruit costs $price")
    }
    // говорим пройдись циклом по словарю fruitsPrices в котором ключ fruit, а значение price
    // и выведи их на экран


    // если не указываем никаких переменных в forEach, значит будет доступна it
    fruitsPrices.forEach{
        println("${it.key} cost ${it.value}")
    }


    fruitsPrices.size // кол-во ключей
    fruitsPrices.count() // тоже кол-во ключей
    fruitsPrices.count(){it.value > 2.0} // вывести ко-во ключей, но сначала применить фильтр тот что в фиг скобках






















}