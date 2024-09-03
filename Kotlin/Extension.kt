
fun String.addExclemationMark() = "$this!!!" // Extension function

fun main() {
    val name = "Kotlin"
    val someString = "Some String"
    println(name.addExclemationMark()) // Kotlin!
    println(someString.addExclemationMark()) // Some String!
}
