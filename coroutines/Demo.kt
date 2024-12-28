import kotlinx.coroutines.*

fun main() {

  runBlocking {
    println("Weather forecast")
    launch {
      printForecast()
    }
    launch {
      printTemperature()
    }
  }
}

suspend fun printForecast() {
  delay(1000)
  println("Sunny")
}

suspend fun printTemperature() {
  delay(1000)
  println("25°C")
}
