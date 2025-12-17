object MatchingBrackets {
def isPaired(brackets: String): Boolean = {
    val onlyb : String = brackets.foldLeft("")((a,b)=> if {"[](){}".contains(b)} then {a.+(b)} else{a})
    def check(in : List[Char], pile: List[Char]) : Boolean =(in, pile) match {
      case (Nil, Nil) => true
      case (inHead :: inTail, _) => if("([{".contains(inHead)) then check(inTail, inHead+:pile) 
      else{ 
      if(pile.isEmpty||(!matching(pile.head, inHead))) then false else check(inTail, pile.tail) 
      }
      case _ => false
    }
    def matching(head: Char, last: Char): Boolean= (head, last) match{
      case ('[',']') => true
      case ('(',')') => true
      case ('{','}') => true
      case _ => false
    }
    println(onlyb)
    check(onlyb.toList, Nil)
  }
}
