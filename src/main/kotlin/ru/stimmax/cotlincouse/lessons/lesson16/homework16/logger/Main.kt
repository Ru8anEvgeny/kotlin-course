package ru.stimmax.cotlincouse.lessons.lesson16.homework16.logger

fun main() {
    val logger = Logger()
    val exception = Exception("Техническая ошибка")
    logger.log("Тестовый лог")
    logger.log("WARNING", "Тестовый лог 2")
    logger.log("ERROR", "Тестовый лог 3")
    logger.log(listOf("logs4", "logs5", "logs6"))
    logger.log(exception)

}