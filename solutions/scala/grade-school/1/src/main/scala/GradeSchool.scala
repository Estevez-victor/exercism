class School {
  var dico = Map.empty[Int, Seq[String]]
  
  type DB = Map[Int, Seq[String]]

  def add(name: String, g: Int) = {dico = dico + (g->{db.get(g) match
    case Some(s) => s.:+(name)
    case None => List(name)
    })
  }

  def db: DB = dico

  def grade(g: Int): Seq[String] = dico.getOrElse(g, List())

   def sorted: DB = {dico = dico.toSeq.sortBy(_._1).map((num,lname)=> (num, lname.sorted)).toMap
  dico}
  
}