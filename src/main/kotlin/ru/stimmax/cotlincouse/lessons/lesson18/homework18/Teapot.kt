package ru.stimmax.cotlincouse.lessons.lesson18.homework18
//Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью
// устанавливать температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка.
// Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
// Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы)
// не имеет смысла при выключенном питании - добавь эту проверку.
class Teapot(
    override val model: String,
    override val color: String,
    override val serialNumber: String

) : Equipment(model, color, serialNumber), AutomaticShutdown  {

    private var onOrOff = false
    override fun powerOn() {
        onOrOff = true
        println("Включен")

    }

    override fun powerOff() {
        onOrOff = false
        println("Выключен")
    }

    override val maxTemperature: Int = 100
    override fun setTemperature(temp: Int) {
        if (!onOrOff) {
            println("Сначала включите чайник")
        } else {
            println("Задана температура $temp")
        }
    }

    override fun programAction(action: String) {
        if (!onOrOff) {
            println("Сначала включите чайник")
        } else {
            println("Задана программа $action")
        }
    }

    override fun execute() {
        println("Программа выполнена")
    }

    override val maxSensoredValue: Int = 100
    override val sensorType: String = "Test"
    override fun startMonitoring() {
        println("Начать мониторинг")
    }





}