import scala.concurrent._

object Ex02_ExecutorContext extends App{
  println(s"${Thread.currentThread().getName}")

  // ExecutionContext.global 생
  val ectx = ExecutionContext.global
  ectx.execute(new Runnable {
    println("hi")
    def run() = println(s"Running on execution context. - ${Thread.currentThread().getName}")
  })


  // ExecutionContext 활용
  def execute(body: => Unit) = ExecutionContext.global.execute(new Runnable {
    override def run(): Unit = body
  })

  for(i <- 0 until 32) execute {
    Thread.sleep(500)
    println(s"Task $i completed. ${Thread.currentThread().getName}")
  }


  def func(i: Int) = {
    Thread.sleep(1000)
    println(s"Task $i ... ${Thread.currentThread().getName}")
  }
  for(i <- 0 until 32)
    execute {func(i)}

  Thread.sleep(20000)
}
