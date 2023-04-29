package singleton

data class Student (
    val id: Int,
    val firstName:
    String, val lastName: String
) {
    val fullName = "$lastName, $firstName"
}

val marie = Student(1, "Marie", "Curie")
val albert = Student(2, "Albert", "Einstein")
val emmy = Student(3, "Emmy", "Noether")

object StudentRegistry {
    val allStudents = mutableListOf<Student>()

    fun addStudent(student: Student) {
        allStudents.add(student)
    }

    fun removeStudent(student: Student) {
        allStudents.remove(student)
    }

    fun listAllStudents() {
        allStudents.forEach {
            println(it.fullName)
        }
    }
}

// STATIC MEMBERS
class Scientist private constructor(
    var id: Int,
    val firstName: String,
    val lastName: String
) {
    companion object {
        var currentId = 0

        fun newScientist(
            firstName: String,
            lastName: String
        ): Scientist {
            currentId += 1
            return Scientist(currentId, firstName, lastName)
        }
    }

    var fullName = "$firstName $lastName"
}


// create a repo of scientist as a singleton
object ScientistRepository {
    val allScientists = mutableListOf<Scientist>()
    fun addScientist(scientist: Scientist) {
        allScientists.add(scientist)
    }
    fun removeScientist(scientist: Scientist) {
        allScientists.remove(scientist)
    }
    fun listAllScientists() {
        allScientists.forEach {
            println("${it.id}: ${it.fullName}")
        }
    } }

// ANONYMOUS OBJECTS
// => are used in Java to override the behavior of existing classes without the need to subclass,
// and also to implement interfaces without defining a concrete class
// CAN CREATE KOTLIN VERSION OF ANONYMOUS CLASSES

object X {
    var x = 0
}

interface Counts {
    fun studentCount(): Int
    fun scientistCount(): Int
}

// create an annoyous object using this interface
val counter = object : Counts {
    override fun studentCount(): Int {
        return StudentRegistry.allStudents.size
    }

    override fun scientistCount(): Int {
        return ScientistRepository.allScientists.size
    }
}

// PROPERTIES 