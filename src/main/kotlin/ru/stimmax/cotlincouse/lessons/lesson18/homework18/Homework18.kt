package ru.stimmax.cotlincouse.lessons.lesson18.homework18

import java.io.InputStream

interface Powerable {// включить устройство
    fun powerOn() // включить
    fun powerOff() // выключить
}

interface Openable { // открыть
    fun open() // открыть крышку
    fun close() // закрыть крышку
}

interface WaterContainer { // Контейнер для воды
    val capacity: Int // вместимость
    fun fillWater(amount: Int) // заполнить водой
    fun getWater(amount: Int) //Получить воду
}

interface TemperatureRegulatable { // регулировать температуру
    val maxTemperature: Int // максимальная температура
    fun setTemperature(temp: Int) // установить температуру
}

interface WaterConnection { // Подключение к водопроводу
    fun connectToWaterSupply() // подключить подачу воды
    fun getWater(amount: Int) // получить воду
}

interface AutomaticShutdown { //Автоматическое отключение
    val sensorType: String //Тип датчика
    val maxSensoredValue: Int // максимальное значение датчика
    fun startMonitoring() // начать мониторинг
}

interface Drainable { // Поддающийся дренированию
    fun connectToDrain() // подключить дренаж
    fun drain() // слив
}

interface Timable { // время
    fun setTimer(time: Int) // установить таймер
}

interface BatteryOperated { // работа батареи
    fun getCapacity(): Double // получить емкость батареи
    fun replaceBattery() // заменить батарею
}

interface Mechanical { // механический
    fun performMechanicalAction() //Выполните механическое действие
}

interface LightEmitting { // излучающий свет
    fun emitLight() // излучать свет
    fun completeLiteEmission() // прекратить излучать свет
}

interface SoundEmitting { // издающий звук
    fun setVolume(volume: Int) // установить громкость
    fun mute() // беззвучный
    fun playSound(stream: InputStream) // проигрывать звук
}

interface Programmable { // программируемый
    fun programAction(action: String) // начать программу
    fun execute() // завершить программу
}

interface Movable { // движимый
    fun move(direction: String, distance: Int) // двигать
}

interface Cleanable { // очищаемый
    fun clean() // очистить
}

interface Rechargeable { // Перезаряжаемый
    fun getChargeLevel(): Double // получить уровень заряда
    fun recharge() // перезаряжать
}

//Задача 1. Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.

abstract class Fridge1 : Powerable, Openable, TemperatureRegulatable
abstract class Washers : Powerable, Openable, TemperatureRegulatable, WaterConnection, AutomaticShutdown, Drainable, Timable, Programmable
abstract class Lamp : Powerable, BatteryOperated, LightEmitting
abstract class ElectronicWatches : Powerable, Rechargeable
abstract class RobotVacuumCleaner : Powerable, Openable, AutomaticShutdown, Timable, Programmable, Movable, Cleanable, Rechargeable
abstract class MechanicalWatches : Powerable, BatteryOperated, Mechanical
abstract class Lantern : Powerable, BatteryOperated, LightEmitting
abstract class CoffeeMachine : Powerable, Openable, WaterContainer, AutomaticShutdown, Timable, Programmable, Cleanable
abstract class SmartSpeaker : Powerable, SoundEmitting, Programmable, Rechargeable

//Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией методов
// (достаточно println с выполняемым действием).

abstract class IncludedEquipment : Powerable {
    override fun powerOff() {
        println("Выключено")
    }

    override fun powerOn() {
        println("Включено")
    }
}

//Задача 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса и реализацией методов) и
// наследуй его от абстрактного класса включаемого оборудования.

abstract class ProgrammableHardware : IncludedEquipment(), Programmable {
    override fun programAction(action: String) {
        println("Программа $action запущена")
    }

    override fun execute() {
        println("Завершение работы программы")
    }
}

// Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и с
// наследованием от программируемого оборудования. Также имплементируй интерфейсы.

abstract class Equipment(
    open val model: String,
    open val color: String,
    open val serialNumber: String
) : ProgrammableHardware(), Openable, TemperatureRegulatable {

    override fun open() {
        println("Крышка открыта")
    }

    override fun close() {
        println("Крышка закрыта")
    }

    override fun setTemperature(temp: Int) {
        println("Установленная температура: $temp")
    }




}





