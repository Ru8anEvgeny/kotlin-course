package ru.stimmax.cotlincouse.lessons.lesson27.enums

import java.lang.IllegalArgumentException

enum class Seasons(val num: Int, val isVariableDuration: Boolean) {
    SPRING(12, true),
    SUMMER(3, false),
    AUTUMN(6, false),
    WINTER(9, false);

    fun seasonInfo() {
        println(name)
    }

    companion object {
        fun get(mount: Int): Seasons {
            return entries.firstOrNull {
                it.num == mount
            } ?: throw IllegalArgumentException()
        }
    }



}

interface HasValue {
    val value: String
}
interface HasAction {
    fun hasAction()
}
enum class HomeTech(override val value: String) : HasValue, HasAction{
    VACUUM("Vacuum"){
        override fun hasAction() {
            println("Пылесос шумит")
        }
    },
    WASHING_MACHINE("") {
        override fun hasAction() {
            println("")
        }
    },
    FRIDGE("") {
        override fun hasAction() {
            println("")
        }
    },
    KETTLE("") {
        override fun hasAction() {
            println()
        }
    },
    ;

}


class Tech() : HasValue {
    override val value: String = ""

}



fun temp(seasons: Seasons) {
    when(seasons) {
        Seasons.AUTUMN -> ""
        Seasons.SPRING -> ""
        Seasons.SUMMER -> ""
        Seasons.WINTER -> ""
    }.apply {
        println(this)
    }
}










fun main() {
    Seasons.AUTUMN.seasonInfo()
}