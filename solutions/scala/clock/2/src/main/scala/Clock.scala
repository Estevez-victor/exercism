case class Clock(hour: Int, minute: Int) {
  def +(other: Clock) :Clock = (Clock(this.inMinutes+other.inMinutes))
  def -(other: Clock) :Clock = (Clock(this.inMinutes-other.inMinutes))
  def inMinutes : Int = hour*60+minute
}
object Clock {
  def apply(hour:Int,minute:Int) : Clock = 
    if hour>= 0 then Clock(hour*60+minute)
    else Clock((hour%24+24)*60+minute)
  def apply(minute: Int) : Clock = 
    if minute>=0 then new Clock((minute/60)%24, minute%60)
    else new Clock(23-((minute/60)*(-1)%24) ,if minute<(-60) then 60-(minute%60*(-1)) else minute+60)
  def apply() :Clock = Clock(0)
}
