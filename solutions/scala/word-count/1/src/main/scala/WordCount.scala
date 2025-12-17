class WordCount(text: String){
  def countWords : Map[String,Int] = {
    text.split("(\\s|,|:|!|&|@|\\$|%|\\^|&|\\.)+").foldLeft(Map(): Map[String,Int])((map,mot)=>
      myFormat(mot) match{
        case "" => map
        case fmot =>
          map.updatedWith(myFormat(fmot)){
            case Some(i) => Some(i+1)
            case None => Some(1)
          }
      }
    )
  }
    def myFormat(mot: String): String = mot.toList match {
    case '\'' +: m :+ '\'' => m.mkString.toLowerCase()
    case _ => mot.toLowerCase()
  }
}