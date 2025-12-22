package ru.stimmax.cotlincouse.lessons.lesson26.homework26

import java.io.File

//Задача 1
//Создайте текстовый файл workspace/task1/example.txt. Запишите в него строку "Hello, Kotlin!",
// а затем проверьте, существует ли файл. Реши задачу с использованием scope функции без создания переменной.
fun main() {
    File("workspace/task1/example.txt").run {
        parentFile?.mkdirs()
        createNewFile()
        writeText("Hello")
        if (exists()) {
            println("Файл существует")
        } else {
            println("Файл не существует")
        }
    }

// Задача 2
//Создайте директорию workspace/task2/testDir.
// Проверьте, является ли она директорией, и выведите её абсолютный путь.
    File("workspace/task2/testDir").run {
        mkdirs()
        if (isDirectory) {
            println("Это директория")
        } else {
            println("Не является директорией ")
        }
        println(absolutePath)
    }

//Задача 3
//Создайте директорию workspace/task3/structure. Внутри директории structure создайте папку myDir с
// двумя вложенными поддиректориями subDir1 и subDir2. Проверьте, что myDir действительно содержит эти
// поддиректории. Используй scope функции для минимизации создания переменных а так же
// метод file.resolve("myDir") для создания нового объекта File путём добавления к существующему пути ещё
// одной секции. И так же для других директорий.

    File("workspace/task3/structure").run {
        mkdirs()
        resolve("myDir")
    }.run {
        mkdirs()
        resolve("subDir1").mkdirs()
        resolve("subDir2").mkdirs()
        val list = listFiles()
        var counterFiles = 0
        list?.forEach { file ->
            if (file.name == "subDir1" || file.name == "subDir2") {
                counterFiles ++
            }
        }
        if (counterFiles == 2) {
            println("Директории найдены")
        } else {
            println("Директории не найдены")
        }


    }
// Задача 4
//Создайте директорию workspace/task4/temp. Внутри директории temp создайте несколько вложенных
// файлов и директорий. Удалите директорию workspace/task4 со всем содержимым

    val file = File("workspace/task4/temp").run {
        mkdirs()
        resolve("test")
    }.also {
        it.mkdirs()
        it.resolve("test1").mkdirs()
        it.resolve("test2").mkdirs()
        it.resolve("test1/test1.txt").run {
            parentFile?.mkdirs()
            createNewFile()
        }
        it.resolve("test2/test2.log").run {
            parentFile?.mkdirs()
            createNewFile()
        }
        it.resolve("data.json").run {
            parentFile?.mkdirs()
            createNewFile()
        }

    }

    file.parentFile?.parentFile?.deleteRecursively()

// Задача 5
//Создайте файл workspace/task5/config/config.txt. запишите в него список параметров
// (в формате ключ=значение), а затем прочитайте файл и выведите только значения.

    File("workspace/task5/config/config.txt").run {
        parentFile?.mkdirs()
        createNewFile()
        writeText(listOf("1 = odin", "2 = dva").joinToString("\n"))
        val result = readLines().map {
            it.split("=")[1].trim()
        }
        println(result)
    }

    }
















