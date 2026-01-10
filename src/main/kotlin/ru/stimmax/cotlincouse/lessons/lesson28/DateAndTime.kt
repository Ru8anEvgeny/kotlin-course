package ru.stimmax.cotlincouse.lessons.lesson28

import java.time.*
import java.time.format.DateTimeFormatter

fun main() {
    val instant = Instant.now() // Instant класс который предоставляет возможность хранения даты
    // в виде количества секунд относительно эпохи юникс - 00.00 1го января 1970 года - точка отсчета

    println(instant.epochSecond)

    val dateTimeNow = LocalDate.now()// LocalDate класс который хранит только дату - год, месяц и число
    val birthday = LocalDate.of(1983,10,2)

    val localTime = LocalTime.now() // LocalTime класс для работы со временем
    val endOfMyWorkingDay = LocalTime.of(18, 0, 0)

    val localDateTime = LocalDateTime.now() // LocalDateTime класс для работы со временем и датами
    val alarmClock = LocalDateTime.of(2024,4,1,9,0,0)

    // класс ZoneDateTime - позволяет хранить время дату и часовой пояс
    val vaticanCurrentTime = ZonedDateTime.now(ZoneId.of("Europe/Vatican"))
    val mobileWorldCongress = ZonedDateTime.of(
        2024,
        2,
        26,
        10,
        0,
        0,
        0,
        ZoneId.of("Europe/Madrid")
    )

    // класс OffsetDateTime - смещение на offsetId
    val birthDayInDubai = OffsetDateTime.of(birthday.atTime(19,0,3),ZoneOffset.of("+09:00"))

    //Можно преобразовывать между собой типы Instant, ZonedDateTime и OffsetDateTime
    val vaticanCurrentTimeInstant = vaticanCurrentTime.toInstant()
    val birthdayInstant = birthday.atTime(19, 0).toInstant(ZoneOffset.of("+09:00"))
    val instantToZonedDateTime = instant.atZone(ZoneId.systemDefault())
    val instantToOffsetDateTime = instant.atOffset(ZoneOffset.of("-02:00"))

    //Методы для работы с датами
    //Прибавление к дате
    //Год:
    LocalDate.now().plusYears(1) // Добавить один год к текущей дате
    //Секунда:
    LocalDateTime.now().plusSeconds(1) // Добавить одну секунду к текущей дате и времени

    //Вычитание из даты
    //Год:
    LocalDate.now().minusYears(1) // Вычесть один год из текущей даты
    //Секунда:
    LocalDateTime.now().minusSeconds(1) // Вычесть одну секунду из текущей даты и времени

    //Получение разницы между датами или временем

    //Duration.between(startDateTime, endDateTime) // Получить разницу между двумя моментами времени в часах, минутах и секундах

    val nanoSeconds = Duration.ofNanos(200)
    println(nanoSeconds.dividedBy(4).toNanos())
    println(nanoSeconds.plus(Duration.ofSeconds(2)).toNanos())
    val seconds = Duration.ofSeconds(45)
    println(seconds.minusMinutes(1).seconds)

    //Period.between(startDate, endDate) // Получить разницу между двумя датами в годах, месяцах и днях
    val period = Period.of(2, 4, 10)
    println(period.minusMonths(13).toTotalMonths())
    val periodFromConferenceToBirthday = Period.between(mobileWorldCongress.toLocalDate(), birthday)
    println("${periodFromConferenceToBirthday.years} лет ${periodFromConferenceToBirthday.months} месяцев ${periodFromConferenceToBirthday.days} дней")


    val formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS ZZZ z")

    println(instantToZonedDateTime.format(formatters))

    val isoFormatters = DateTimeFormatter.ISO_DATE_TIME


    val prettyFormatters = DateTimeFormatter.ofPattern("'год' yyyy', месяц' MM', день' dd")
    val prettyFormattedDates = dateTimeNow.format(prettyFormatters)
    println(prettyFormattedDates)
    val parsedDate = LocalDate.parse(prettyFormattedDates, prettyFormatters)
    println(parsedDate)


//Форматирование дат в Kotlin с использованием DateTimeFormatter
//Основные шаблоны форматирования:
//yyyy: год четырьмя цифрами
//MM: месяц двумя цифрами (01 - Январь, 12 - Декабрь)
//MMM: месяц сокращённо (янв., фев. и т.д.)
//MMMM: месяц полностью
//dd: день месяца двумя цифрами
//HH: часы в 24-часовом формате
//mm: минуты
//ss: секунды
//SSS: миллисекунды
//ZZZ: часовой пояс в формате +HHmm или -HHmm
//z: текстовое название часового пояса
//'текст': литералы, которые будут выводиться как есть
//Примеры форматирования:

val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS ZZZ")
val formattedDate = vaticanCurrentTime.format(formatter)
println("Текущая дата и время с миллисекундами и часовым поясом: $formattedDate")
val isoFormatter = DateTimeFormatter.ISO_DATE_TIME
val isoFormattedDate = birthDayInDubai.format(isoFormatter)
println(isoFormattedDate)
val prettyFormatter = DateTimeFormatter.ofPattern("'год' yyyy', месяц' MM', день' dd")
val prettyFormattedDate = dateTimeNow.format(prettyFormatter)
println(prettyFormattedDate)
try {
   println("При форматировании с часовым поясом помни, что в LocalDateTime его нет и будет ошибка ${localDateTime.format(formatter)}")
} catch (e: Throwable) {
   e.printStackTrace()
}
try {
   println("При форматировании LocalDate помни, что нет полей времени и будет ошибка ${birthday.format(formatter)}")
} catch (e: Throwable) {
   e.printStackTrace()
}




}