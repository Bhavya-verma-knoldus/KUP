/*
 This file is just for an example, the code won't compile if you uncomment this file.

abstract class List[-T]
{
  def print(value: T): Unit
}

abstract class Parent
{
  def name: String
}

case class Child(name: String) extends Parent

class ParentClass extends List[Parent]
{
  def print(parent: Parent): Unit =

    println("The name of the parent is: " + parent.name)
}

class ChildClass extends List[Child]
{
  def print(child: Child): Unit =
    println("The name of the child is: " + child.name)
}

object Contravariance extends App
{
  val newChild: Child = Child("Human")

  def printnewCar(list: List[Child]): Unit =
  {
    list.print(newChild)
  }

  val showChild: List[Child] = new ChildClass
  val showParent: List[Parent] = new ParentClass

  printnewCar(showChild)
  printnewCar(showParent)
}
*/