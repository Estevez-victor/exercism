case class Triangle(a:Double,b:Double,c:Double){
  def equilateral : Boolean = realTriangle && a==b && a==c
  def isosceles : Boolean = realTriangle && a==b || a==c || b==c
  def scalene : Boolean = realTriangle && a!=b && a!=c && b!=c
  def realTriangle : Boolean = a>0 && b>0 && c>0 && a+b>c && a+c>b && b+c>a
}