package ru.stimmax.cotlincouse.lessons.lesson18

// интерфейс - контракт на то, что этот интерфейс должен выполнять. Заготовка из наборов полей и методов
// которые будут говорить что этот интерфейс будет нам предлагать реализовывать

interface Powerable {
    // абстрактные методы без реализации
    fun turnOn()
    fun turnOff()
}

//можно использовать компаньены для хранения констант
interface Device : Powerable {
    companion object {
        const val TYPE = "Device"
    }


    //Абстрактное сво-во(поле), которое должно быть переопределено в классе, реализующем интерфейс
    val deviceId: String

    // метод с реализацией, вызывающий приватный метод
    fun restart() {
        turnOff()
        logAction("Устройство с ИД $deviceId выключено для перезагрузки")
        turnOn()
        logAction("Устройство с ИД $deviceId включено")
    }

    // приватный метод с реализацией
    private fun logAction(action: String) {
        println("* Лог действия устройства: $action")

    }
}

abstract class HouseholdAppliance(
    val brand: String
) : Device {

    abstract val applianceType: String

    var isPoweredOn: Boolean = false
        private set

    abstract fun operate()

    override fun turnOn() {
        isPoweredOn = true
        onPowerChange()
    }

    override fun turnOff() {
        isPoweredOn = false
        onPowerChange()
    }

    private fun onPowerChange() {
        val state = if (isPoweredOn) {
            "включено"
        } else {
            "выключено"
        }
        println("Устройство '$applianceType $brand' $state")
    }

    protected open fun performMaintenance() {
        println("*** Секция обслуживания устройства ***")
    }
}

interface Programmable {

    fun selectProgram(preset: Int)

}

class Microwave(
    brand: String,
    serialNumber: String
) : HouseholdAppliance(brand), Programmable {

    private val programPreset = mapOf(
        1 to "warm up soup",
        2 to "warm up bread"
    )

    private var lastProgram = 1
    override val deviceId: String = serialNumber

    override val applianceType: String = "Микроволновая печь"

    override fun operate() {
        if (isPoweredOn) {
            invokeProgram()
            performMaintenance()
        } else {
            println("Микроволновая печь от $brand не включена. Включи ее")
        }
    }

    override fun performMaintenance() {
        super.performMaintenance()
        println("Чистка МК печи от $brand")
    }

    override fun selectProgram(preset: Int) {
        if (preset in  programPreset)
            lastProgram = preset
    }

    private fun invokeProgram() {
        println(programPreset[lastProgram])
    }

}

fun main() {
    val mw = Microwave("Samsung", "1234")
    println(mw.isPoweredOn)
    println(mw.deviceId)
    mw.turnOn()
    mw.operate()
    mw.restart()
    mw.operate()
    mw.turnOff()
}

fun turOff(list: List<Powerable>) { // функция которая принимает в себя список объектов, которые имплементировали у себя
    // Интерфейс Powerable
    list.forEach {
        it.turnOff()
    }
}