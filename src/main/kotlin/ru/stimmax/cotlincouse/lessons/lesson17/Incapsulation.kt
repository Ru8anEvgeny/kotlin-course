package ru.stimmax.cotlincouse.lessons.lesson17

// инкапсуляция - скрываем поле баланса. Из мейн не сможем обратиться на прямую к balance
class Account(private var balance: Double) {

    fun deposit(amount: Double) {
        if(amount > 0) {
            balance += amount
        }
    }

    fun getBalance():  Double {
        return balance
    }
}


// Пример с наследованием
// Person с инкапсулированным полем name и защищенным полем age
// Защищенное поле означает что доступ будет только внутри класса и внутри класса наследника
open class Person(private val name: String, protected val age: Int) {
    // публичный метод
    fun greet() {
        secret()
        println("Привет меня зовут $name")
    }

    // защищенный метод
    protected fun getName(): String {
        return name
    }

    // приватный метод
    private fun secret() { // будет доступен только внутри границ класса Person
        println("Это секретный метод")
    }
}

// наследуемся от класса Person
class Student(
    name: String,
    age: Int,
    val studentId: Int
) : Person(name, age) {

    //публичный метод
    fun study() {
        // используем защищенный метод getName из родительского класса
        println("${getName()} (id: $studentId) учится")
    }

    fun showAge() {
        // обращаемся к защищенному полю age из родительского класса
        println("Мне $age лет.")
    }

    fun trueAccessSecret() {
        // попытка вызвать приватный метод secret() из родительского класса
       // secret() // ошибка компиляции. Метод недоступен
    }
}


// инкапсуляции Конструкторов класса и целых классов

class SomeClass private constructor(val arg1: Int, val arg2: Int) {
    // private constructor - значит приватный конструктор. Значит при создании объекта класса
    // нельзя будет вызвать этот конструктор.

    companion object { // это специальный блок в котором есть поля и функции которые можно вызывать
        // напрямую из класса не создавая при этом объекта этого класса
        fun init(arg1: Int): SomeClass {
        // создали функцию которая принимает аргумент далее возвращает тип SomeClass
            return SomeClass(arg1, arg1 + 1)
        }
    }

    private val data = mutableListOf<AnotherClass>()

    fun add(arg: Int) {
        data.add(AnotherClass(arg + arg2))
    }

    fun get(): List<Int> {
        return data.map{it.arg}
    }
}

private data class AnotherClass(val arg: Int)

































fun main() {
    val account = Account(10.5)
    account.deposit(3.0)
    println(account.getBalance())

}