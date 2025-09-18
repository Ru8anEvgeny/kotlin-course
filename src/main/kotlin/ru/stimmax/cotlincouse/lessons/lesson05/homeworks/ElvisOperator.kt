package ru.stimmax.cotlincouse.lessons.lesson05.homeworks

fun main() {
    // example 1
    val soundIntensityStartValue: Double = 5.7
    val decayCoefficient: Double? = null
    val baseCoefficient: Double = 0.5
    val finalSoundIntensity = soundIntensityStartValue * (decayCoefficient ?: baseCoefficient)
    println(finalSoundIntensity)

    // example 2
    val cargoCost: Double? = null // 37.15
    val baseCargoCost: Double = 50.0
    val deliveryCost: Double = 13.0
    val cargoInsurance: Double = 0.5 / 100.0 * (cargoCost ?: baseCargoCost)
    val deliveryPrice: Double = deliveryCost + cargoInsurance
    println(deliveryPrice)


    // example 3
    val labTechnicianMetrics: Double? = null// 18.4
    val atmosphericPressure: Any = labTechnicianMetrics ?: "Ошибка отсутствия показаний АД"
    println(atmosphericPressure)
















}