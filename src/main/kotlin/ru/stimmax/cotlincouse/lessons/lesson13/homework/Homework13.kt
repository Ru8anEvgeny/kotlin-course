package ru.stimmax.cotlincouse.lessons.lesson13.homework

// 1. Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах.
// Определите среднее время выполнения теста.
fun main() {
    val task1 = mapOf("Test1" to 10, "Test2" to 4, "Test3" to 15)
    val result = task1.values.average()
    println(result)


//2. Имеется словарь с метаданными автоматизированных тестов,
// где ключи — это имена тестовых методов а значения - строка с метаданными. Выведите список всех тестовых методов.
    val task2 = mapOf("name1" to "str1", "name2" to "str2", "name3" to "srt3")
    println(task2.keys)

//3. В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val task3 = mutableMapOf("test1" to "result1", "test2" to "result2", "test3" to "resul3")
    task3["test4"] = "result4"
    println(task3)

//4. Посчитайте количество успешных тестов в словаре с результатами
// (ключ - название, значение - результат из passed, failed, skipped).
    val task4 = mapOf("test1" to "passed", "test2" to "failed", "test3" to "skipped", "test4" to "passed" )
    println(task4.count { it.value == "passed" })

//5. Удалите из изменяемого словаря с баг-трекингом запись о баге,
// который был исправлен (ключ - название, значение - статус исправления).
    val task5 = mutableMapOf("NameBugs" to "success", "NameBugs2" to "fields")
    task5.remove("NameBugs")
    println(task5)

// 6. Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа),
// выведите сообщение о странице и статусе её проверки.
    val task6 = mapOf("Url1" to 200, "Url2" to 500, "Url3" to 404)
    for ((keys, value) in task6) {
        println("Страница: $keys, Статус: $value")
    }

// 7. Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает
// заданный порог.
    val task7 = mapOf("name1" to 200, "name2" to 300, "name3" to 400)
    println(task7.filterValues { it >= 300 })

// 8. В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки).
// Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был
// протестирован.
    val task8 = mapOf("endpoint1" to "status1", "endpoint2" to "status2", "endpoint3" to "status3", "endpoint4" to "status4" )
    println(task8.getOrDefault("endpoint4", "Не был протестирован"))

//9. Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации,
// значение - сама конфигурация), получите значение для "browserType". Ответ не может быть null.
    val task9 = mapOf("browserType" to "config1", "browserType2" to "config2", "browserType3" to "config3")
    println(task9.getOrElse("browserType1") { "config1" })

//10. Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
    val task10 = mapOf(
        "App" to "1.3.5",
        "API" to "v2.0.1",
        "Database" to "12.4.7",
    )
    val copyTask10 = task10 + ("Frontend" to "5.6.0")
    println(copyTask10)

//11. Используя словарь с настройками тестирования для различных мобильных устройств
// (ключ — модель устройства, значение - строка с настройками), получите настройки для конкретной модели или
// верните настройки по умолчанию.
    val deviceConfigurations = mapOf(
        "DeviceModel1" to "settingsForDevice1",
        "DeviceModel2" to "settingsForDevice2",
        "DeviceModel3" to "settingsForDevice3"
    )
    println(deviceConfigurations.getOrDefault("DeviceModel", "defaultSettings"))

//12. Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки)
// определенный код ошибки.
    val errorCodes = mapOf(
        "ERR001" to "Неверный формат запроса",
        "ERR002" to "Ошибка аутентификации",
        "ERR003" to "Недостаточно прав доступа",
        "ERR004" to "Ресурс не найден",
        "ERR005" to "Внутренняя ошибка сервера"
    )
    println(errorCodes.containsKey("ERR006"))

//13. Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version",
// а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped").
// Отфильтруйте словарь, оставив только те сценарии, идентификаторы которых соответствуют определённой
// версии тестов, то-есть в ключе содержится требуемая версия.
    val testResults = mapOf(
        "Test1_v1" to "Passed",
        "Test2_v3" to "Failed",
        "Test3_v2" to "Skipped",
        "Test4_v1" to "Passed"
    )
    val result1 = testResults.filterKeys { it.endsWith("v1") }
    println(result1)

// 14. У вас есть словарь, где ключи — это названия функциональных модулей приложения,
// а значения — результаты их тестирования. Проверьте, есть ли модули с неудачным тестированием.
    val task14 = mapOf(
        "UserAuthentication" to "Passed",
        "PaymentProcessing" to "Failed",
        "NotificationService" to "Skipped",
        "DataSync" to "Passed"
    )
    println(task14.containsValue("Failed"))


// 15. Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    val task15 = mutableMapOf(
        "env" to "staging",
        "browser" to "Chrome",
    )

    task15.putAll(mapOf("retries" to "3", "timeout" to "30s" ))
    println(task15)

// 16. Объедините два неизменяемых словаря с данными о багах.
    val bugsSet1 = mapOf(
        "BUG101" to "Null pointer exception при входе",
        "BUG102" to "Ошибка отображения кнопок",
        "BUG103" to "Замедление загрузки страницы"
    )

    val bugsSet2 = mapOf(
        "BUG201" to "Проблема с авторизацией",
        "BUG202" to "Некорректная валидация формы",
        "BUG203" to "Ошибка сохранения данных"
    )

    val bugsSet3 = bugsSet1 + bugsSet2
    println(bugsSet3)

//17. Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
    val lastTestRunData = mutableMapOf(
        "runId" to "2025421",
        "startTime" to "2025-10-19T20:00:00",
        "endTime" to "2025-10-19T20:05:30",
        "passedTests" to "120",
        "failedTests" to "5",
        "skippedTests" to "3",
        "environment" to "staging"
    )
    lastTestRunData.clear()
    println(lastTestRunData)

//18. Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены
// (имеют статус “skipped”). Ключи - название теста, значения - статус.
    val testStatuses = mapOf(
        "LoginTest" to "Passed",
        "PaymentTest" to "Failed",
        "SignupTest" to "Skipped",
        "ProfileUpdateTest" to "Passed",
        "SearchFunctionalityTest" to "Passed",
        "DataExportTest" to "Failed",
        "NotificationTest" to "Skipped",
        "UserSettingsTest" to "Passed",
        "SecurityAuditTest" to "Failed",
        "PerformanceTest" to "Passed",
        "LoadTest" to "Skipped",
        "IntegrationTest" to "Passed",
        "RegressionTest" to "Failed",
        "UIRenderingTest" to "Passed",
        "APIResponseTest" to "Passed",
        "DatabaseConnectionTest" to "Skipped",
        "LocalizationTest" to "Passed",
        "AccessibilityTest" to "Passed",
        "BackupRestoreTest" to "Failed",
        "ErrorHandlingTest" to "Passed"
    )

    val resultTestStatus = testStatuses.filterNot { it.value == "Skipped" }
    println(resultTestStatus)

//19. Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.
    val testConfigurations = mapOf(
        "environment" to "staging",
        "browser" to "Chrome",
        "timeoutSeconds" to "30",
        "retryAttempts" to "3",
        "enableLogging" to "true",
        "headlessMode" to "false",
        "baseUrl" to "https://test.example.com",
        "maxConnections" to "10"
    )

    val copyTestConfig = testConfigurations - listOf("browser", "baseUrl")
    println(copyTestConfig)

//20. Создайте отчет о тестировании, преобразовав словарь с результатами тестирования
// (ключ — идентификатор теста, значение — результат) в список строк формата "Test ID: результат".
    val testResult = mapOf(
        "Test001" to "Passed",
        "Test002" to "Failed",
        "Test003" to "Skipped",
        "Test004" to "Passed",
        "Test005" to "Failed",
        "Test006" to "Passed",
        "Test007" to "Skipped",
        "Test008" to "Passed",
        "Test009" to "Failed",
        "Test010" to "Passed"
    )
    val testResult1 = testResult.map { "${it.key}: ${it.value}" }
    println(testResult1)

//21. Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
    val mutableTestResult = testResult.toMutableMap()

//22. Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов,
// заменив идентификаторы тестов на их строковый аналог (например через toString()).
    val testExecutionTimes = mapOf(
        101 to 350L,   // время в миллисекундах
        102 to 780L,
        103 to 1200L,
        104 to 450L
    )
    val testExecutionTimes1 = testExecutionTimes.mapKeys { it.key.toString() }
    println(testExecutionTimes1)

//23. Для словаря с оценками производительности различных версий приложения
// (ключи - строковая версия, значения - дробное число времени ответа сервера) увеличьте каждую оценку на 10%,
// чтобы учесть новые условия тестирования.

    val testPerformanceRatings = mapOf(
        "v1.0" to 0.45,
        "v1.1" to 0.42,
        "v1.2" to 0.50,
        "v1.3" to 0.48,
        "v2.0" to 0.39,
        "v2.1" to 0.35,
        "v2.2" to 0.33,
        "v2.3" to 0.30,
        "v3.0" to 0.25,
        "v3.1" to 0.22,
        "v3.2" to 0.20
    )

    val task23 = testPerformanceRatings.mapValues { it.value * 1.1 }
    println(task23)

//24. Проверьте, пуст ли словарь с ошибками компиляции тестов.
    val compilationErrors = mapOf<String, String>()
    compilationErrors.isEmpty()

//25. Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
    val loadTestResults = mapOf(
        "TotalRequests" to 20447914,
        "FailedRequests" to 221,
        "AverageResponseTimeMs" to 21.88,
        "MedianResponseTimeMs" to 6,
        "Percentile90ResponseTimeMs" to 18,
        "Percentile95ResponseTimeMs" to 34,
        "Percentile99ResponseTimeMs" to 73,
        "MaxResponseTimeMs" to 380,
        "MeanRequestsPerSecond" to 50,
        "ErrorRatePercent" to 0.00
    )
    loadTestResults.isNotEmpty()

//26. Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
    testResults.all { it.value == "Passed" }

// 27. Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
    testResult.any(){it.value == "Failed"}

//28. Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не прошли
// успешно и содержат в названии “optional”.
    val testResults1 = mapOf(
        "LoginTest_optional" to "Failed",
        "PaymentTest" to "Failed",
        "SignupTest_optional" to "Skipped",
        "ProfileUpdateTest" to "Passed",
        "OptionalFeatureTest" to "Passed"
    )

    val result2 = testResults1.filter { it.value != "Passed" && it.key.contains("optional") }
    println(result2)




















































}
