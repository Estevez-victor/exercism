/*
object PrimeFactors{
  def factors(x:Long) : List[Int] = factoring(x, List())

  def isPrime(x:Int) : Boolean = if x==2||x==3 then true else if (x<=1||x%2==0||x%3==0) then false else {
    !((5).to((math.sqrt(x).toInt),6).exists(i => x % i == 0 || x % (i + 2) == 0))
  }
  @annotation.tailrec
  def nextPrime(x:Int) : Int = isPrime(x+1) match {
   case true => x+1
   case false => nextPrime(x+1)
  }
  @annotation.tailrec
  private def smallestPrimeDivision(num:Long, div:Int=2) : (Long,Int) =  num%div==0 match{
   case true => (num/div,div)
   case false => smallestPrimeDivision(num,nextPrime(div))
  }
  @annotation.tailrec
  private def factoring(num:Long, l: List[Int]) : List[Int] = num match{
    case 1 => l.reverse
    case _ => {val spd = smallestPrimeDivision(num,2);
    factoring(spd._1,l.prepended(spd._2))
    }
  }
}
*/
object PrimeFactors{
  def factors(x:Long) : List[Int] = factoring(x,2,List())
  @annotation.tailrec
  def factoring(x:Long,div:Int ,l:List[Int]) : List[Int] =  if(x!=1) then x%div==0 match{
    case true => factoring(x/div.toLong , 2 ,l.prepended(div))
    case false => factoring(x , div+1 ,l)
  } else l.reverse
}