package ru.stimmax.cotlincouse.lessons.lesson17.homework17

class GameAutomatic( // игровой автомат
    val color: String, // цвет
    val model: String, // модель
    val hasJoystick: Boolean// наличие джостика

) {
    private val owner: String = "" // владелец
    private var included = false // включен ли игровой автомат
    private var osIsLoaded = false // Ос загружена
    private val costOfOneGame: Double = 11.5 // стоимость 1 игрового сеанса

    private var listGame = mutableListOf<String>(
        "Game1",
        "Game2",
        "Game3"
    ) // список установленных игр

    private val pinCode: String = "0000"  // пин код автомата

    private var totalRevenue = 0.0 // баланс вырученных средств
    val supportPhone = "+7111-111-11-11"// телефон поддержки
    var isSessionPaid = false // оплачена ли сессия за игру


    fun isOn() { // метод включения. Включили автомат и загрузили ОС
        included = true
        loadOS()
    }

    fun isOff() { // метод выключения. Выключаем автомат и завершаем работу ОС
        included = false
        shutdown()
    }

    private fun loadOS() { // функция загрузки ОС
        osIsLoaded = true
    }

    private fun shutdown() { // функция завершения работы ОС
        osIsLoaded = false
    }

    fun showGameList(): List<String> { // функция - показать список игр
        return listGame.toList()

    }

    fun playGame(nameGame: String) { // функция запуска игры
        if (!isSessionPaid) {
            println("Оплатите игру")
            return
        }
        if (nameGame in showGameList()) {
            println("Игра $nameGame запущена")
        } else {
            println("Игра $nameGame не найдена")
        }
    }

    fun payGame(amount: Double) { // оплата игры
        if (amount == costOfOneGame) {
            totalRevenue += amount
            isSessionPaid = true
        } else if (amount > costOfOneGame) {
            val ost = amount - costOfOneGame
            totalRevenue += costOfOneGame
            isSessionPaid = true
            println("Заберите сдачу: $ost")
        } else {
            isSessionPaid = false
            println("Недостаточно средств")
        }
    }

    fun withdrawCashWithPin(pinCode: String): Double { // забрать наличные с помощью пин-кода
        if (this.pinCode == pinCode) {
            return openSafe()
        } else {
            println("Пин неверный")
            return 0.0
        }
    }

    private fun openSafe(): Double { // открыть сейф и выдать наличные
        val result = totalRevenue
        totalRevenue = 0.0
        return result
    }


}