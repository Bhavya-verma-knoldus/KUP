import scala.language.implicitConversions

object ImplicitParameter extends App {

  implicit val myName: String = "Bhavya"
  implicit val myAnotherName: Int = 10

  def display(implicit name: String): Unit = {
    println(s"My name is $name")
  }

  def double(implicit value: Int): Int = {
    value * 2
  }

//  println("Double value: " + double)
//  display
//
//  display("Rahul")

  val implicitConversion = new ImplicitConversion

  implicitConversion.display()
}

class ImplicitConversion {
  implicit def doubleToInt(value: Double): Int = value.toInt
//  implicit def convertDoubleToInt(value: Double): Int = value.toInt

  val doubleValue: Int = 5.7

  def display(): Unit = {
    println("doubleValue: " + doubleValue)
  }
}
