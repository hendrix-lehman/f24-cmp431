fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

fun main() {
    val array = arrayOfMinusOnes(5)
    println(array.joinToString())
}
