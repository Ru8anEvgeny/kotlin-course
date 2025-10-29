// Базовый класс
open class Furniture(
    val name: String,
    val dimensions: String,
    val price: Double
)

// Первый уровень наследования
open class SeatingFurniture(
    name: String,
    dimensions: String,
    price: Double,
    val material: String
) : Furniture(name, dimensions, price)

open class StorageFurniture(
    name: String,
    dimensions: String,
    price: Double,
    val hasLocks: Boolean
) : Furniture(name, dimensions, price)

// Второй уровень наследования для SeatingFurniture
class Chair(
    name: String,
    dimensions: String,
    price: Double,
    material: String,
    val hasArmrests: Boolean
) : SeatingFurniture(name, dimensions, price, material)

class Sofa(
    name: String,
    dimensions: String,
    price: Double,
    material: String,
    val seatCount: Int
) : SeatingFurniture(name, dimensions, price, material)

// Второй уровень наследования для StorageFurniture
class Cabinet(
    name: String,
    dimensions: String,
    price: Double,
    hasLocks: Boolean,
    val numberOfShelves: Int
) : StorageFurniture(name, dimensions, price, hasLocks)

class Wardrobe(
    name: String,
    dimensions: String,
    price: Double,
    hasLocks: Boolean,
    val hasMirror: Boolean
) : StorageFurniture(name, dimensions, price, hasLocks)