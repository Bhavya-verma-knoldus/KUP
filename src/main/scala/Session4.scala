object Session4 extends App {

  def display(parents: List[Parent]): Unit = {
    parents.foreach { parent =>
      println(parent.name)
    }
  }

  val firstChild = List(FirstChild("Bhavya"), FirstChild("Shivam"))
  val secondChild = List(SecondChild("Rahul"), SecondChild("Abhishek"))

  display(firstChild)
  display(secondChild)
}

abstract class Parent {
  val name: String
}

case class FirstChild(name: String) extends Parent
case class SecondChild(name: String) extends Parent

// -----------------------------------------------------------------------

abstract class Show[-T]
{
  def print(value: T): Unit
}

abstract class Vehicle
{
  def name: String
}

case class Car(name: String) extends Vehicle

class VehicleShow extends Show[Vehicle]
{
  def print(vehicle: Vehicle): Unit =

    println("The name of the vehicle is: " + vehicle.name)
}

class CarShow extends Show[Car]
{
  def print(car: Car): Unit =
    println("The name of the car is: " + car.name)
}

object Contravariance extends App
{
  val newCar: Car = Car("Scorpio")

  def printnewCar(show: Show[Car]): Unit =
  {
    show.print(newCar)
  }

  val showcar: Show[Car] = new CarShow
  val showvehicle: Show[Vehicle] = new VehicleShow

  printnewCar(showcar)
  printnewCar(showvehicle)
}
