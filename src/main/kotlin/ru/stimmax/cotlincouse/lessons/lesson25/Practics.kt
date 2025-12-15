package ru.stimmax.cotlincouse.lessons.lesson25

fun ex1(): Int{
    val list = listOf(1, 2, 3, 4, 5)
    val result = list.sum()
    println(result)
    return result
}

fun ex1_1(): Int {
    return listOf(1, 2, 3, 4, 5).sum()
        .apply {
        println(this)
    }
}

fun ex1_2(): Int {
    return listOf(1,2,3,4,5).sum()
        .also {
        println(it)
    }
}

fun ex2(): Int {
    val list = mutableListOf<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    println(list.size)
    return list.sum()
}

fun ex2_1(): Int {
    return with(mutableListOf<Int>()){
        add(1)
        add(2)
        println(size)
        sum()
    }
}

fun ex2_2(): Int {
    return mutableListOf<Int>().run {
        add(1)
        add(2)
        println(size)
        sum()
    }
}

fun ex3(list: List<String>?): Int {
    if (list == null){
        println(0)
        return 0
    } else {
        val result = (list.map { it.length }.sum())
        println(result)
        return result
    }
}

fun ex3_1(list: List<String>?): Int {
    return (list?.let { result ->
        result.sumOf { it.length }
    } ?: 0)
        .also { println(it) }
}


