object Bob {
  def response(statement: String): String = statement.filterNot(_.isWhitespace) match{
    case "" => "Fine. Be that way!"
    case sta => {val staFiltered = sta.filter(_.isLetter);
    (!staFiltered.isEmpty && staFiltered.toUpperCase()==staFiltered, sta.last) match{
    case (true, '?') => "Calm down, I know what I'm doing!"
    case (false, '?') => "Sure."
    case (true, _) => "Whoa, chill out!"
    case _ => "Whatever."
    }
    }
  }
}