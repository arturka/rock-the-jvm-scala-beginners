package lectures.part.oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  val person1 = Person("Test", 10)
  val person2 = Person("Test", 10)


  println(person1 == person2)
  println(person1.hashCode() == person2.hashCode())
}
