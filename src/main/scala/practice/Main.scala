package practice

import p1threads.{ProducerConsumer, ThreadSafeCollection}

object Main {
  def main(args: Array[String]): Unit = {
    //    ProducerConsumer.execute(3, 4)

    val aCollection = new ThreadSafeCollection[Int]

    val thread1 = new Thread(() => aCollection.addToCollection(1, 6))
    val thread2 = new Thread(() => aCollection.addToCollection(6, 11))

    thread1.start()
    thread2.start()

    Thread.sleep(500)
    aCollection.printElements()
    //
    //    def runThreads(threadNum: Int, i: Int = 1): Thread = new Thread(() => {
    //      if (i < threadNum) {
    //        val thread = runThreads(threadNum, i + 1)
    //        thread.start()
    //      }
    //      print(s"thread_$i ")
    //    })
    //
    //    runThreads(13).start()
  }
}