import java.net.{ServerSocket, Socket}
import java.util.concurrent.{ExecutorService, Executors}
import java.util.Date

class NetworkService(port: Int, poolSize: Int) extends Runnable {
  val serverSocket = new ServerSocket(port)
  val pool: ExecutorService = Executors.newFixedThreadPool(poolSize)

  def run(): Unit ={
    try {
      while (true) {
        println(Thread.currentThread().getName)
        val socket = serverSocket.accept()
        pool.execute(new Handler(socket))
      }
    } finally {
      pool.shutdown()
    }
  }
}

class Handler(socket: Socket) extends Runnable{
  def message = (Thread.currentThread().getName + "\n").getBytes

  def run(): Unit ={
    socket.getOutputStream.write(message)
    socket.getOutputStream.close()
  }
}


object Ex01_ExecutorService extends App{
  val hello = new Thread(new Runnable {
    def run(): Unit = {
      println("hello world")
    }
  })

  hello.start()

  (new NetworkService(2020, 2)).run

}