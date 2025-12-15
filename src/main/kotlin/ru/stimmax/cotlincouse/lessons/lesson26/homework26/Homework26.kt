package ru.stimmax.cotlincouse.lessons.lesson26.homework26

import java.io.File


fun ex1() {
    File("workspace/task1/example.txt").apply {
        parentFile?.mkdirs()
        createNewFile()
        writeText("Hello, Kotlin!")
        if (exists()) {
            println("Файл существует")
        } else {
            println("Файл не найден")
        }
    }
}
//Задание 2

fun ex2() {
    File("workspace/task2/testDir").apply {
        mkdirs()
        if (isDirectory) {
            println("Это директория")
        } else {
            println("Это не директория")
        }
        println(absolutePath)
    }
}
//Задание 3

fun ex3() {
    with(File("workspace/task3/structure")) {
        mkdirs()
        resolve("myDir")
    }?.apply {
        mkdir()
        resolve("subDir1").mkdir()
        resolve("subDir2").mkdir()
        val files = list()
        if (files?.all { it.contains("subDir1") || it.contains("subDir2") } ?: false) {
            println("Директории найдены")
        } else {
            println("Директории не найдены в ${list().joinToString()}")
        }
    }
}
//Задание 4

fun ex4() {
    File("workspace/task4/temp").apply {
        mkdirs()
        mapOf(
            "dir1" to true,
            "file1" to false,
            "dir2" to true,
            "dir3" to true,
            "file2" to false,
            "file3" to false
        ).forEach { (name, isDirectory) ->
            resolve(name).also {
                if (isDirectory) {
                    it.mkdir()
                } else {
                    it.createNewFile()
                }
            }
        }
        check(list() != null && list()!!.size == 6) { "Список файлов и директорий не полный ${list()?.joinToString()}" }
        parentFile.deleteRecursively()
    }
    check(!File("workspace/task4").exists())
}
//Задание 5

fun ex5() {
    with(File("workspace/task5/config/config.txt")) {
        parentFile.mkdirs()
        createNewFile()
        listOf("param 1 = true", "param 2 = false").also {
            writeText(it.joinToString("\n"))
        }
        readLines().map {
            it.split("=")
                .getOrNull(1)
                ?.trim() ?: ""
        }.also {
            println(it.joinToString())
        }
    }
}
//Задание 6

fun ex6() {
    File("workspace").apply {
        walk().groupBy { if (it.isDirectory) "dir" else "file" }
            .also {
                println("Directories")
                println(it["dir"]?.joinToString("\n"))
                println("Files")
                println(it["file"]?.joinToString("\n"))
            }
    }
}
//Задание 7

fun ex7() {
    val phrase = "This is a README file."
    File("workspace/task7/docs/readme.md").apply {
        parentFile?.mkdirs()
        if (!this.exists()) {
            createNewFile()
            writeText(phrase)
        }
        check(readText() == phrase)
    }
}
//Задание 8

fun ex8() {
    File("workspace/task8").deleteRecursively()
    listOf(
        "workspace/task8/data/1/4/prod/data14.mysql",
        "workspace/task8/data/2/3/prod/data23.mysql",
        "workspace/task8/data/5/2/prod/data52.mysql",
    ).forEach {
        File(it).apply {
            parentFile?.mkdirs()
        }.createNewFile()
    }
    val backup = File("workspace/task8/backup").also { it.mkdirs() }
    File("workspace/task8/data").apply {
        walk().filter { it.isFile }
            .forEach {
                val relative = it.relativeTo(this)
                it.copyTo(backup.resolve(relative))
            }
    }
}