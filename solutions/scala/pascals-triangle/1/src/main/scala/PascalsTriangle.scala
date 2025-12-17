import scala.annotation.tailrec

object PascalsTriangle{

  def rows(x: Int) : List[List[Int]] = if (x>=0) then makePTriangle(List(),0,x) else List()
  
  @tailrec
  def makePTriangle(total : List[List[Int]], cpt : Int, depth : Int) : List[List[Int]] = cpt==depth match{
  case true => total.reverse
  case false => if(cpt>0) then {makePTriangle(total.prepended(nextLine(total(0))), cpt+1, depth) } else makePTriangle(List(List(1)), cpt+1, depth)
  }
  
  
  def nextLine(prevLine : List[Int]) : List[Int] = prevLine.length match{
  case 1 => List(1,1)
  case _ =>{
  var cur = List(1) : List[Int]
  var i = 0 
  while(i<prevLine.length-1){
  cur = cur.prepended(prevLine(i)+prevLine(i+1))
  i=i+1
  }
  cur = cur.prepended(1)
  cur
  }
  }
}