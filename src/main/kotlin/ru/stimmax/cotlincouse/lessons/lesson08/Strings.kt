package ru.stimmax.cotlincouse.lessons.lesson08

import ru.stimmax.cotlincouse.lessons.lesson06.homework06.example1

fun main() {
    val simpleString: String = "это простая строка" // объект это то, что мы представляем в виде данных

    // конкотинация строк - соединение строк
    val firstName = "Ivan"
    val lastName = "Ivanov"
    val fullName = firstName + " " + lastName // Ivan Ivanov
    println(fullName)

    // шаблоны строк
    val age = 30
    val greeting = "Привет! Меня зовут $fullName, и мне $age лет"
    println(greeting)

    class Person(val name: String, val age: Int)

    val person = Person("Alex", 30)
    val introduction = "Меня зовут ${person.name}, и мне ${person.age} лет"
    println(introduction)

    // выполнение произвольного кода в шаблонах
    fun getDetails(): String {
        return "очень интересные детали"
    }
    val details = "Здесь находятся ${getDetails()}"
    println(details)

    val x = 10
    val y = 20
    val resultString = "Результат сложения х и у = ${x + y}"
    println(resultString)

    // манипуляции
    val originalString = "Kotlin is fun"
    val subString = originalString.substring(7) // метод возвращения подстроки(часть строки). Вернет подстроку начиная с 7 индекса is fun
    val subString2 = originalString.substring(3,6)// 3 - индекс начала, включается в вывод. 6 - индекс конца, не вкл в вывод - lin

    val replacedString = originalString.replace("fun", "awesome")// медод замены. Принимает старое значение fun и меняет его на awesome Kotlin is awesome
    println(replacedString)

    val words = originalString.split(" ") // разделяет строку на список(массив) строк. В качестве разделителя выступает " " - пробел
    // получим "Kotlin" "is" "fun"
    println(words)

    val length = "Hello".length // длинна строки - кол-во символов строки - 5

    val upper = "hello".uppercase() // "HELLO" - переводит все в верхний регистр
    val lower = "HELLO".lowercase() // hello - переводит все в нижний регистр

    val trimmed = "   hello bro    ".trim() // "hello" - метод очистки строк от ненужных пробелов.
    println(trimmed)

    val starts = "Kotlin".startsWith("Kot",true)// проверяет начинается ли строка Kotlin с подстроки Kot - вернет true
    // в качестве второго аргумента true - передаем игнорирование регистра

    val ends = "Kotlin".endsWith("Lin", true) // проверяет заканчивается  ли строка Kotlin подстрокой Lin - вернет true т.к
    // в качестве второго аргумента true - передаем игнорирование регистра

    val contains = "Kotlin".contains("TLI", true)// проверяет входит ли подстрока TLI в строку Kotlin - вернет true т.к
    // в качестве второго аргумента true - передаем игнорирование регистра

    var s: String? = null
    val empty = s.isNullOrEmpty() // проверяет является ли строка нулл или пустая. Вернет тру. Так же вернет тру если бы было ""

    s = "  "
    val blank = s.isNullOrBlank() // проверяет является ли строка нулл или пустая c невидимыми пробелами . Вернет тру. Так же вернет тру если бы было " "


    val repeat = "ab".repeat(3)// повторяет строку столько раз сколько передали в аргументе в данном случае 3
    println(repeat)

    val letter = originalString[5] // обратились к строке по индексу 5, в данномм случе вернет 'n'. Вызвали метод гет
    println(letter)

    val indexOfChar = "Kotlin".indexOf('t')// поиск индекса по тексту результатом будет 2
    println(indexOfChar)

    val indexOfChar1 = "Kotlin".indexOf("li")// поиск индекса по тексту результатом будет 3
    println(indexOfChar1)

    val indexOfWord = "Kotlin is the best language".indexOf("bestt") // вернет -1 т.к не нашел фразу
    println(indexOfWord)

    val backReverse = "niltoK".reversed()// метод  который переворачивает строки - вернет Kotlin
    println(backReverse)

    val multiLineString = """ 
       Первая строка
       Вторая стока 
       Третья строка
    """.trimIndent() // многострочные строки trimIndent - отвечает за форматирование этого блока. Очищает многострочную строку от лишних символов
    println(multiLineString)

    // форматирование

    val name = "Alexei"
    val city = "Moscow"
    val age1 = 26
    val friendsCount = 32
    val rating = 4.948
    val balance = 2345.76748
    val text =  """
            Имя: %s 
            Город: %s
            Возраст: %d
            Количество друзей: %,d
            Рейтинг пользователя: %.1f
            Баланс счета: $%,.2f
    """.trimIndent()
    // %s - будет вставлено слово
    // %d - будет вставлено число
    // %,d - d- число, "," - разделитель, пробел. Выведем число с разделителем порядка
    // %.1f - дробное число  .1 - значит отформатировать до 1 знака после запятой
    // %,.2f - дробное число, с разделителем порядка, с 2 знаками после запятой
    println(text.format(name, city, age1, friendsCount, rating, balance))


    examples1("Ошибка в системе вызвала панику")
    examples1("Для завершения проекта важно")


}

fun examples1(text: String) {
    val result = when {
        text.startsWith("Ошибка", true) -> text.replace("Ошибка", "Небольшое недоразумение")
        text.endsWith("Важно", true) -> "$text ...но не критично."
        else -> text
    }
    println(result)
}