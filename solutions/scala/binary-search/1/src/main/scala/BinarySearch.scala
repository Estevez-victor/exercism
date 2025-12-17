object BinarySearch{
  def find(list: List[Int], song: Int) : Option[Int] ={
    if list.isEmpty then None else
      val v = list.toVector
      findV(v,song,(0,v.size-1))
  }
  
  def findV(v: Vector[Int], song: Int, scope : (Int,Int)) : Option[Int] = {
    if(scope._1==scope._2) then{
      if(v(scope._1)==song) then Some(scope._1) else None
    }
    else if(scope._1+1==scope._2) then {
      if(v(scope._1)==song) then Some(scope._1) else
      if(v(scope._2)==song) then Some(scope._2) else None
    } else {
      val mid =(scope._2-scope._1)/2
      val cur = v(scope._1+mid)
      if(cur==song) then Some(scope._1+mid) else {
        if (cur>song) then findV(v, song , (scope._1, scope._1+mid))  
        else findV(v, song , (scope._1+mid, scope._2))
      }
    }
  }
  
}