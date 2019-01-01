package lectures.part.basics

class CBNvsCBV extends App {

  def calledByName(x: Long): Unit = {
    println(s"by name: $x")
    println(s"by name: $x")
  }

  def calledByValue(x: => Long): Unit = {
    println(s"by value: $x")
    println(s"by value: $x")
  }

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, b: => Int) = println(x)

  println(printFirst(23, infinite()))
}
