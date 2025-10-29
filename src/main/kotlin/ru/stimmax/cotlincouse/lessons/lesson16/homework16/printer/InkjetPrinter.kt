package ru.stimmax.cotlincouse.lessons.lesson16.homework16.printer
//Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно
// цветными буквами на цветном фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом
// текста и фона и проходить циклически по этому списку при выводе текста.
// Проверить работу на длинном тексте
class InkjetPrinter() : Printer (){
    override fun print(text: String) {
        val result = text.split(" ")

        val colorPair = listOf(
            Pair(Color.BLUE, Background.RED),
            Pair(Color.BLACK, Background.WHITE),
            Pair(Color.YELLOW, Background.CYAN),
            Pair(Color.CYAN, Background.GREEN),
            Pair(Color.PURPLE, Background.BLUE)
        )

        result.forEachIndexed { index, result ->
            val pair = colorPair[index % colorPair.size]
            printColor(result, pair.first, pair.second)
        }

    }
}