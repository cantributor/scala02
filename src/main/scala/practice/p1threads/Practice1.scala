package practice.p1threads

object Practice1 {

  def runThreads(threadNum: Int, i: Int = 1): Thread = new Thread(() => {
    if (i < threadNum) {
      val thread = runThreads(threadNum, i + 1)
      thread.start()
      thread.join() // just this added
    }
    print(s"thread_$i ")
  })

  def work(n: Int): Unit = {
    val process = new Object

    (1 to n).foreach(i => new Thread(() => {
      process.synchronized {
        process.wait()
        println(s"thread")
      }
    }).start())

    new Thread(() => {
      println("Time to work!")
      process.synchronized {
        process.notifyAll()
      }
    }).start()
  }

  def execute[A, B](a: => A, b: => B): (A, B, A) = {
    var a1Res: A = null.asInstanceOf[A]
    var bRes: B = null.asInstanceOf[B]
    var a2Res: A = null.asInstanceOf[A]
    val thread1 = new Thread(() => {
      a1Res = a
    })
    val thread2 = new Thread(() => {
      bRes = b
    })
    val thread3 = new Thread(() => {
      a2Res = a
    })
    thread1.start()
    thread2.start()
    thread3.start()
    thread1.join()
    thread2.join()
    thread3.join()
    (a1Res, bRes, a2Res)
  }
}

class Account(private var amount: Int) {
  def deposit(money: Int): Unit = amount.synchronized {
    this.amount += money
  }

  def withdraw(money: Int): Unit = amount.synchronized {
    this.amount -= money
  }

  def balance: Int = amount.synchronized {
    amount
  }
}

import java.util.concurrent.atomic.AtomicReference

class Message[T] {
  private val value: AtomicReference[Option[T]] = new AtomicReference[Option[T]](None)

  def read(): Unit = {
    if (value.get().isEmpty) {
      println("No message found")
    } else {
      println(value.get.get)
      value.set(None)
    }
  }

  def create(m: T): Unit = {
    if (value.get().isDefined) {
      println("Read the message")
    } else {
      value.set(Some(m))
      println("Message created")
    }
  }
}