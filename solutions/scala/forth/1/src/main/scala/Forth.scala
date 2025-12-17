/*object ForthError extends Enumeration {
  type ForthError = Value 
  val DivisionByZero, StackUnderflow, InvalidWord, UnknownWord = Value
}*/

case class ForthResult(in:List[String]) extends ForthEvaluatorState{
    override def toString(): String = in.mkString(" ")
}

class Forth extends ForthEvaluator {
  
  def eval(text: String) : Either[ForthError.ForthError, ForthEvaluatorState] ={
    var dico = Map.apply("+"->"+", "-"->"-",  "*"->"*", "/"->"/", "dup"->"dup", "drop"->"drop", "swap"->"swap", "over"->"over")
    val iter = text.split(";")
    iter.map(l=> l.split(" ").filterNot(e=> e.isEmpty || e==":")).dropRight(1).map(f=> {
      val oo = f.tail.map(x=> if dico.contains(x) then dico(x) else x)
      if(f.head.forall(_.isDigit)) then dico=dico.empty
      else dico=dico.updated(f.head.toLowerCase(),oo.mkString(" ").toLowerCase)
    })
    if dico.isEmpty then 
    Left(ForthError.InvalidWord)
    else{
      val stack= iter.reverse.head.split(" ").foldLeft(List():List[String])((l,s)=> {
        val smalls = s.toLowerCase()
        if(dico.contains(smalls)) then dico(smalls).split(" ").toList.reverse ::: l 
        else if(smalls.isEmpty) then l 
        else if(smalls.forall(_.isDigit)) then smalls+:l
        else List("invalid word")
      })
      if stack.contains("invalid word") then Left(ForthError.InvalidWord) else making(stack)
    }
  }

  def making(s: List[String], res: List[String]=List()) : Either[ForthError.ForthError, ForthEvaluatorState] = {
    s match{
      case Nil => Right(ForthResult(res))
      case head :: tail => if (head.forall(_.isDigit)) then making(tail, head+:res) 
        else{
          val e = eval(head, tail)
          e._1 match{
            case "Error" => Left(ForthError.UnknownWord)
            case "drop" => making (e._2, res)
            case _ => making(e._2,e._1+:res)
          }
        }
    }
  }
  
  def eval(op: String, s: List[String]) : (String, List[String]) = op match{
    case "+" => s match{
      case one :: two :: tail => (one.forall(_.isDigit), two.forall(_.isDigit)) match {
        case (true, true) => ((one.toInt+two.toInt).toString ,tail)
        case (false, _) => ("Error",Nil)
        case (true, false) => val twoc=eval(two, tail); ((one.toInt+twoc._1.toInt).toString ,twoc._2)
      }
      case _ => ("Error",Nil)
    }
    case "-" => s match{
      case one :: two :: tail => (one.forall(_.isDigit), two.forall(_.isDigit)) match {
        case (true, true) => ((two.toInt-one.toInt).toString ,tail)
        case (false, _) => ("Error",Nil)
        case (true, false) => val twoc=eval(two, tail); ((twoc._1.toInt-one.toInt).toString ,twoc._2)
      }
      case _ => ("Error",Nil)
    }
    case "*" => s match{
      case one :: two :: tail => (one.forall(_.isDigit), two.forall(_.isDigit)) match {
        case (true, true) => ((one.toInt*two.toInt).toString ,tail)
        case (false, _) => ("Error",Nil)
        case (true, false) => val twoc=eval(two, tail); ((one.toInt*twoc._1.toInt).toString ,twoc._2)
      }
      case _ => ("Error",Nil)
    }
    case "/" => s match{
      case one :: two :: tail => (one.forall(_.isDigit), two.forall(_.isDigit)) match {
        case (true, true) => if(one.toInt==0)then ("Error",Nil) else ((two.toInt/one.toInt).toString ,tail)
        case (false, _) => ("Error",Nil)
        case (true, false) =>  if(one.toInt==0) then ("Error",Nil) else {val twoc=eval(two, tail); ((twoc._1.toInt/one.toInt).toString ,twoc._2)}
      }
      case _ => ("Error",Nil)
    }
    case "dup" => s match{
      case Nil => ("Error",Nil)
      case head :: tail => if head.forall(_.isDigit) then (head ,s) else {val next= eval(head,tail);(next._1, next._1+:next._2) }
    }
    case "drop" => s match{
      case Nil => ("Error",Nil)
      case head :: tail => if head.forall(_.isDigit) then ("drop", tail) else if head=="drop" then dropSeveral(tail) else ("drop", eval(head, tail)._2)
    }
    case "swap" => s match{
      case one :: two :: tail => (one.forall(_.isDigit), two.forall(_.isDigit)) match {
        case (true, true) => (two,one+:tail)
        case (false, _) => ("Error",Nil)
        case (true, false) => val next=eval(two, tail); (next._1 ,one+:next._2)
      }
      case _ => ("Error",Nil)
    }
    case "over" => s match{
      case one :: two :: tail => if(two.forall(_.isDigit)) then (two, s) else {val next=eval(two, tail); (next._1, s)}
      case _ => ("Error",Nil)
    }
  }
  
  def dropSeveral(tail: List[String], nbd: Int=2) : (String, List[String]) = (tail, nbd) match{
    case ("drop"::t,_) => dropSeveral(t,nbd+1)
    case (h::t, 1) => if h.forall(_.isDigit) then ("drop",t) else ("drop",eval(h,t)._2)
    case (h::Nil, _) => ("Error",Nil)
    case (h::t,_) => if h.forall(_.isDigit) then dropSeveral(t, nbd-1) else dropSeveral(eval(h,t)._2, nbd-1)
    case (Nil, _) => ("Error",Nil)
  }
  
}