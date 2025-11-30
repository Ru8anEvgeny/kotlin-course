package ru.stimmax.cotlincouse.lessons.lesson23

fun increment(a: Int): Int {
    return a + 1
}

fun main() {
    //анонимная функция
    // Теперь у нас существует переменная которая хранит функцию
    val increment1 = fun (a: Int): Int {
        return a + 1
    }
    // лямбда выражение. Если возвращаемого типа нет то после -> указаваем Unit
    val increment: (a: Int) -> Int = {a -> // (Int) -> Int - указали в качестве типа лямбда тип
        //(Int) -> Int - тут (Int) это скобки которые задаются если функция принимает аргумент. -> это по сути :
        //
        //a -> a + 1 - присвоили блок кода. a - задали переменную, это
        a + 1
    }

    // можем не указывать после = в блоке кода а ->. Вместо этого использоваться it
    // it в таком случае будет равно а. Но такое если агумент принимаемый только 1
    val increment2: (a: Int) -> Int = {
        it + 1
    }

    val result = increment2(8)// 9
    val result1 = increment2(10) // 11

    // Отличие лямбда выражений от анонимных и обычных функций в том, что в лямбда не используем return
    // В лябмда последняя строка будет считаться за результат выпонения функции

    println(increment(2))
    println(increment1(3))

    // Лямбда выражения это сокращенная форма записи анонимных функций

    // еще 1 вариант объявления лямбда выражений когда не указываем тип
    val increment3 = { a: Int ->
        a + 1
    }

    // преобразуем функцию findIndex в анонимную. В анонимных функциях значение по умолчанию задавать нельзя
    val findIndex = fun(text: String, word: String, ignoreCase: Boolean): Int {
        return text.indexOf(word, 0, ignoreCase)

    }
    // Преобразуем функцию findIndex в лямбда выражение
    val findIndex1: (String, String, Boolean) -> Int = {text, word, ignoreCase ->
        text.indexOf(word, 0, ignoreCase)
    }

    // следующий вариант когда не указываем типы аргументов
    val findIndex2 = {text: String, word: String, ignoreCase: Boolean ->
        text.indexOf(word, 0, ignoreCase)
    }

    //напишем анонимную функцию для функции OrderProcessor.calculateDeliveryTime
    val calculateDeliveryTime = fun OrderProcessor.(productId: Int): String {
        val deliveryTimeDays = when(productId) {
            in 1..100 -> 3
            else -> 5
        }
        return "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress"
    }

    // напишем лямбда выражение для функции OrderProcessor.calculateDeliveryTime
    // Лямбда с ресивером или с контекстом.
    val calculateDeliveryTime1: OrderProcessor.(Int) -> String = {
        val deliveryTimeDays = when(it) {
            in 1..100 -> 3
            else -> 5
        }
        "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress"
    }

    val op = OrderProcessor("My address")
    calculateDeliveryTime1(op, 34)

    op.calculateDeliveryTime1(34)



}

fun findIndex(text: String, word: String, ignoreCase: Boolean = false): Int {
    return text.indexOf(word, 0, ignoreCase)
}

// Расширение классов
fun String.qwe(d: Int) {

}

class OrderProcessor(val deliveryAddress: String )
// написали функцию расширение класса OrderProcessor
    fun OrderProcessor.calculateDeliveryTime(productId: Int): String {
        val deliveryTimeDays = when(productId) {
            in 1..100 -> 3
            else -> 5
        }
        return "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress"
    }
