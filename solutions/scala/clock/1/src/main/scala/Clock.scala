case class Clock(hour: Int, minute: Int) {
  def toMinutes: Int = hour * 60 + minute
  def -(that: Clock): Clock = Clock(this.toMinutes - that.toMinutes)
  def +(that: Clock): Clock = Clock(this.toMinutes + that.toMinutes)
}
object Clock {
  def apply(hours: Int, minutes: Int): Clock = Clock(hours * 60 + minutes)
  def apply(minutes: Int): Clock =
    if(minutes >= 0) new Clock(minutes / 60 % 24, minutes % 60)
    else Clock(1440 + (minutes % -1440))
}