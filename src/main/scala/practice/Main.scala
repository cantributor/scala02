package practice

object Main {
  def main(args: Array[String]): Unit = {
    class CustomThread extends Thread {
      override def run(): Unit = {
        println("custom thread running...")
        Thread.sleep(3000)
      }
    }

    val thread = new CustomThread
    thread.start()
    thread.join()

    println("custom thread has completed its execution")
  }
}