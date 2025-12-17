object Hamming {
  def distance(dnaStrandOne: String, dnaStrandTwo: String): Option[Int] = if(dnaStrandOne.length!=dnaStrandTwo.length) then None
  else{Some({
  dnaStrandOne.zip(dnaStrandTwo).foldLeft(0)((cpt,ot)=>if(ot._1==ot._2) then cpt else cpt+1)
  })
  }
}
