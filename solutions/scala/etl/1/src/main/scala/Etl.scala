object Etl {
  def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] = {
  scoreMap.foldLeft(Seq(): Seq[(String, Int)])((out,scma)=> 
  out++{for(letters <- scma._2) yield ((letters.toLowerCase(),scma._1))} 
  ).toMap
  }
}