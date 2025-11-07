package ru.stimmax.cotlincouse.lessons.lesson17.homework17
abstract class BaseClass(
    // 1. поле доступно в main() потому что в ChildrenClass оно не является приватным
    private val privateVal: String,
    // 2. это поле недоступно в main() потому, что оно protected и будет доступно только у класса наследника
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. Поле приватное, его не поменять даже из класса наследника"
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }
    fun printText() {
        privatePrint()
    }
    // 7. объясни, почему эта функция не может быть публичной
    // Потому, что оно возвращает ProtectedClass, а этот класс является protected и
    // Доступен либо внутри класса в котором реализован либо в наследнике.
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }
    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    // Потому, что метод переопределен в дочернем классе.
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }
    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }
    // 9. объясни, почему эта функция не может быть публичной или protected
    // Потому, что она возвращает приватный класс, он доступен только внутри класса в котором реализован
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}
class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    // Доступно поле из родительского класса
    publicVal: String
) : BaseClass(privateVal, protectedVal, privateVal) {
    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // Потому, что ChildrenClass наследуется от класса в котором есть эта функия
    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }
    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
    override fun verifyPublicField(value: String): Boolean {
        return true
    }

    fun updateProtectedField(value: String) {
        protectedField = value
    }




}

fun main() {
    val children = ChildrenClass("", "", "")
    children.publicField = "Антонио Бандерас"
    children.updateProtectedField("Дима Билан")
    println(children.getAll())
}