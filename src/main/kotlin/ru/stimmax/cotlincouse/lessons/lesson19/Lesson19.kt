package ru.stimmax.cotlincouse.lessons.lesson19

import ru.stimmax.cotlincouse.lessons.lesson11.max

class Container<T>(
    private val arg1: T
)
{
    fun returnArg(): T {
        return arg1
    }
}

class PairBox<T, R>(
    private val arg1: T,
    private val arg2: R
){
    fun getMap(): Map<T, R> {
        return mapOf(arg1 to arg2)
    }
}

class Multiplier<T : Number>() {
    fun multiplier (arg: T): Double{
        return arg.toDouble() * 2

    }
}

interface Storage<T>{
    fun save(agr: T)
    fun getArg(): T
}

interface Transformer<P, M> {
    fun transformer(arg: P): M
}

interface PairProcessor<S, O> {
    fun pairProcessor(arg1: S, arg2: O)
}

interface ConnectionDifferent<A, B, C> {
    fun connect(list1: List<A>, list2: List<B>): List<C>
}

fun <R> swap(arg1: MutableList<R>, index1: Int, index2: Int): List<R> {
    if (index1 in arg1.indices && index2 in arg1.indices) {
        val temp = arg1[index1]
        arg1[index2] = arg1[index1]
        arg1[index1] = temp
    }
    return arg1.toList()
}


fun <T : Number> mergeList(list1: List<T>, list2: List<T>): List<Double> {
    val result: MutableList<Double> = mutableListOf()
    val temp = max(list1.lastIndex, list2.lastIndex) // хранит в себе максимальный индекс из 2х листов
    for (i in 0..temp) {
       val res =  list1.getOrElse(i){0}.toDouble() + list2.getOrElse(i){0}.toDouble()
        result.add(res)
    }
    return result.toList()
}

