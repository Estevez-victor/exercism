object Leap {
  def leapYear(year: Int): Boolean = if (year%100==0) then {if(year%400==0) then true else false} else {if(year%4==0) then true else false}
}
