package lectures.part.oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} hanging out with ${person.name}"
    def unary_! : String = name
    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is $name"
  }

  val mary = new Person("Mart", "Inception")
  println(mary.likes("Inception"))
  // infix notation
  println(mary likes "Inception")

  val tom = new Person("Tom", "Fight Club")

  println(mary.+(tom))

  val x = -1 // 1.unary_-

  println(!tom)
  println(tom isAlive)
  println(mary())
}
