object SecretHandshake{
  def commands(number: Int) : List[String] = if(number<=0 | number>31) then List() else{
    val fill = number.toBinaryString.reverse.foldLeft((0, List():List[String]))((a,b) =>
    a._1 match{
    case 0 => if(b=='0') then (a._1+1,a._2) else (a._1+1,a._2:+"wink")
    case 1 => if(b=='0') then (a._1+1,a._2) else (a._1+1,a._2:+"double blink")
    case 2 => if(b=='0') then (a._1+1,a._2) else (a._1+1,a._2:+"close your eyes")
    case 3 => if(b=='0') then (a._1+1,a._2) else (a._1+1,a._2:+"jump")
    case 4 => if(b=='0') then (a._1+1,a._2) else (a._1+1,a._2.reverse)
    }
    )
    fill._2
  }
}