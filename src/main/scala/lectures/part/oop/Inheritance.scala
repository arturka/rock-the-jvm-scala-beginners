package lectures.part.oop

object Inheritance extends App {

  class Person(val  name: String, age: Int) {
    def this() = this("default name", 0)
  }

  class Student(name: String, age: Int, id: String) extends Person {

    override def toString: String = s"$name $age $id"
  }

  println(new Student("Artur", 23, "15BD02044").name)

}
