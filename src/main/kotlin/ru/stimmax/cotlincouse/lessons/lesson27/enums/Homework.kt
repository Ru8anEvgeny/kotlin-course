package ru.stimmax.cotlincouse.lessons.lesson27.enums

import ru.stimmax.cotlincouse.lessons.lesson27.homework27.RealEstate

//Создай Enum со статусами прохождения теста (passed, broken, failed).

enum class TestStatus(){
    PASSED,
    BROKEN,
    FILED,
    ;
    fun testStatus(status: TestStatus) {
        when(status){
            PASSED -> "passed"
            BROKEN -> "broken"
            FILED -> "filed"
        }.apply {
            println(this)
        }
    }

    //Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения и возвращает Enum
//со статусом прохождения теста в зависимости от того как выполнится принятая лямбда:
    //если без исключений - PASSED
    //если будет AssertionError - FAILED
    //прочие исключения  - BROKEN

    companion object{
        fun ex1(fun1: () -> Unit): TestStatus {
            return try {
                fun1()
                TestStatus.PASSED
            } catch(e: AssertionError) {
                TestStatus.BROKEN
            }
            catch (e: Throwable) {
                TestStatus.FILED
            }

        }
    }
}
//Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.
enum class ResidentialPropertyType(val type: String) {
    APARTMENT("Апартаменты"),
    HOUSE("Дом"),
    TOWNHOUSE("Таунхаус"),
    ROOM("Комната"),
    STUDIO("Студия"),
    ;
    //Создай функцию, которая выводит на печать человекочитаемые названия типов недвижимости в порядке
// возрастания длины названия enum.
    companion object {
        fun print() {
            entries
                .sortedBy { it.name.length }
                .forEach { println(it.type) }
        }
    }
}






//Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и
// вес планеты.
enum class Planet(
    val distanceAu: Double,   // расстояние до Солнца в а.е.
    val massKg: Double        // масса в кг
) {
    MERCURY(0.39, 3.30e23),
    VENUS(0.72, 4.87e24),
    EARTH(1.00, 5.97e24),
    MARS(1.52, 6.42e23),
    JUPITER(5.20, 1.90e27),
    SATURN(9.58, 5.68e26),
    URANUS(19.20, 8.68e25),
    NEPTUNE(30.05, 1.02e26)
    ;
    //Создай функцию, которая принимает лямбду и возвращает enum планеты. Лямбда должна принимать
// планету и возвращать булево значение. Лямбда здесь выступает в качестве фильтра, который должен
// отфильтровать список всех планет по какому-либо признаку (расстояние или вес). Вернуть нужно первый
// элемент из отфильтрованного списка или выкинуть исключение если список пустой.
    companion object {
        fun ex2(fun2: (Planet) -> Boolean): Planet {
            return Planet.entries
                .firstOrNull(fun2)
                ?: throw RuntimeException("Подходящей планеты не найдено")
        }
    }
}
