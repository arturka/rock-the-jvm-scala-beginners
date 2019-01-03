package exercises

abstract class MyList {

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(elem: Int): MyList
}

object Empty extends MyList {
  override def head: Int = throw new Exception("head of empty list")

  override def tail: MyList = this

  override def isEmpty: Boolean = true

  override def add(elem: Int): MyList = new List(elem, Empty)
}

class List(elem: Int, reminder: MyList) extends MyList {
  override def head: Int = elem

  override def tail: MyList = reminder

  override def isEmpty: Boolean = false

  override def add(elem: Int): MyList = new List(elem, this)
}
