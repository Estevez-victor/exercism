val NumberOfChar = 2
val NumberOfDigit = 3
def nameGen(nbChar: Int, nbDig: Int) : String = {
  val rand = new scala.util.Random
//uppercase: 65-90
(List.fill(nbChar)(rand.between(65, 91).toChar):::List.fill(nbDig)(rand.nextInt(10)).map(_.toString.head)).mkString
}
case class Robot(var name: String=nameGen(NumberOfChar,NumberOfDigit)){
 def reset() = name = nameGen(NumberOfChar, NumberOfDigit)
}