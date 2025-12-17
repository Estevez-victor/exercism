object ArmstrongNumbers{
  def isArmstrongNumber(x:Int) : Boolean = x==x.toString.foldLeft(0)((res,b)=>res+power(b.asDigit,x.toString.length()))
  def power(num:Int, pow:Int) : Int = {var res = num;(1 to pow-1).foreach(_=>res=res*num);res}
}