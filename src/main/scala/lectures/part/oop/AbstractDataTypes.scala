package lectures.part.oop

object AbstractDataTypes {

  abstract class Animal {
    val creatureType: String
    def eat: Unit
    def common: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "domestic"

    override def eat: Unit = println("Yeap yeap")

    override def common: Unit = println("common")
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
    def common: Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "wild"

    override def eat: Unit = println("crunch crunch")

    override def eat(animal: Animal): Unit = println(s"croc eating a ${animal.creatureType}")

    override def common: Unit = ()
  }
}
