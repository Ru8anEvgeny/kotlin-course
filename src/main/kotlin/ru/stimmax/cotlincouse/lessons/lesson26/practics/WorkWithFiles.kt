package ru.stimmax.cotlincouse.lessons.lesson26.practics

import java.io.File

fun main() {
    val file = File("path/to/your/file.txt")// путь до файла. Если начале нет слеша то считается
    // что путь начинается с корня проекта
    val directory = File("path/to/your/directory")// путь до директории

    // метод exists - проверяет существует ли файл или директория
    if (file.exists()) {
        println("Файл существует")
    } else {
        println("Файл не существует")
    }

    file.parentFile?.mkdirs()
    // parentFile - возвращает объект типа файл который содержит родительский путь patch/to/your
    // mkdirs - создает путь в file - patch/to/your/
    // ? - если у файла нет родительского пути, допустим просто  file.txt - то если не вызовем проверку
    // ?, будет эксепшен


    // метод createNewFile - физически создать файл. Создать файл можно только в том случае если путь существует
    val isNewFileCreated: Boolean = file.createNewFile()
    if (isNewFileCreated) {
        println("Файл создан")
    } else {
        println("Файл уже существует")
    }

    // метод writeText - добавляет  текст в файл. Если файл не создан  то writeText создаст его и добавит туда текст
    file.writeText("Hello World")

    val isDirectoryCreated: Boolean = directory.mkdirs() // создали директорию directory
    if (isDirectoryCreated) {
        println("Директория создана")
    } else {
        println("Директория не создана либо уже существует")
    }


    // listFiles - создает объект типа списка. Тут мы создаем переменную говорим с помощью parentFile
    // верни путь до файла path/to/your/
    // И вызываем listFiles - он создает объект типа списка из объектов типа файл
    val files = directory.parentFile.listFiles()
    files?.forEach { file ->
        println(file.name)
    }

    // delete - удаляет файл или директорию
    if (file.delete()) {
        println("Файл удален")
    } else {
        println("Не удалось найти файл")
    }

    val sourceFile = File("path/to/source.txt")
    val destinationFile = File("path/to/destination.txt")
    sourceFile.copyTo(destinationFile, true)// Копирует файл, если файл существует и true - перезапишет его
    // если если файл существует и false - то не перезапишет


    // relative - возвращает относительный путь относительно дериктории которую в него передали
    val baseDir = File("path/to")
    val files1 = File("path/to/nested/file.txt")
    val relative = files1.relativeTo(baseDir)
    println(files1.relativeTo(baseDir))// Вывод nested/file.txt
    val target = File("path/to1")
    target.resolve(relative)// добавляет к target путь relative. В итоге будет path/to1/nested/file.txt


}
// Поиск файлов и директории
fun searchFilesUsingWalk(startDir: String, query: String): List<String> {
    return File(startDir)
        .walk()// Рекурсивный обход файлов и директорий начиная с startDir
        .filter { it.isFile && it.name.contains(query, true) }// Фильтр по имени файла
        .map {it.absolutePath} // Преобразование результатов в абсолютные пути
        .toList() // сбор результатов в список
}