trait SimpleLinkedList[T] {
  def isEmpty: Boolean
  def value: T
  def add(item: T): SimpleLinkedList[T]
  def next: SimpleLinkedList[T]
  def reverse: SimpleLinkedList[T]
  def toSeq: Seq[T]
}
case class EndOfLinkedList[T]() extends SimpleLinkedList[T]{
  def isEmpty: Boolean = true
  def value: T = throw new IllegalAccessException
  def add(item: T): SimpleLinkedList[T] = Node(item,this)
  def next: SimpleLinkedList[T] = throw new IllegalAccessException
  def reverse: SimpleLinkedList[T] = this
  def toSeq: Seq[T] = Seq()
}
case class Node[T](chara: T, var nextNode: SimpleLinkedList[T]) extends SimpleLinkedList[T]{
  def isEmpty: Boolean = false
  def value: T = chara
  def add(item: T): SimpleLinkedList[T] = next match{
    case EndOfLinkedList() => {nextNode=Node(item,nextNode); this}
    case Node(_,_) => {nextNode.add(item);this}
  }
  def next: SimpleLinkedList[T] = nextNode
  def reverse: SimpleLinkedList[T] = SimpleLinkedList.fromSeq(this.toSeq.reverse)
  def toSeq: Seq[T] = chara +: next.toSeq
}
object SimpleLinkedList{
  def apply[T](): SimpleLinkedList[T] = EndOfLinkedList[T]()
  def apply[T](values: T*): SimpleLinkedList[T] = fromSeq(values)
  def fromSeq[T](values: Seq[T]): SimpleLinkedList[T] = values.foldLeft(SimpleLinkedList())((sll,chara)=>sll.add(chara))
}