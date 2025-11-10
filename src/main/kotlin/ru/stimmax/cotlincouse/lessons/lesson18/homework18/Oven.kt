package ru.stimmax.cotlincouse.lessons.lesson18.homework18
//Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью
// устанавливать температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка.
// Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
// Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы)
// не имеет смысла при выключенном питании - добавь эту проверк

class Oven(
    override val model: String,
    override val color: String,
    override val serialNumber: String
) : Equipment(model, color, serialNumber), AutomaticShutdown, Timable, LightEmitting  {
    private var onOrOff = false
    override fun powerOn() {
        onOrOff = true
        println("Включена")
    }

    override fun powerOff() {
        onOrOff = false
        println("Выключена")
    }

    override fun open() {
        println("Крышка духовки открыта")
    }

    override fun close() {
        println("Крышка духовки закрыта")
    }

    override val maxTemperature: Int = 200
    override fun setTemperature(temp: Int) {
        if (onOrOff) {
            println("Установлена температура $temp")
        } else {
            println("Сначала включите плиту")
        }
    }

    override fun programAction(action: String) {
        if (!onOrOff) {
            println("Сначала включите духовку")
        } else {
            println("Начата программа $action")
        }
    }


    override val sensorType: String = "Датчик"
    override val maxSensoredValue: Int = 240
    override fun startMonitoring() {
        println("Начат мониторинг")
    }

    override fun setTimer(time: Int) {
        println("Установлен таймер на $time минут")
    }

    override fun emitLight() {
        println("Включен свет в духовке")
    }

    override fun completeLiteEmission() {
        println("Свет в духовке отключен")
    }







}