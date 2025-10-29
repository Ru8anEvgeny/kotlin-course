package ru.stimmax.cotlincouse.lessons.lesson15.homework15

open class EducationalInstitution(
    val nameEducationalInstitution: String,
    val address: String
) {
    fun open(){
        println("Учебное заведение открыто")
    }

    fun close(){
        println("Учебное заведение закрыто")
    }
}

open class School(
    nameEducationalInstitution: String,
    address: String,
    val level: String
) : EducationalInstitution(nameEducationalInstitution, address)


open class University(
    nameEducationalInstitution: String,
    address: String,
    val direction: String// направление

): EducationalInstitution(nameEducationalInstitution, address)


class PrimarySchool( // наследник класса School
    nameEducationalInstitution: String,
    address: String,
    val NumberOfFeatures: Int

) : School(nameEducationalInstitution, address, "Начальная")

class TehUniversity(// наследник класса Университет
    nameEducationalInstitution: String,
    address: String,
    val numberODepartments: Int
): University(nameEducationalInstitution, address, "Технический")









fun main() {
    val university = University("Test", "testAddress", "Test")
    university.open()


}