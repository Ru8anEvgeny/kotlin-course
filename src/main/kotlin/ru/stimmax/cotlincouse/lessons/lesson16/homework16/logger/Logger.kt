package ru.stimmax.cotlincouse.lessons.lesson16.homework16.logger

import ru.stimmax.cotlincouse.lessons.lesson16.Background
import ru.stimmax.cotlincouse.lessons.lesson16.Colors

class Logger {


    fun log(message: String) {
        println("INFO: $message")
    }

    //Выполнить перегрузку метода log, который:
    //Принимает уровень логирования и сообщение.
    // Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на красном фоне.
    fun log(prefix: String, message: String) {
        when (prefix) {
            "WARNING" ->  println("${Colors.YELLOW}$prefix: $message")
            "ERROR" -> println("${Background.RED}${Colors.WHITE}$prefix: $message${Background.RESET}")
            else -> println("$prefix: $message")
        }
    }

    //Принимает список сообщений и все их выводит с уровнем INFO
    fun log(message: List<String>) {
        message.forEach { println("INFO: $it") }
    }

    // Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
    fun log(exception: Exception ) {
        println("ERROR: ${exception.message}")
    }







}