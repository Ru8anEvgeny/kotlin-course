package ru.stimmax.cotlincouse.lessons.lesson18

import java.io.InputStream

interface Powerables {
    fun turnOn()
    fun turnOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}
interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}
interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}
interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}
interface Drainable {
    fun connectToDrain()
    fun drain()
}
interface Timable {
    fun setTimer(time: Int)
}
interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}
interface Mechanical {
    fun performMechanicalAction()
}
interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}
interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}
interface Programmables {
    fun programAction(action: String)
    fun execute()
}
interface Movable {
    fun move(direction: String, distance: Int)
}
interface Cleanable {
    fun clean()
}
interface Rechargeable {
    fun getCapacity(): Double
    fun recharge()
}


abstract class Teapot() : Powerables, Openable, WaterContainer, AutomaticShutdown {}

abstract class VacuumCleaner : Powerables, Cleanable

abstract class PortativeColumn : Powerables, SoundEmitting, Timable, Rechargeable

abstract class Oven : Powerables, TemperatureRegulatable, Openable, Timable


fun listOpenable(list: List<Openable>) {
    list.forEach {
        it.close()
    }
}