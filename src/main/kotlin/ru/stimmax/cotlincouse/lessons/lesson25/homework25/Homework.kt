
class Person(val name: String, val age: Int) {
    var email: String = ""
}

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}

//1
fun ex1(fnc: () -> Any): Long {
    val start = System.currentTimeMillis()
    fnc()
    return System.currentTimeMillis() - start
}

//3
fun printPerson(person: Person) {
    with(person) {
        println("""
           Name: $name
           Age: $age
           Email: $email
       """.trimIndent())
    }
}

//6
fun Person?.toEmployee(position: String, depart: String): Employee? {
    return this?.let {
        Employee(it.name, it.age, position).apply {
            email = it.email
            department = depart
        }
    }
}

fun main() {
    //1
    val myFunction = {
        val list = List(10000000) { (0..10000).random() }
        list.sorted()
    }
    println(ex1(myFunction))

    //2
    val em = Employee("Ivan", 23, "QA Engineer").apply {
        email = "ivan@gm.com"
        department = "dep1"
    }

    //3
    val person = Person("Anna", 26).also {
        it.email = "anna@gm.com"
        printPerson(it)
    }

    //4
    val person1 = Person("Andrew", 32).apply {
        email = "andrew@gm.com"
    }
    val employee = with(person1) {
        Employee(name, age, "Front dev").also {
            it.email = email
            it.department = "dep2"
        }
    }

    // 5
    val person2 = Person("Andrew", 32).apply {
        email = "andrew@gm.com"
    }

    val employee1 = person2.run {
        Employee(name, age, "Front dev").also {
            it.email = email
            it.department = "dep2"
        }
    }


}

