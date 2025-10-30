package ru.stimmax.cotlincouse.lessons.lesson16.homework16.cart

import ru.stimmax.cotlincouse.lessons.lesson16.Colors

class Cart {
    val item = mutableMapOf<String, Int>()

    fun addToCart(itemId: String) {
        item[itemId] = 1
    }

    //Выполнить перегрузку addToCart который:
    //Принимает два аргумента (itemId и количество amount)
    //Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
    fun addToCart(itemId: String, amount: Int) {
        if (item.containsKey(itemId)) {
            item[itemId] = (item[itemId] ?: 0) + amount
        } else {
            item[itemId] = amount
        }
    }


    //Принимает словарь из id и количества и добавляет всё в корзину
    //Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
    fun addToCart(itemMap: Map<String, Int>) {
        for ((key, values) in itemMap) {
            if (item.containsKey(key)) {
                item[key] = (item[key] ?: 0) + values
            } else {
                item[key] = values
            }

        }

    }

    // Принимает список из id (добавляет по одной единице).
    //Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
    fun addToCart(itemId: List<String>) {
        for (i in itemId) {
            if (item.containsKey(i)) {
                item[i] = (item[i] ?: 0) + 1
            } else {
                item[i] = 1
            }

        }
    }

    override fun toString(): String {
        return """
            ${Colors.RED}
            Количество товара: ${item.keys.count()}
            Количество единиц товара: ${item.values.sum()}
        """.trimIndent()

    }
}





