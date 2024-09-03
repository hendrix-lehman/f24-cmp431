abstract class MyAbstractClass {
  abstract fun doSomething()
}

fun main() {
  val myAbstractClass = object : MyAbstractClass() {
    override fun doSomething() {
      println("Doing something")
    }
  }
  myAbstractClass.doSomething()

  val anotherAbstractClass = object : MyAbstractClass() {
    override fun doSomething() {
      println("Something Different")
    }
  }
  anotherAbstractClass.doSomething()
}

