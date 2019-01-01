package lectures.part.basics

object Expressions extends App {

  val x = 1 + 2 // Expression

  println(1 + 2 * 3)
  // + - * / & | ^ << >> >>>

  println(1 == x)
  // == != > >= <= <

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // -= *= /=

  // Instructions (DO (Imperative Languages)) vs Expressions (VALUE)

  // IF Expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3

  println(if (aCondition) 5 else 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  val aWeirdValue = (aVariable = 4)

  // side effects: println(), whiles, reassigning

  val codeBlock = {
    val x = 3
    val y = 4

    x > y
  }

  println(codeBlock)

}
