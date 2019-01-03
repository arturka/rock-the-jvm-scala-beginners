package lectures.part.oop

object Generics extends App {

  abstract class List[+A] {
    def add[B >: A](elem: B): List[B]
    def isEmpty: Boolean
    def head: A
    def tail: List[A]
    def filter(predicate: MyPredicate[A]): List[A]
    def map[B](transformer: MyTransformer[A, B]): List[B]
    def flatMap[B](transformer: MyTransformer[A, List[B]]): List[B]
    def ++[B >: A](list: List[B]): List[B]
  }

  object Empty extends List[Nothing] {
    override def add[B >: Nothing](elem: B): List[B] = new GenericList(elem, Empty)

    override def isEmpty: Boolean = true

    override def head: Nothing = throw new NoSuchElementException()

    override def tail: List[Nothing] = throw new NoSuchElementException()

    override def filter(predicate: MyPredicate[Nothing]): List[Nothing] = Empty

    override def map[B](transformer: MyTransformer[Nothing, B]): List[B] = Empty

    override def flatMap[B](transformer: MyTransformer[Nothing, List[B]]): List[B] = Empty

    override def ++[B >: Nothing](list: List[B]): List[B] = Empty
  }

  class GenericList[+A](elem: A, reminder: List[A]) extends List[A] {
    override def add[B >: A](elem: B): List[B] = new GenericList(elem, this)

    override def isEmpty: Boolean = false

    override def head: A = elem

    override def tail: List[A] = reminder

    override def filter(predicate: MyPredicate[A]): List[A] = {
      if (predicate.test(elem)) new GenericList(elem, reminder.filter(predicate))
      else reminder.filter(predicate)
    }

    override def map[B](transformer: MyTransformer[A, B]): List[B] = {
      new GenericList(transformer.transform(elem), reminder.map(transformer))
    }

    def ++[B >: A](list: List[B]): List[B] = new GenericList[B](elem, reminder ++ list)

    override def flatMap[B](transformer: MyTransformer[A, List[B]]): List[B] = {
      transformer.transform(elem) ++ reminder.flatMap(transformer)
    }
  }

  trait MyPredicate[-T] {
    def test(elem: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform(elem: A): B
  }

}
