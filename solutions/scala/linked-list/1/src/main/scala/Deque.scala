case class Station[T](characteristic: T, var prev: Option[Station[T]], var next: Option[Station[T]]){
  override def toString: String = {
    if next.isDefined then
      s"($characteristic)"+next.get.toString
    else
      s"($characteristic)"
  }
}
case class Deque[T](var first: Option[Station[T]], var last: Option[Station[T]]){
  override def toString: String = {
    if first.isDefined then
      first.get.toString
    else "()"
  }
  def push(charac: T) : Unit ={
    if first.isDefined then 
      val newStation=Some(Station[T](charac,last,None))
      last.get.next= newStation
      last=newStation
    else 
      val onlyStation=Some(Station[T](charac,None, None))
      first=onlyStation
      last=onlyStation
  }
  def pop : Option[T] = {
    if first.isDefined then{
      val poppedOut= Some(last.get.characteristic)
      if first==last then {first=None; last=None} else last=last.get.prev
      poppedOut
    }
    else None
  }
  def unshift(charac: T) : Unit ={
    if first.isDefined then 
      val newStation=Some(Station[T](charac,None,first))
      first.get.prev=newStation
      first=Some(Station[T](charac,None,first))
    else 
      val onlyStation=Some(Station[T](charac,None, None))
      first=onlyStation
      last=onlyStation
  }
  def shift : Option[T] = {
    if first.isDefined then{
      val shiftedOut= Some(first.get.characteristic)
      if first==last then {first=None; last=None} else first=first.get.next
      shiftedOut
    }
    else None
  }
}
object Deque{
  def apply[T]() : Deque[T] = new Deque[T](None,None)
  def apply[T](onlyone: Option[Station[T]]) : Deque[T] = new Deque[T](onlyone, onlyone)
}