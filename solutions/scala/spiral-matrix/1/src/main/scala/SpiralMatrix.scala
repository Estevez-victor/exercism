import scala.collection.mutable.ArrayBuffer
object Direction extends Enumeration {
  type Finger = Value

  val GoRight, GoDown, GoLeft, GoUp = Value
}
object SpiralMatrix{

  def spiralMatrix(x:Int) = {
    if(x<1) then List() else{
    val matrix = ArrayBuffer.fill(x)(ArrayBuffer.fill(x)(0))
    for i <- (1 to x) do {
      matrix(0)(i-1)=i
    }
    fillRest(x-1,x,(0,x-1), matrix)
    matrix
    }
  }
  @annotation.tailrec
  def fillRest(step:Int, cpt:Int, pos:(Int,Int), m:ArrayBuffer[ArrayBuffer[Int]], dir:Direction.Value=Direction.GoDown, switch: Boolean = false): Unit= step match{
    case 0 => 
    case _ => dir match{
      case Direction.GoRight => {
        var c = cpt
        for i <- (1 to step) do {c=c+1; m(pos._1)(pos._2+i)=c}
        fillRest(if(switch) then step-1 else step, c, (pos._1,pos._2+step),m,changeDir(dir),!switch)
      }
      case Direction.GoDown => {
        var c = cpt
        for i <- (1 to step) do {c=c+1;  m(pos._1+i)(pos._2)=c}
        fillRest(if(switch) then step-1 else step, c, (pos._1+step,pos._2),m,changeDir(dir),!switch)
      }
      case Direction.GoLeft => {
        var c = cpt
        for i <- (1 to step) do {c=c+1; m(pos._1)(pos._2-i)=c}
        fillRest(if(switch) then step-1 else step, c, (pos._1,pos._2-step),m,changeDir(dir),!switch)
      }
      case Direction.GoUp =>{
        var c = cpt
        for i <- (1 to step) do {c=c+1; m(pos._1-i)(pos._2)=c}
        fillRest(if(switch) then step-1 else step, c, (pos._1-step,pos._2),m,changeDir(dir),!switch)
      }
    }
  }
  def changeDir(dir:Direction.Value)=  dir match{
      case Direction.GoRight => Direction.GoDown
      case Direction.GoDown => Direction.GoLeft
      case Direction.GoLeft => Direction.GoUp
      case Direction.GoUp => Direction.GoRight
    }
}