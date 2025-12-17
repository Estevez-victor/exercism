import java.time.{DayOfWeek, LocalDate}

import Schedule.Schedule

case class Meetup(month: Int, year: Int) {
  def day(dayOfWeek: Int, schedule: Schedule): LocalDate = 
    val firstDayOfWeek : Int = LocalDate.of(year, month, 1).getDayOfWeek.getValue match{
      case d if d < dayOfWeek => (dayOfWeek-d)+1
      case d if d > dayOfWeek => 8-(d-dayOfWeek)
      case _ => 1
    }
    val dateOfFirstDayOfWeek : LocalDate = LocalDate.of(year, month, firstDayOfWeek)
    println(firstDayOfWeek)
    println(dateOfFirstDayOfWeek)
    schedule match{
    case Schedule.Teenth => firstDayOfWeek+7 match{
      case fdowps if fdowps > 12 && fdowps < 20 => dateOfFirstDayOfWeek.plusDays(7)
      case _ => dateOfFirstDayOfWeek.plusDays(14)
    }
    case Schedule.First => dateOfFirstDayOfWeek
    case Schedule.Second => dateOfFirstDayOfWeek.plusDays(7)
    case Schedule.Third => dateOfFirstDayOfWeek.plusDays(14)
    case Schedule.Fourth => dateOfFirstDayOfWeek.plusDays(21)
    case Schedule.Last => {val in28days = dateOfFirstDayOfWeek.plusDays(28)
      if(in28days.getMonth()==dateOfFirstDayOfWeek.getMonth()) 
      then in28days else dateOfFirstDayOfWeek.plusDays(21)}
  }
}
object Meetup {
  val Mon = DayOfWeek.MONDAY.getValue
  val Tue = DayOfWeek.TUESDAY.getValue
  val Wed = DayOfWeek.WEDNESDAY.getValue
  val Thu = DayOfWeek.THURSDAY.getValue
  val Fri = DayOfWeek.FRIDAY.getValue
  val Sat = DayOfWeek.SATURDAY.getValue
  val Sun = DayOfWeek.SUNDAY.getValue
}

object Schedule extends Enumeration {
  type Schedule = Value
  val Teenth, First, Second, Third, Fourth, Last = Value
}