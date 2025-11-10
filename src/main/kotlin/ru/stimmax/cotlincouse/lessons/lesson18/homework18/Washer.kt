package ru.stimmax.cotlincouse.lessons.lesson18.homework18


//Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью
// устанавливать температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка.
// Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
// Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы)
// не имеет смысла при выключенном питании - добавь эту проверку.
class Washer (
    override val model: String,
    override val color: String,
    override val serialNumber: String
) : Equipment(model, color, serialNumber), WaterConnection, Drainable, Timable {

    private var onOrOff = false
    override fun powerOn() {
        onOrOff = true
        println("Машина включена")
    }

    override fun powerOff() {
        onOrOff = false
        println("Стиральная машина выключена")
    }

    override fun open() {
        println("Дверь машинки открыта")
    }

    override fun close() {
        println("Дверь машинки закрыта")
    }

    override val maxTemperature: Int = 90
    override fun setTemperature(temp: Int) {
        if (!onOrOff) {
            println("Сначала включите машинку")
        } else {
            println("Установлена температура $temp")
        }
    }

    override fun programAction(action: String) {
        if (!onOrOff) {
            println("Сначала включите машинку")
        } else {
            println("Программа $action запущена")
        }
    }

    override fun execute() {
        println("Программа выполнена")
    }

    override fun connectToWaterSupply() {
        println("Подключена подача воды")
    }

    override fun getWater(amount: Int) {
        println("Уровень воды $amount")
    }

    override fun connectToDrain() {
        println("Подключен дренаж")
    }

    override fun drain() {
        println("слив")
    }

    override fun setTimer(time: Int) {
        println("Установлен таймер $time")
    }










}