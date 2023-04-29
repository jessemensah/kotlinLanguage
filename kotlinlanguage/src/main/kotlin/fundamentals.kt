import java.util.*
import kotlin.math.*

fun main() {
    println("Hello Kotlin")

    // number operations
    println(2+3)
    println(3+5)
    println(3/10)
    println(50%10)

    // math functions => in order to do math functions you have to import library
    sin(45 * PI / 180)


    // Naming data => Variables vs constants
    //constants => cannot be reassigned or changed once declared
    val surname: String = "Amoako Mensah"

    // variables => can be reassigned once declared
    var variableNumber: Int = 100
    variableNumber = 30
    println(variableNumber)

    // Converting data types !! => data types can be converted from one type to another.
    // two different data types cannot be matched together
    // an example of matching integer & decimal
    var age: Int = 31
    var temp: Double = 16.2
    // age = temp => uncomment this part and see kotlin complain
    // converted temp variable to INTEGER
    age = temp.toInt()

    // OPERATIONS WITH MIXED TYPE
    // write a script that calculates totalCost using hourlyRate & hoursWorked
    // put hourlyRate into a variable
    val hourlyRate: Double = 8.8
    val hoursWorked: Int = 8
    val totalCost: Double = hourlyRate * hoursWorked.toDouble()
    println(totalCost)

    // Type Inference => kotlin can deduce when you want to convert data types and this is type inference

    // Mini Exercises
    // 1. Create a constant called age1 and set it to 42
    val age1 = 42
    // 2. create a constant called age2 and set it to 21
    val age2 = 21

    // 2. Create a constant called avg1 and set it equal to the average of age1 and age2
    // using the naive operation (age1 + age2) / 2
    var avg1 = (age1.toDouble() + age2.toDouble()) / 2
    println(avg1)


    // STRINGS & CHARACTERS
    val characterA: Char = 'a'
    val dog: String = "Dog"

    // concatenation
    var message = "Hello" + " my name is "
    val name = "Jesse"
    message += name
    // or
    message = "Hello my name is $name!"
    print(message)

    // PAIRS AND TRIPLES => DATA COMPOSED OF TWO OR THREE VALUES OF ANY TYPE
    // OTHER LANGUAGES CALL THEM TUPLES
    val coordinates: Pair<Int, Int> = Pair(2, 3)
    val coordinatesInferred = Pair(10.0, 10)
    val first = coordinatesInferred.first
    print(first)

    // Number Types
    // C based languages like Java that take up specific number of bytes
    // ie 32 bit primitive type is an int
    // and also an object version of an int called an integer
    // why are they two types that store the same number ??
    // because primitive types use less memory => better performance
    // in kotlin, all you need to use is int.
    // everything else is handled for you

    // KOTLIN HOWEVER PROVIDES NUMBER TYPES THAT USE DIFFERENT AMOUNTS OF STORAGE
    // WHOLE NUMBERS => BYTE, SHORT & LONG => 1, 2 AND 8 BYTES OF STORAGE
    // INT TAKES 4 BYTES OF STORAGE

    // FLOAT TAKES 1 AND DOUBLE TAKES 2

    // CONTROLFLOW
    val list = listOf(1, 2, 3, 4, 5)
    // for loop
    for (item in list) {
        when (item) {
            1 -> println("One")
            2 -> println("Two")
            3 -> println("Three")
            else -> println("Other")
        }
    }

    // while loop
    var count = 0
    while (count < 10) {
        println("Count is $count")
        count++
    }

    // combination of all
    val listExample = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var sum = 0

    while (sum < 20) {
        for (num in list) {
            if (num % 2 == 0) {
                sum += num
            }
        }
    }
    println("The sum of even numbers that add up to at least 20 is $sum")



    println("After their next birthday, author will be $afterAgeBirthday")





}

// What is Gradle ??
// its a dependency management tool popular in the Java Ecosystem
// it is used as the build tool for android apps


// what is the difference between debug and run in android studio ??


// what is a compile time constant ??
// this is an example tho
// facts => values marked with this must be be initialised with string or primitive type
const val comTimeConstant: Int = 100

// BASIC FUNCTION
fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

// FUNCTION WITH DEFAULT PARAMETER
fun sayHello(name: String = "Guest") {
    println("Hello, $name!")
}

// FUNCTION WITH VARIABLE LENGTH PARAMETER
fun sumNumbers(vararg numbers: Int): Int {
    var sum = 0
    for (number in numbers) {
        sum += number
    }
    return sum
}
fun multiply(number: Int, multiplier: Int): Int {
    return number * multiplier
}

// HIGHER ORDER FUNCTION
fun processNumbers(numbers: List<Int>, process: (Int) -> Int): List<Int> {
    var result = mutableListOf<Int>()
    for (number in numbers) {
        result.add(process(number))
    }
    return result
}

// EXTENSION FUNCTION
fun String.capitalizeWords(): String {
    return split(" ").joinToString(" ") { it.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } }
}


// NULLABILITY =>
var developerName = "Jesse Mensah"
var age = 31
var occupation = "Enterprenuer"

var errorCode: Int? = 101


var authorName: String? = "Jesse Amoako Mensah"
var authorAge: Int? = 31
var afterAgeBirthday = authorAge!! + 1

// ARRAYS => COLLECTIONS AND LAMBDAS
// LISTS
val innerPlanets = listOf("Mercury", "Venus", "Earth", "Mars")
val innerPlanetsArrayList = arrayListOf("Mercury", "Venus", "Earth", "Mars")
val outerPlanets = mutableListOf("Jupiter", "Saturn", "Uranus", "Neptune")


// MAPS
var yearOfBirth = mapOf(
    "Anna" to 1990,
    "Brian" to 1991,
    "Craig" to 1992,
    "Donna" to 1993
)

var namesAndScores = mutableMapOf(
    "Anna" to 2,
    "Brian" to 2,
    "Craig" to 8,
    "Donna" to 6
)

// SETS
val names = setOf("Anna", "Brian", "Craig", "Anna")


// LAMBDAS
// => A lambda expression in Kotlin is a way to define a function that can be passed
// as a parameter to another function.

val numbers = listOf(1, 2, 3, 4, 5)
val evenNumbers = numbers.filter { it % 2 == 0}

// another example
val strings = listOf("apple", "banana", "orange")
val sortedStrings = strings.sortedBy {it.length}

// Lambda expression to create a function that adds a fixed amount to a given number
fun addAmount(amount: Int): (Int) -> Int {
    return { it + amount}
}

val addTen = addAmount(10)


// BUILDING OWN TYPES
// CLASSES
class Person(var firstName: String, var lastName: String) {
    val fullName
        get() = "$firstName $lastName"
}

val jesse = Person(firstName = "Jesse", lastName = "Mensah")

// REFERENCE TYPES
class SimplePerson(val name: String)
var var1 = SimplePerson(name = "Jesse")
var var2 = var1

// METHODS AND MULTABILITY
class Grade(
    var letter: String,
    val points: Double,
    val credits: Double
)

class Student(
    val firstName: String,
    val lastName: String,
    val grades: MutableList<Grade> = mutableListOf(),
    var credits: Double = 0.0
) {
    fun recordGrade(grade: Grade) {
        grades.add(grade)
        credits += grade.credits
    }
}

val jane = Student(firstName = "Jesse", lastName = "Mensah")
var math = Grade(letter = "A", points = 16.0, credits = 4.0)



// SINGLETON => OBJECT THAT IS INSTANTIATED ONCE DURING THE LIFETIME OF THE APPLICATION

