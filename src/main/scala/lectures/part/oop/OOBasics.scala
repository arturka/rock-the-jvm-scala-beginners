package lectures.part.oop

// Class parameters are not fields

class Person(name: String, val age: Int) {

  def this(name: String) = this(name, 0)

  println("run in instantiation")

  def greet(name: String) = println(s"${this.name} says: Hi $name")

  def greet(): Unit = println(s"Hi ${this.name}")

}

object OOBasics extends App {

  val person = new Person("John", 23)
  println(person.age)
}
