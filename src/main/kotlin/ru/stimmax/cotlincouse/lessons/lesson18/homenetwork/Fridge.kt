package ru.stimmax.cotlincouse.lessons.lesson18.homenetwork

//Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью
// устанавливать температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка.
// Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
// Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы)
// не имеет смысла при выключенном питании - добавь эту проверку.

class Fridge(
    val model: String,
    val color: String,
    val serialNumber: String
) : Equipment()  {

    private var isPoweredOn = false

    override fun powerOn() {
        super.powerOn()
        isPoweredOn = true
    }

    override fun powerOff() {
        super.powerOff()
        isPoweredOn = false
    }

    override val maxTemperature: Int = 12
    val mimTemperature: Int = 1

    override fun programAction(action: String) {
        if (isPoweredOn) {
            println("Программа $action запущена")
        } else {
            println("Сначала запустите устройство")
        }
    }

    override fun setTemperature(temp: Int) {
        if (temp > maxTemperature || temp < mimTemperature ) {
            println("Некорректная температура")
            return
        }

        if (isPoweredOn) {
            println("Установленная температура: $temp")
        } else {
            println("Сначала запустите устройство")
        }
    }

}

fun main() {
    val fridge = Fridge("Samsung", "blue", "1234")
    println(fridge.maxTemperature)
    println(fridge.mimTemperature)
    fridge.setTemperature(10)
    fridge.powerOn()
    fridge.open()
    fridge.setTemperature(13)
    fridge.setTemperature(10)
    fridge.programAction("Test")
    fridge.execute()
    fridge.close()
    fridge.powerOff()
}