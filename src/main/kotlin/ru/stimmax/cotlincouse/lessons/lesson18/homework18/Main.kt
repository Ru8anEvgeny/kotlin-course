package ru.stimmax.cotlincouse.lessons.lesson18.homework18

fun main() {
    val oven = Oven("Samsung", "red", "1234-231-DK")
    oven.powerOn()
    oven.open()
    oven.setTemperature(180)
    oven.close()
    oven.programAction("Test1")
    oven.emitLight()
    oven.startMonitoring()
    oven.setTimer(60)
    oven.completeLiteEmission()


    val fridge = Fridge("Samsung", "white", "ABC-321")
    fridge.powerOn()
    fridge.programAction("Program1")
    fridge.setTemperature(15)


    val teapot = Teapot("Tefal", "blue", "123123-KPUPq")
    teapot.powerOn()
    teapot.setTemperature(90)
    teapot.programAction("Program2")
    teapot.startMonitoring()
    teapot.execute()

    val washer = Washer("Bork", "gray", "Е111КХ")
    washer.powerOn()
    washer.open()
    washer.setTemperature(60)
    washer.connectToWaterSupply()
    washer.getWater(10)
    washer.setTimer(120)
    washer.programAction("Stirka")
    washer.execute()
    washer.connectToDrain()
    washer.drain()

    offDevice(listOf(oven, fridge, teapot, washer))

}

fun offDevice(list: List<Equipment>) {
    list.forEach {
        it.powerOff()
    }
}