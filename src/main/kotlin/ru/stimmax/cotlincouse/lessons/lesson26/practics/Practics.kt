package ru.stimmax.cotlincouse.lessons.lesson26.practics

import java.io.File

fun ex1(arg: String) {
    if (arg.endsWith("/")) {
        val directory = File(arg)
        directory.mkdirs()
    } else {
        val files = File(arg)
        files.parentFile?.mkdirs()
        files.createNewFile()
    }
}
//Напишите функцию writeDataToFile, которая принимает путь к файлу и объект Map<String, Double>.
// Функция должна записать данные из словаря в файл, форматируя их в виде текста разделяя ключи и
// значения символом =.
fun ex2(arg: String, map: Map<String, Double>) {
    val file = File(arg)
    file.parentFile?.mkdirs()
    file.createNewFile()
    map.map { "${it.key} = ${it.value}" }
        .joinToString { "\n" }.also {
            file.writeText(it)
        }
}
//Напишите функцию deleteFile, которая принимает путь к файлу и ключевую фразу и удаляет файл только
// в том случае, если в файле не содержится ключевая фраза
fun deleteFile(path: String, query: String) {
    File(path).apply {
        if(exists() && readText().contains(query)) {
            delete()
        }
    }
}

fun findFiles(dir: String, query: String): List<String> {
    return File(dir)
        .walk()
        .filter { it.name.contains(query) && it.isFile }
        .map { it.readText() }
        .toList()

}

fun String.copyTo(path: String) {
    File(this).run {
        check(exists()){"Не существует"}
        val file = File(path)
        file.parentFile.mkdirs()
        copyTo(file, true)
    }
}

