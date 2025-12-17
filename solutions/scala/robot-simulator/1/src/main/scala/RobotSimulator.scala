object Bearing extends Enumeration {
  val North, East, South, West = Value
}

case class Robot (facing : Bearing.Value, pos: (Int,Int)) {
  
  def coordinates = pos
  def bearing = facing
  
  def turnRight : Robot = facing match{
    case Bearing.North => Robot(Bearing.East, pos)
    case Bearing.East => Robot(Bearing.South, pos)
    case Bearing.South => Robot(Bearing.West, pos)
    case Bearing.West => Robot(Bearing.North, pos)
  }
  
  def turnLeft : Robot = facing match{
    case Bearing.North => Robot(Bearing.West, pos)
    case Bearing.East => Robot(Bearing.North, pos)
    case Bearing.South => Robot(Bearing.East, pos)
    case Bearing.West => Robot(Bearing.South, pos)
  }

  def advance : Robot = facing match{
    case Bearing.North => Robot(Bearing.North, (pos._1,pos._2+1))
    case Bearing.East => Robot(Bearing.East, (pos._1+1,pos._2))
    case Bearing.South => Robot(Bearing.South, (pos._1,pos._2-1))
    case Bearing.West => Robot(Bearing.West, (pos._1-1,pos._2))
  }

  def simulate(inst: String) : Robot = inst.foldLeft(this)((robo,i)=> i match {
  case 'L' => robo.turnLeft
  case 'R' => robo.turnRight
  case 'A' => robo.advance
  })
  
}