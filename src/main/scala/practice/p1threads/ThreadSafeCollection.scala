package practice.p1threads

import java.util.concurrent.atomic._
import scala.annotation.tailrec

class ThreadSafeCollection[T] {
  private val aList = new AtomicReference[List[T]](Nil)

  @tailrec
  private def add(x: T): Unit = {
    val currentList = aList.get
    val updatedList = x :: currentList
    if (!aList.compareAndSet(currentList, updatedList)) this.add(x)
  }

  def addToCollection(from: Int, end: Int): Unit =
    for (i <- from until end) yield add(i.asInstanceOf[T])

  def printElements(): Unit = println(aList.get())
}
