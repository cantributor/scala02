package practice.p1threads

import scala.collection.mutable
import scala.util.Random

class Consumer(id: Int, buffer: mutable.Queue[Int]) extends Thread {
  override def run(): Unit = {
    val random = new Random()

    while(true) {
      buffer.synchronized {
        while (buffer.isEmpty) {
          println(s"[потребитель $id] ожидает значение...")
          buffer.wait()
        }

        val x = buffer.dequeue()
        println(s"[потребитель $id] значение получено:" + x)

        buffer.notify()
      }

      Thread.sleep(random.nextInt(250))
    }
  }
}

class Producer(id: Int, buffer: mutable.Queue[Int], capacity: Int) extends Thread {
  override def run(): Unit = {
    val random = new Random()
    var i = 0

    while(true) {
      buffer.synchronized {
        while (buffer.size == capacity) {
          println(s"[производитель $id] буфер заполнен...ожидание...")
          buffer.wait()
        }

        println(s"[производитель $id] предосталяет значение:" + i)
        buffer.enqueue(i)

        buffer.notify()

        i += 1
      }

      Thread.sleep(random.nextInt(500))
    }
  }
}

object ProducerConsumer {

  def execute(nConsumers: Int, nProducers: Int): Unit = {
    val buffer: mutable.Queue[Int] = new mutable.Queue[Int]
    val capacity = 20

    (1 to nConsumers).foreach(i => new Consumer(i, buffer).start())
    (1 to nProducers).foreach(i => new Producer(i, buffer, capacity).start())
  }
}
