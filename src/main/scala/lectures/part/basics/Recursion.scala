package lectures.part.basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println(s"Computing factorial of $n - I first need factorial of ${n - 1}")
      val result = n * factorial(n - 1)
      println(s"Computed factorial of $n")

      result
    }
  }

  def anotherFactorial(n: Int): Int = {
    def factorialHelper(x: Int, acc: Int): Int =
      if (x <= 1) acc
      else factorialHelper(x - 1, acc * x)

    factorialHelper(n, 1)
  }

  def isPrime(n: Int): Boolean = {

    @tailrec
    def isPrimeHelper(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeHelper(t - 1, n % t != 0)
    }

    isPrimeHelper(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

}
