fun main() {

  var name: String? = null

  // Using Elvis operator
  val nameLength = name?.length ?: -1 

  println("Name has $nameLength chars")
}
