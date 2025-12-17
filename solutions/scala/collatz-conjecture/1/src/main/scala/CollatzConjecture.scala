object CollatzConjecture{
  def steps(x:Int) : Option[Int] = turns(0,x)
  @scala.annotation.tailrec
  def turns(step:Int, cur:Int) : Option[Int] = if(cur>0) then (cur,cur%2) match{
    case (1,_) => Some(step)
    case (_,0) => turns(step+1, cur/2)
    case (_,1) => turns(step+1, (3*cur)+1)
  } else None

}