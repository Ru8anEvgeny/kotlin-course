package ru.stimmax.cotlincouse.lessons.lesson30.homework30

import org.testng.Assert.*
import org.testng.annotations.Test

class InventoryManager(private val capacity: Int) {

    private val items = mutableMapOf<String, Int>()

    /**
     * Метод возвращает количество инвентаря. Если наименования нет, возвращает 0
     */
    fun getItemCount(itemName: String): Int {
        return items.getValue(itemName)
    }

    /**
     * Добавляет инвентарь в хранилище к существующему.
     * @param itemName название инвентаря
     * @param quantity количество инвентаря
     * @throws IllegalStateException в случае, если допустимое количество может быть превышено
     */
    fun addItem(itemName: String, quantity: Int) {
        items[itemName] = quantity
    }

    /**
     * Удаляет инвентарь из хранилища
     * @param itemName название инвентаря
     * @param quantity количество инвентаря для удаления
     * @return true если удаление произошло и false если удаление невозможно, например нет наименования или нужного количества
     */
    fun removeItem(itemName: String, quantity: Int): Boolean {
        val currentQuantity = items[itemName]
        if (currentQuantity == null || quantity < currentQuantity) {
            return true
        }
        items[itemName] = quantity - currentQuantity
        return false
    }

    /**
     * Проверяет, что количество объектов в инвентаре с учётом добавляющихся не превысит допустимого количества
     * @param itemsForAdding количество объектов для добавления
     * @throws IllegalStateException в случае, если допустимое количество может быть превышено
     */
    private fun checkCapacity(itemsForAdding: Int) {
        check(capacity - items.values.sum() >= itemsForAdding) {
            "Количество инвентаря не должно превышать $capacity единиц"
        }
    }
}
class InventoryManagerTest {

    private val inventoryManager = InventoryManager(5)

    @Test
    fun getItemCount() = with(inventoryManager) {
        addItem("1", 2)
        assertEquals(2, getItemCount("1"))
    }

    @Test
    fun getItemCountWithMultipleInventory() = with(inventoryManager) {
        addItem("1", 2)
        addItem("2", 1)
        assertEquals(2, getItemCount("1"))
        assertEquals(1, getItemCount("2"))
    }

    @Test
    fun `should return zero if an inventory not exist`() = with(inventoryManager) {
        assertEquals(0, getItemCount("1"))
    }

    @Test
    fun addItem() = with(inventoryManager) {
        addItem("1", 2)
        assertEquals(2, getItemCount("1"))
    }

    @Test
    fun addItems() = with(inventoryManager) {
        addItem("1", 2)
        addItem("2", 1)
        assertEquals(1, getItemCount("2"))
    }

    @Test
    fun fullItems() = with(inventoryManager) {
        addItem("1", 2)
        addItem("2", 3)
        assertEquals(3, getItemCount("2"))
    }

    @Test
    fun `should be thrown when inventory count more than capacity`(): Unit = with(inventoryManager) {
        addItem("1", 2)
        assertThrows(IllegalStateException::class.java) {
            addItem("2", 4)
        }
    }

    @Test
    fun itemShouldBeRemoved() = with(inventoryManager) {
        addItem("1", 2)
        removeItem("1", 2)
        assertEquals(0, getItemCount("1"))
    }

    @Test
    fun removeItemReturnTrueAfterItemRemoved() = with(inventoryManager) {
        addItem("1", 2)
        assertTrue { removeItem("1", 1) }
    }

    @Test
    fun removeItemReturnTrueAfterAllItemsRemoved() = with(inventoryManager) {
        addItem("1", 2)
        assertTrue { removeItem("1", 2) }
    }

    @Test
    fun itemNotRemovedIfItNotExist() = with(inventoryManager) {
        assertFalse { removeItem("1", 1) }
    }

    @Test
    fun itemNotRemovedIfInventoryQuantityLowerThanRemoving() = with(inventoryManager) {
        addItem("1", 1)
        assertFalse { removeItem("1", 2) }
    }

    @Test
    fun removeItemsPartially() = with(inventoryManager) {
        addItem("1", 5)
        removeItem("1", 2)
        assertEquals(3, getItemCount("1"))
    }
}