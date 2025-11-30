package ru.stimmax.cotlincouse.lessons.lesson22.homework22
//Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException
//OutOfMemoryError
//StackOverflowError



fun main() {
    val arg1: Int? = null // NullPointerException
    try {
        arg1!!
    } catch (e: NullPointerException) {
        println("Это исключение NullPointerException " +
                "сигнализирует о том, что код попытался использовать null значение как обычный объект")
    }
//
    val arg2 = mutableListOf(1, 2, 3) // IndexOutOfBoundsException
    try {
        arg2[10]
    } catch (e: IndexOutOfBoundsException) {
        println("Это исключение IndexOutOfBoundsException возникает, когда код пытается получить доступ к " +
                "элементу массива, списка или другой коллекции по индексу, который выходит за пределы допустимого " +
                "диапазона")
    }


    val arg3: String = "arg3" // ClassCastException
    try {
        arg3 as Int
    } catch (e: ClassCastException) {
        println("Это исключение ClassCastException, возникает при попытке привести  объект к классу, " +
                "экземпляром которого этот объект не является.")
    }

    try {
        addMoney(1) // IllegalArgumentException
    } catch (e: IllegalArgumentException) {
        println("Это исключение IllegalArgumentException которое выбрасывается, когда методу передан неверный или " +
                "неподходящий аргумент. Оно сигнализирует, что аргумент функции нарушает ожидаемые условия, " +
                "например, находится вне допустимого диапазона, равен null там, где это недопустимо, или не " +
                "соответствует другим бизнес-правилам")
    }

    val arg5 = "123abc" //NumberFormatException
    try {
        arg5.toInt()
    } catch (e: NumberFormatException) {
        println("Это исключение NumberFormatException возникает, когда пытаются преобразовать строку в числовой " +
                "тип (например, Int или Double), но строка не соответствует ожидаемому числовому формату.")
    }

    try {
        setAge(-1) // IllegalStateException
    } catch (e: IllegalStateException ) {
        println("Это исключение IllegalStateException возникает, когда метод или операция вызывается в " +
                "неподходящем состоянии объекта. Это значит, что объект находится не в том состоянии, которое " +
                "требуется для выполнения данного действия")
    }
    val arg7 = mutableListOf<String>() // OutOfMemoryError
    try {
        while (true) {
            arg7.add("str1")
        }
    } catch (e: OutOfMemoryError) {
        println("Это исключение OutOfMemoryError это ошибка, которая возникает, когда виртуальная машина " +
                "Java (JVM) не может выделить память для создания объекта, " +
                "потому что вся доступная память заполнена.")
    }

    try {
        a1() // StackOverflowError
    } catch (e: StackOverflowError ) {
        println("Исключение StackOverflowError возникает в Kotlin (и в Java) при переполнении стека вызовов. " +
                "Стек вызовов — это область памяти, в которой хранятся данные о текущих активных методах и их вызовах. " +
                "Каждый вызов метода добавляется в стек, и когда метод завершается, соответствующая запись удаляется из стека.")
    }






}
fun a1() {
    a1()
}


fun addMoney(value: Int) {
    require(value > 5) {
        "Денег должно быть больше 5"
    }

}

fun setAge(age: Int) {
    check(age > 0) {
        "Возраст должен быть больше 0"
    }
}

//Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни
// набор действий с этим аргументом которые могут потенциально вызвать одно из исключений в этом же порядке:

//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException
//В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения и
// выведи сообщение с названием исключения. Сразу после when выброси перехваченное исключение через throw,
// чтобы прекратить работу программы. Если аргумент функции не вызвал исключение, то выведи текст, сообщающий
// что переданный аргумент фантастически хорош!

fun exceptionType(arg: Any?) {
    try {
        val list = arg!! as List<*> // NullPointerException если null или ClassCastException если не привести к листу
        val element = list[10] // IndexOutOfBoundsException если нет такого индекса
        require(element is String) // IllegalArgumentException - если элемент не будет стрингом
        val a = element.toInt()//NumberFormatException если не удастся преобразовать елемент к числу
        check(a > 5)// IllegalStateException если  a будет меньше или равно 5
    } catch (e: Throwable) {
        val result = when(e) {
            is NullPointerException -> "Это NullPointerException"
            is IndexOutOfBoundsException -> "Это IndexOutOfBoundsException"
            is ClassCastException -> "Это ClassCastException"
            is IllegalArgumentException -> "Это IllegalArgumentException"
            is NumberFormatException -> "Это NumberFormatException"
            is IllegalStateException -> "Это IllegalStateException"
            else -> "Необработанное исключение"
        }
    }
}