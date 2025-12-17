object SpaceAge {
  def toYear(ageS: Double): Double = ageS/31557600
  def onEarth(age: Double): Double = toYear(age)

  def onVenus(age: Double): Double = toYear(age)/0.61519726

  def onMercury(age: Double): Double = toYear(age)/0.2408467

  def onMars(age: Double): Double = toYear(age)/1.8808158

  def onJupiter(age: Double): Double = toYear(age)/11.862615

  def onSaturn(age: Double): Double = toYear(age)/29.447498

  def onUranus(age: Double): Double = toYear(age)/84.016846

  def onNeptune(age: Double): Double = toYear(age)/164.79132
}
