package com.example.autoloancalculator

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
  @Test
  fun addition_isCorrect() {
    assertEquals(4, 2 + 2)
  }

  @Test
  fun monthlyPaymentShouldBeZeroIfLoanAmountIsZero() {
    val monthlyPayment = calculateMonthlyPayment(0.0, 12.0, 360)
    assertEquals(0.0, monthlyPayment, 0.0)
  }

  @Test
  fun greetingShouldReturnHelloIfNameIsEmpty() {
    val greeting = greeting("")
    assertEquals("Hello!", greeting)
  }

  @Test
  fun greetingShouldReturnHelloNameIfNameIsNotEmpty() {
    val greeting = greeting("John")
    assertEquals("Hello John!", greeting)
  }
}