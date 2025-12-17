class DNA(dna: String){
  
  def nucleotideCounts : Either[String, Map[Char, Int]] = count(dna) match{
    case Right((a,c,g,t)) => Right(Map('A'->a,'C'->c,'G'->g,'T'->t))
    case _ => Left("error")
  }

  @annotation.tailrec
  private def count(curdna : String, a : Int=0, c : Int=0, g : Int=0, t : Int=0) : Either[String, (Int,Int,Int,Int)] = {
    if curdna.isEmpty() then Right(a,c,g,t)
    else{
      curdna.head match{
        case 'A' => count(curdna.tail,a+1,c,g,t)
        case 'C' => count(curdna.tail,a,c+1,g,t)
        case 'G' => count(curdna.tail,a,c,g+1,t)
        case 'T' => count(curdna.tail,a,c,g,t+1)
        case _ => Left("")
      }
    }
  }
  
}