object Session3 extends App {

  val queueString = new Queue[String]

  queueString.insert("Bhavya")
  queueString.insert("Shivam")
  queueString.display()

  val queueInt = new Queue[Int]
  queueInt.insert(10)
  queueInt.insert(20)
  queueInt.display()

  val queueAnimal = new Queue[Animal]
  queueAnimal.insert(Cat)
  queueAnimal.insert(Dog)
  queueAnimal.display()

  val polymorphicMethods = new PolymorphicMethods
  val listInt: List[Int] = List(5, 7, 8, 10)
  val resultInt = polymorphicMethods.doubleElement[Int](Seq.empty[Int], listInt, 10)

  println("resultInt: " + resultInt)

  val listString: List[String] = List("Bhavya", "Shivam", "Rahul")
  val resultString = polymorphicMethods.doubleElement[String](Seq.empty, listString, 3)
  println("resultString: " + resultString)
}

class Queue[A] {
  var elements: List[A] = List.empty

  def insert(value: A): Unit = {
    elements = elements :+ value
  }

  def display(): Unit = {
    println("Elements in the queue " + elements)
  }
}

trait Animal

object Cat extends Animal
object Dog extends Animal
object Lion extends Animal

class PolymorphicMethods {
  def doubleElement[A](seq: Seq[A], elements: List[A], times: Int): Seq[A] = {
    if(times < 1) {
      seq
    }
    else {
      doubleElement(seq.appendedAll(elements) ,elements, times - 1)
    }
  }
}
