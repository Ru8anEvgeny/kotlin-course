package ru.stimmax.cotlincouse.lessons.lesson24

import kotlin.random.Random

// Функции высшего порядка - функции которые могут принимать другие функции в качестве аргументов
// или возвращать их в качестве результата

// Для чего нужны?
// Нужны для создания программ которые легко адаптировать под различные задачи без необходимости
// изменения их исходного кода. Они позволяют:
// Повторения использования кода - общие задачи такие как операции над коллекциями можно реализовать
// один раз и использовать в различных контекстах

// Создание абстракций - позволяют абстрагироваться от конкретных деталей реализации, сосредоточиваясь
// на более высокоуровневых операциях

// гибкость и масштаб - легко добавлять новое поведение или изменять существующее, не требуя изменений
// в основной структуре программы

// Что решают:
//1. Декомпозиция задач - разделение большой задачи на мелкие, управляемые части

// Пример - рассмотрим процес создания транспортного средства и его базовых аспектов - источник ресурса,
// двигатель, преобразователь в движение

// Источник ресурса Е(Топливо, электричество, корм и тд..)
// Создали интерфейс источника ресурсов с типом дженерика Е, который реализует метод
// provide - который ничего не принимает, но возвращает дженерик Е
fun interface EnergySource<E> {
    fun provide(): E
}

// Создаем двигатель. Он берет ресурс Е и преобразовывает ее в двигательную мощность Р
// Создали интерфейс двигателя с типом дженериков E, P. И функцию генерации generate
// которая принимает в себя источник ресурса E и его кол-во quantity и возвращает двигательную мощность Р
fun interface PowerUnit<E, P> {
    fun generate(input: E, quantity: Double): P
}

// Создадим интерфейс который будет преобразовывать двигательную мощность в движение М
// Принимаем P - двигательная мощность, возвращаем M - движение
fun interface MotionSystem<P, M> {
    fun move(input: P): M
}

//Теперь создадим абстрактный класс транспортного средства
// в конструкторе говорим, что у класса есть поля
abstract class Vehicle<E, P, M> (
    private val energySource: EnergySource<E>,// с типом интерфейса - источник ресурса
    private val powerUnit: PowerUnit<E, P>, // двигатель
    private val motionSystem: MotionSystem<P, M> // движение на выходе
) {
    // у класса есть метод реализации движения
    fun performMove(powerQuantity: Double): M {
        val energy: E = energySource.provide()
        val power: P = powerUnit.generate(energy, powerQuantity)
        return motionSystem.move(power)
    }
}
// В этом примере используются функциональные интерфейсы - основы функционального программирования.
// Функциональные интерфейсы выделяются наличием единственной функции. Таким образом каждая такая
// абстракция ответственна только за 1 аспект.

// Класс Vehicle - Принимает набор функциональных интерфейсов и способен произвести движение вне зависимости
// от того на чем оно основано.


// Примитивный пример реализации интерфейсов.
// Создали класс StringEnergy который наследуется от EnergySource. Дженерик определили как стринг
class StringEnergy() : EnergySource<String> {
    // т.к наследуемся от интерфейса необходимо реализовать метод provide
    override fun provide(): String = "Топливо"
}

// Создадим класс DoublePower - наследуется от интерфейса PowerUnit
class DoublePower() : PowerUnit<String, Double> {
    override fun generate(input: String, quantity: Double): Double {
        return input.map { it.code / 2.0 }.sum() * quantity // code - возващает Unicode символа
    }
}

// Создадим класс, который будет преобразовывать движущую инергию в движение
class IntMotion() : MotionSystem<Double, Int> {
    override fun move(input: Double): Int {
        return input.toInt() / 2
    }
}

// Создадим класс транспортного средства
class StringIntMobil() : Vehicle<String, Double, Int> (
    StringEnergy(),
    DoublePower(),
    IntMotion()
)


// Функциональное программирование начинается там где в качестве аргументов классов или фунций
// передаются не типичные объекты а другие функции. Тут на помощь приходят ссылочные способы передачи
// функций и лямбда выражения.

// Рассмотрим вариант с тем же автомобилем, но теперь вместо контрактов(интерфейсов) сразу
// укажем сигнатуру необходимых функций через лямбда тип

abstract class LambdaVehicle<E, P, M> (
    private val energySource: () -> E,
    private val powerUnit: (E, Double) -> P,
    private val motionSystem: (P) -> M
) {
    fun performMove(sourceQuantity: Double): M {
        val energy: E = energySource()
        val power: P = powerUnit(energy, sourceQuantity)
        return motionSystem(power)
    }
}

//:: - это способ передачи функции в виде ссылки. Т.е тут не происходит вызов функции, она
// в этот момент не выполняется. Тут мы сообщаем компилятору,
// что в качестве аргумента нужно использовать вот это название функции.
class LambdaInterfaceStringIntMobil : LambdaVehicle<String, Double, Int> (
    StringEnergy()::provide,
    DoublePower()::generate,
    IntMotion()::move
)

// Рассмотрим способ написания кода функций непосредственно в виде аргументов класса
class LambdaStringIntMobil : LambdaVehicle<String, Double, Int> (
    {"Бензин"},
    {energy, sourceQuantity -> energy.map { it.code / 2.0}.sum() * sourceQuantity},
    {it.toInt() / 2}
)
//В этом подходе мы вообще не используем никакие интерфейсы, мы сразу пишем блок кода анонимных
// функций в конструктор класса. В случае с несложным кодом это становится очень выгодным и
// удобным решением.


// Параметризация поведения
//означает возможность изменения поведения функции во время выполнения программы,
// передавая в неё различные аргументы

//пример с параметризацией топлива для нашего класса
class LambdaStringIntMobileParm(energySource: () -> String) : LambdaVehicle<String, Double, Int>(
    energySource,
    { energy, sourceQuantity -> energy.map { it.code / 2.0 }.sum() * sourceQuantity },
    { it.toInt() / 2 }
)

// тут мы переносим energySource в конструктор основного класса таким образом позволяем
// внешнему пользователю предоставлять любое топливо подходящего типа через функцию, а не объект.


//Передача функции в качестве аргумента
//Рассмотрим пример преобразования символов строки
fun String.charTransform(transformation: (Char) -> Char): String {
    return map(transformation).joinToString("")
}

fun main() {
    val parameterizedAuto = LambdaStringIntMobileParm{Random.nextFloat().toString()}
    val result = "my text".charTransform { it.uppercaseChar() }
    println(result)
    val result2 = "my text".charTransform { it + 1 }
    println(result2)
}






