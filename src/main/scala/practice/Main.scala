package practice

import p1threads.{Account, Message, ProducerConsumer, ThreadSafeCollection}
import practice.p1threads.Practice1.{execute, runThreads, work}

object Main {
  def main(args: Array[String]): Unit = {
    //    ProducerConsumer.execute(3, 4)
    //--------------------------------------------------------------------------------
    //    val aCollection = new ThreadSafeCollection[Int]
    //
    //    val thread1 = new Thread(() => aCollection.addToCollection(1, 6))
    //    val thread2 = new Thread(() => aCollection.addToCollection(6, 11))
    //
    //    thread1.start()
    //    thread2.start()
    //
    //    Thread.sleep(500)
    //    aCollection.printElements()
    //
    //    runThreads(13).start()
    //--------------------------------------------------------------------------------
    //    work(5)
    //--------------------------------------------------------------------------------
    //    val account: Account = new Account(10)
    //    val amt = 1
    //
    //    for (_ <- 1 to 5) {
    //      new Thread(() => account.deposit(amt)).start()
    //    }
    //
    //    for (_ <- 1 to 5) {
    //      new Thread(() => account.withdraw(amt)).start()
    //    }
    //
    //    Thread.sleep(100)
    //
    //    println(account.balance)
    //--------------------------------------------------------------------------------
    //    val num = 2;
    //    val str = "someString"
    //    println(execute(System.nanoTime(), System.nanoTime()))
    //    println(execute(2 * num, str.substring(0, 3)))
    //--------------------------------------------------------------------------------
    //    val message = new Message[Int];
    //    message.read();
    //    message.create(11)
    //    message.create(14)
    //    message.read();
    //    message.create(14)
    //    message.read();
    //--------------------------------------------------------------------------------
  }
}