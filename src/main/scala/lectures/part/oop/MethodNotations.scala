package lectures.part.oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def learns(thing: String = "Scala") = s"$name is learns $thing"
    def +(person: Person): String = s"${this.name} hanging out with ${person.name}"
    def +(name: String): Person = new Person(name, favoriteMovie)
    def unary_! : String = name
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is $name"
    def apply(num: Int): String = s"Mary watched ${this.favoriteMovie} $num times"
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
  println(mary learns())

  println((mary + "the rockstar").apply())
  println((+mary).age)
  println(mary(10))
}
