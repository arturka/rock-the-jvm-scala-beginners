package lectures.part.oop

object Generics extends App {

  abstract class List[+A] {
    def add[B >: A](elem: B): List[B]
    def isEmpty: Boolean
    def head: A
    def tail: List[A]
  }

  object Empty extends List[Nothing] {
    override def add[B >: Nothing](elem: B): List[B] = new GenericList(elem, Empty)

    override def isEmpty: Boolean = true

    override def head: Nothing = throw new NoSuchElementException()

    override def tail: List[Nothing] = throw new NoSuchElementException()
  }

  class GenericList[+A](elem: A, reminder: List[A]) extends List[A] {
    override def add[B >: A](elem: B): List[B] = new GenericList(elem, this)

    override def isEmpty: Boolean = false

    override def head: A = elem

    override def tail: List[A] = reminder
  }

}
