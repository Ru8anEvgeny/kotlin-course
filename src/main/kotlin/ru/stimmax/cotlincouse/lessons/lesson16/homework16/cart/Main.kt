package ru.stimmax.cotlincouse.lessons.lesson16.homework16.cart

import ru.stimmax.cotlincouse.lessons.lesson16.Colors
import ru.stimmax.cotlincouse.lessons.lesson16.homework16.printer.Background

fun main() {
    val cart = Cart()
    cart.addToCart("Товар1")
    cart.addToCart("Товар1", 3)
    cart.addToCart(listOf("Товар2", "Товар3", "Товар4"))
    cart.addToCart(mapOf("Товар" to 1, "Товар6" to 3))
    println(cart.item)

    println(cart)



}