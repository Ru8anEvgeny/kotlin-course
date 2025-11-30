package ru.stimmax.cotlincouse.lessons.lesson22

import java.io.IOException

//Исключения - объект который описывает исключительную ситуацию возникшую в программе. Сигнал о том, что что-то пошло не так
// Обработка исключений - механизм который позволяет перехватить исключительную ситуацию и что-то с ней сделать
// Например залогировать ошибку


fun main() {
    // throw - специальный оператор что бы выбросить исключение. В него передаем объект Exception. В котором прописываем
    // сообщение которое хотим вывести
    //throw Exception("Сообщение об ошибке")
////
////    throw Error("") // ошибки связанные с проблемами виртуальной машины джавы при исполнении кода
////    OutOfMemoryError()// выбрасывается в случае когда переполнена память выделенная для работы нашей программы
////    StackOverflowError()// системный тип ошибки который возникает из за того, что перевыполняется используемый стек вызова функции
////
////
////    // Exception - такой тип исключений которые должны быть перехвачены залогированны и обработаны
////    Exception()
////
////    //IOException - импут аутед эксепшн - исключения связанные с вводом/выводом данных. Типа чтение данных с диска
////    IOException()
////
////    //RuntimeException - исключение времени выполнения. Например вышли за пределы диапазона списка
////    RuntimeException()
//
//    val exception = Exception("Возникла ошибка")
//    throw exception

    //Как происходит перехват исключения
    try {
        // код, который может выбросить исключения
        arrayOf("1")[2] // Написали неработающий код. Дальше он не будет выполняться. Дальше начнется перебор блоков catch
    } catch (e: IndexOutOfBoundsException) {
        // Обработка конкретного типа исключения
        // Берем тип исключения который появился в блоке try и сравниваем с типом IndexOutOfBoundsException
        // если типы совпадут то будет выпоняться этот код. Если нет то пойдем в следующий блок catch
        e.message
    } catch (e: Exception) {
        // Обработка всех остальных исключений
        println(e)
        throw e
    } finally {
        // Блок, который выполняется всегда, независимо от наличия исключения
        println("Выполняется в любом случае")
    }

    // Можно делать так
    try {
        // Код, который может выбросить исключение
    } catch (e: Exception) {
        when(e) {
            is IndexOutOfBoundsException, is NullPointerException -> {
                CustomException(e)
                println("Обработано исключение типа IndexOutOfBoundsException")
            }
            is RuntimeException -> {
                println("Обработано исключение типа RuntimeException")
            }
            else -> throw e // Перебрасываем исключение дальше, если оно не соответствует обработанным типам
        }
    }

    throw OrderException("Наш созданный тип исключения")
}

// Можем создавать собственные типы исключения
class OrderException(message: String) : RuntimeException(message)
// Это просто класс который принимает какое-то сообщение и наследуется от какого либо типа Исключения

//пример использования
fun placeOrder(orderDetail: String) {
    if (orderDetail.isBlank()) {
        throw OrderException("Детали заказа не указаны")
    }
    //логика заказа
    println("Заказ оформлен: $orderDetail")
}


//Более полный набор аргументов для исключений
class CustomException : RuntimeException {
    // используя вторичный конструктор обратились через super к конструктору родительского класса
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(cause: Throwable) : super(cause)
}



