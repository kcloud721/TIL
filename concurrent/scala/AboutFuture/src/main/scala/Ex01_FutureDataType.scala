object Ex01_FutureDataType extends App{
  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import scala.io.Source

  val myFuture: Future[String] = Future{
    val f = Source.fromFile("build.sbt")
    try f.getLines().mkString("\n") finally f.close()
  }

  println(s"Started reading build file asynchronously")
  println(s"status: ${myFuture.isCompleted} ... value: ${myFuture.value}")
  Thread.sleep(250)

  println(s"status: ${myFuture.isCompleted} ... value: ${myFuture.value}")

}
