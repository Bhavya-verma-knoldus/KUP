
object Session1 extends App {

//  val person = Person("Hello", 25, "Noida")

//  person.name match {
//    case "Bhavya" => println("Name is Bhavya")
//    case "Rahul" => println("Name is rahul")
//    case _ => println("wildcard")
//  }

  val patternMatch = new PatternMatch
//  employee.patternMatching(11)

//  val person = Person("Hello",10, "Noida")
//  patternMatch.constructorPattern(person)
//
//  val tuple = ("Bhavya", 10)
//  patternMatch.tuplePattern(tuple)
//
//  println(patternMatch.optionsPattern(Some("Bhavya")))

//  val list: List[Option[String]] = List(Some("Bhavya"), None, Some("Shivam"))

//  val newList = patternMatch.handleFlatmap(list)

  val list = List("Rahul", "Bhavya", "Bhavesh")
  println(patternMatch.handleFind(list))
}

case class Person(name: String, age: Int, address: String)

class PatternMatch {
  def patternMatching(value: Any) = {
    value match {
      case 10 => println("Int matched")
      case "Bhavya" => println("String matched")
      case 10.5 => println("Double matched")
      case true => println("Boolean matched")
      case _ => println("wildcard matched")
    }
  }

  def constructorPattern(person: Person): Unit = {
    person match {
      case Person("Bhavya", 10, _) => println("name and age case matched")
      case Person(_, 25, _) => println("agr matched")
      case Person(_, _, _) => println("all values matched")
    }
  }

  def tuplePattern(value: Any): Unit = {
    value match {
      case (firstValue, secondValue) => println(s"2 values in tuple - $firstValue, $secondValue")
      case (firstValue, secondValue, thirdValue) => println(s"3 values in tuple - $firstValue, $secondValue, $thirdValue")
      case _ => println("Wildcard matched")
    }
  }

  def optionsPattern(value: Option[String]) = {
    value match {
      case Some(value) => println(s"Some found - $value")
      case None => println("None matched")
    }
  }

  def listPattern(list: List[String]): Unit = {
    list match {
      case head :: Nil => println("head of list: " + head )
      case head :: tail => println("head of list: " + head + "\n tail of list: " + tail)
      case Nil => println("Nil found")
    }
  }

  def higherOrderFunction(names: List[String]): Unit = {
    names.foreach { name =>
      if(name == "Bhavya") {
        println(name)
      }
      else {
        println("else case")
      }
    }
  }

  def handleOption(maybeName: Option[String]): Option[String] = {
    maybeName.map( name => name.toUpperCase )
  }

  def handleFlatmap(names: List[Option[String]]): List[String] = {
    names.flatMap { maybeName =>
      maybeName.map { name =>
        name.toUpperCase
      }
    }
  }

  def handleFlatmap2(names: Option[Option[String]]): Option[String] = {
    names.flatMap { name =>
      name.map { finalName =>
        finalName.toUpperCase
      }
    }
  }

  def handleFilter(names: List[String]): List[String] = {
    names.filterNot( name => name.startsWith("Bh") )
  }

  def handleFind(names: List[String]): Option[String] = {
    names.find(name => name.startsWith("Bh"))
  }
}
