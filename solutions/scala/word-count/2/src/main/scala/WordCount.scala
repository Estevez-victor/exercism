class WordCount(text: String){
  def countWords : Map[String,Int] = {
    text.split("(\\s|,|:|!|&|@|\\$|%|\\^|&|\\.)+").foldLeft(Map(): Map[String,Int])((map,word)=>
      myFormat(word) match{
        case "" => map
        case fword => map + (fword -> (map.getOrElse(fword,0) + 1))
      }
    )
  }
    def myFormat(word: String): String = word.toList match {
    case '\'' +: m :+ '\'' => m.mkString.toLowerCase()
    case _ => word.toLowerCase()
  }
}