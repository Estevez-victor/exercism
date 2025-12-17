object NthPrime{

  def prime(x:Int) : Option[Int] = if (x<1) then None else Some(primeList(x)(x-1))

  @annotation.tailrec
  def primeList(size: Int, cur: Int=1, l: List[Int]=List(2)) : List[Int] = cur==size match{
    case true => l.reverse
    case false => primeList(size, cur+1, l.prepended(nextPrime(l.head)))
  }
  
  def isPrime(x:Int) : Boolean = if x==2||x==3 then true else if (x<=1||x%2==0||x%3==0) then false else {
    !((5).to((math.sqrt(x).toInt),6).exists(i => x % i == 0 || x % (i + 2) == 0))
  }
  
  @annotation.tailrec
  def nextPrime(x:Int) : Int = isPrime(x+1) match {
   case true => x+1
   case false => nextPrime(x+1)
  }
  
}