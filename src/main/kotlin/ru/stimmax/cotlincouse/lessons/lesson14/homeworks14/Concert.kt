package ru.stimmax.cotlincouse.lessons.lesson14.homeworks14

//Мероприятие: концерт. Создайте класс, который будет представлять концерт.
// У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”.
// Также приватное поле “проданные билеты”. Добавьте метод, который выводит информацию о концерте и
// метод “купить билет”, который увеличивает количество проданных билетов на один.

class Concert(val group: String, val location: String, val price: Double, val capacity: Int, private var ticketSold: Int ) {
    fun details() {
        println("""
            Концерт группы $group 
            Пройдет в  локации $location.
            Цена билетов: $price, 
            Макс кол-во человек: $capacity
            Кол-во проданных билетов: $ticketSold
        """.trimIndent())
    }

    fun buyTicket(){
        ticketSold++
    }




}