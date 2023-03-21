
import scala.collection.parallel.CollectionConverters.ImmutableSeqIsParallelizable
import scala.collection.parallel.immutable.ParSeq
import scala.util.Random

object Session2 extends App {

//  val list = (1 to 1000).toList
  val collections = new Collections
//
//  collections.sideEffect(list)
//  collections.display

//  val list = (1 to 1000).toList.par
//  collections.sideEffectParallel(list)
//  collections.display

//  val result = collections.associative(list)
//  println("result: " + result)

  val list = (1 to 1000).toList.par
  val result = collections.associativeParallel(list)
  println("result: " + result)

  Random.nextLong()
}

class Collections {
  var sum: Int = 0

  def sideEffect(values: List[Int]): Unit = {
    values.foreach { sum += _ }
  }

  def associative(values: List[Int]): Int = {
    values.reduce( (first, second) => first - second )
  }

  def sideEffectParallel(values: ParSeq[Int]): Unit = {
    values.foreach( sum += _ )
  }

  def associativeParallel(values: ParSeq[Int]): Int = {
    values.reduce((first, second) => first - second)
  }

  def display: Unit = {
    println("Sum: " + sum)
  }
}