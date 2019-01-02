package lectures.part.oop

// Class parameters are not fields

class Person(name: String, val age: Int) {

  def this(name: String) = this(name, 0)

  println("run in instantiation")

  def greet(name: String) = println(s"${this.name} says: Hi $name")

  def greet(): Unit = println(s"Hi ${this.name}")

}

class Writer(name: String, surname: String, val age: Int) {

  def fullName = s"$name $surname"
}

class Novel(name: String, releaseYear: Int, author: Writer) {

  def authorAge = author.age

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newReleaseYear: Int) = this(name, newReleaseYear, author)
}

object OOBasics extends App {

  val person = new Person("John", 23)
  println(person.age)
}
