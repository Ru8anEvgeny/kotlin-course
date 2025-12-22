package ru.stimmax.cotlincouse.lessons.lesson25.homework25
//Задание 1. Функция высшего порядка.
//Создайте функцию timeTracker, которая принимает другую функцию в качестве аргумента и измеряет время
// её выполнения. Функция timeTracker должна возвращать затраченное время в миллисекундах.
// Для измерения времени используйте System.currentTimeMillis() до и после выполнения переданной функции.

fun timeTracker(fun1: () -> Any): Long {
    val time = System.currentTimeMillis() // время начала работы функции
    fun1()// выполняем вложенную функцию
    return System.currentTimeMillis() - time // возвращаем время затраченное на выполнение - время начала
}


//Задания для работы со scope функциями
//Давайте создадим два класса, которые будут использоваться в заданиях для демонстрации работы
// scope функций с преобразованием объектов и инициализацией или обновлением полей.
// Классы будут представлять собой Person и Employee, где Employee может быть создан на основе данных
// класса Person.

class Person(val name: String, val age: Int) {
    var email: String = ""
}

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}


//Задание 3: Использование also для логирования
//Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом,
// отформатированном виде. Используй with для создания контекста Person и возможности использовать
// поля объекта напрямую без обращения к переменной.
fun ex3(person: Person){
    with(person) {
        println("""
            Name: $name
            AGE: $age
            Email: $email
        """.trimIndent())
    }
}





//Задание 2: Использование apply для инициализации объекта Employee
//Создайте объект Employee и используйте apply для инициализации его полей email и department.
fun main() {
    val employees = Employee("Evgeny", 26, "QA")
    employees.apply {
        email = "rub.@weww.com"
        department = "Qa Lid"
    }


    //3
    val persons = Person("Evgeny", 26).also {
        it.email = "Evgeny@ya.com"
        ex3(it)
    }
    //Задание 4: Использование with для преобразование Person в Employee
//Создайте объект класса Person. Используйте функцию with, чтобы создать из этого объекта Employee,
// указав дополнительно должность. Возвращаемым значением должен быть новый объект Employee.

    val person = Person("Petya", 57).apply {
        email = "123@123"
    }

    val employee = with(person) {
        Employee(name, age, "Дворник" ).also {
            it.email = email
            it.department = "dep2"
        }
    }
//Задание 5: Использование run для преобразования и инициализации Employee
//Перепиши предыдущую задачу на использование run вместо with.

    val person1 = Person("Arnold", 30).apply {
        email = "arnold@S.aa"
    }

    val employee1 = person1.run {
        Employee(name, age, "Качек").also {
            it.email = email
            it.department = "Спортик"
        }

    }

    employee1.run {
        println("""
            Name: $name
            Age: $age
            Position: $position
            Email: $email
            Depart: $department
        """.trimIndent())

    }

}

// Использование let для безопасного преобразования Person в Employee
//Создайте функцию toEmployee, которая расширяет класс Person, который может быть null.
// В функции используйте функцию let для создания Employee, только если объект Person не null.
// В противном случае возвращается null

fun Person?.toEmployee(): Employee? {
   return this?.let {
       Employee(it.name, it.age, "Начальник Квадробер").apply {
           email = it.email
           department = "Отдел Квадроберов"
       }
    }
}






















//
//fun main() {
//
//    val myFunction = {
//        val list = List(10000000) { (0..10000).random() }
//        list.sorted()
//    }
//    println(timeTracker(myFunction))
//}
