package lectures.part.basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  def aParameterlessFunction(): Int = 3
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  aRepeatedFunction("hello", 3)

  def aFunctionWithSideEffect(string: String): Unit = println(string)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n + 1)
  }

  def factorial(n: Int): Int = {

    @tailrec
    def sum(agr: Int = 1, i: Int): Int = {
      if (i <= 0) agr
      else sum(agr * i, i - 1)
    }

    sum(1, n)
  }

  println(factorial(5))

  def isPrime(n: Int) = {

    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t == 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }
}
