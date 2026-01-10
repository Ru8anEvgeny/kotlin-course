package ru.stimmax.cotlincouse.lessons.lesson28

import java.time.*
import java.time.format.DateTimeFormatter

fun main() {
    // создаем текущую метку времени
    val instant = Instant.now()
    val instant1 = Instant.ofEpochSecond(-99999)
    println(instant1)

    // создать объект в котором записана дата дня знаний 2024
    val ex2 = LocalDate.of(2023,9,1)

    // создать дату последнего дня весны 25го года
    val ex3 = LocalDate.of(2025,5,31)

    // вычислить период между датами
    val ex4 = Period.between(ex2, ex3)
    println(ex4)

    // переменная в которой период из 2 лет 3 месяцев и 24 дней
    val ex5 = Period.of(2,3,24)
    println(ex3.plus(ex5))

    // создаем запись для календаря на ближайший понедельник
    val ex7 = LocalDate.of(2026, 1, 12)
    val ex8 = LocalTime.of(10,0)
    val ex9 = ZonedDateTime.of(ex7,ex8, ZoneId.of("Europe/Moscow"))

    // добавляем время к дате
    val ex10 = ex7.atTime(ex8).atZone(ZoneId.of("Europe/Moscow"))

    // добавляем к дате и времени добавим 11 дней и 5 часов
    val ex11 = ex10.plusDays(11L).plusHours(5L)

    // создадим форматер который будет выводить дату и время
    val ex12 = DateTimeFormatter.ofPattern("'Месяц 'MM' ,День' dd ', Время' HH:mm z")
    println(ex11.format(ex12))

}