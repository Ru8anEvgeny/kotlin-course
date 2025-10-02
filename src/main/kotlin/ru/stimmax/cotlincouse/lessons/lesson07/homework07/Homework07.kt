package ru.stimmax.cotlincouse.lessons.lesson07.homework07

fun main() {

// 1. Напишите цикл for, который выводит числа от 1 до 5.
    for (i in 1..5) {
        println(i)
    }

//  2. Напишите цикл for, который выводит четные числа от 1 до 10.
    for (i in 1..10) {
        if (i % 2 == 0){
            println(i)
        }
    }

// 3.Создайте цикл for, который выводит числа от 5 до 1.
    for (i in 5 downTo 1) {
        println(i)
    }

// 4. Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
    for (i in 10 downTo 1) {
        println(i - 2)

    }

// 5. Используйте цикл for с шагом 2 для вывода чисел от 1 до 9
    for (i in 1..9 step 2) {
        println(i)
    }

//6. Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
    for (i in 1..20 step 3) {
        println(i)
    }
// 7. Создайте числовую переменную 'size'.
// Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    val size = 16
    for (i in 3 until size step 2) {
        println(size)
    }
// 8. Создайте цикл while, который выводит квадраты чисел от 1 до 5
    var num0 = 1
    while (num0 <= 5) {
        println(num0 * num0)
        num0++
    }
//9. Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
    var num = 10
    while (num >=5) {
        println(num)
        num--
    }
//10. Используйте цикл do while, чтобы вывести числа от 5 до 1.
    var num1 = 5
    do {
        println(num1)
        num1--
    } while (num1 in 5 downTo 1)

// 11. Создайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5
    var counter = 5
    do {
        println(counter)
        counter++
    } while (counter < 10)

// 12. Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
    for (i in 1..10) {
        if (i == 6) break
        println(i)
    }

// 13. Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10
    var counter1 = 0
    while (true) {
        counter1++
        println(counter1)
        if (counter1 == 10) break
    }

//14. В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа
    for (i in 1..10) {
        if (i % 2 == 0) continue
        println(i)

    }
//15. Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
    var counter2 = 1
    while (counter2 in 1..10) {
        if (counter2 % 3 == 0) {
            counter2++
            continue
        }
        println(counter2)
        counter2++


    }

    for (i in 1..10) {
        for (j in 1..10) {
            print(i * j)
        }
        println()
    }




sum(5)
}
//Напишите функцию, которая суммирует числа от 1 до 'arg' с помощью цикла for. 'arg' - целочисленный аргумент функции

fun sum (arg: Int){
    var sum = 0
    for (i in 1..arg) {
        sum += i
    }
    println(sum)
}

