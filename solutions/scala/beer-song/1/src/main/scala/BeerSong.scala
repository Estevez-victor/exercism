import annotation.tailrec
object BeerSong{
  def recite(bottle:Int,turn:Int) : String =  reciteTail(StringBuilder(),bottle,turn).toString
  @tailrec
  def reciteTail(song:StringBuilder,bottle:Int,turn:Int) : StringBuilder = (bottle, turn) match{
  case (_,0) => song
  case (1,1) => song ++= "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
  case (0,1) => song ++= "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
  case (1,_) => reciteTail(song++=s"$bottle ${plural(bottle)} of beer on the wall, $bottle ${plural(bottle)} of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n${lastTurn(turn)}",bottle-1,turn-1)
  case (_,_) => reciteTail(song++=s"$bottle ${plural(bottle)} of beer on the wall, $bottle ${plural(bottle)} of beer.\nTake one down and pass it around, ${bottle-1} ${plural(bottle-1)} of beer on the wall.\n${lastTurn(turn)}",bottle-1,turn-1)
  }
  def plural(x:Int):String= if(x>1) then "bottles" else "bottle"
  def lastTurn(x:Int):String = if(x>1) then "\n" else ""
}