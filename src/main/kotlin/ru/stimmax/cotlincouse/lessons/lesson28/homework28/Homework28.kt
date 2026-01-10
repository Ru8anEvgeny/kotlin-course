package ru.stimmax.cotlincouse.lessons.lesson28.homework28

import java.lang.IllegalArgumentException
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.Period
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal

//1.Создай текущую метку времени и выведи её на печать (чтобы ещё раз запомнить название этого класса
fun main() {
    val instant = Instant.now()
    println(instant)

    //2. Создай дату своего дня рождения.
    val ex2 = LocalDate.of(1999,9,4)
    println(ex2)

    // 3. Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из
// этого периода.
    val ex3 = LocalDate.now()
    println(ex3)
    val exs3 = Period.between(ex2,ex3)
    println(exs3.years)

    // 4
    val a = LocalDate.now()
    val b = LocalTime.now()
    val c = LocalDateTime.now()
    val d = ZonedDateTime.now()
    val e = OffsetDateTime.now()
    val f = Instant.now()
//    println(customFormater(a))
//    println(customFormater(b))
//    println(customFormater(c))
//    println(customFormater(d))
    formater(e)
    //customFormater(f)
}

    //4. Создай функцию, которая принимает тип Temporal и выводит форматированное значение в зависимости от того,
// содержит ли аргумент время и часовой пояс. Temporal - это общий тип для разных классов даты-времени.
// В форматированном значении нужно выводить часы, минуты, секунды и таймзону, если они представлены в
// переданном объекте. Обработай в методе все типы дат, которые знаешь. Реализуй два варианта функции - с
// собственный форматированием и с форматами из ISO коллекции.
fun customFormater(arg: Temporal): String {
    val pattern = when(arg) {
        is LocalDate -> "dd-MM-yy" // число, год, месяц
        is LocalTime -> "HH:mm:ss" // часы, минусы, секунды
        is LocalDateTime -> "dd-MM-yy HH:mm:ss" // число, год, месяц, часы, минуты, секунды
        is ZonedDateTime -> "dd-MM-yy HH:mm:ss z" // z для зоны (e.g., "MSK")
        is OffsetDateTime -> "dd.MM.yy HH:mm:ss.SSS XXX"
        //is Instant -> "yyyy-MM-dd'T'HH:mm:ss'Z'"  // UTC Instant
        else -> throw IllegalArgumentException("Неизвестный тип данных")
    }
        return DateTimeFormatter.ofPattern(pattern).format(arg)

}

fun formater(arg: Temporal) {
     when(arg) {
        is LocalDate -> arg.format(DateTimeFormatter.ISO_LOCAL_DATE)
        is LocalTime -> arg.format(DateTimeFormatter.ISO_LOCAL_TIME)
        is LocalDateTime -> arg.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        is ZonedDateTime -> arg.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
        is OffsetDateTime -> arg.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        else -> throw IllegalArgumentException("Неизвестный тип данных")
    }.also { println(arg) }
}