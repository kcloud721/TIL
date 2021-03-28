object Ex02_FuturesComputation extends App {
  import scala.concurrent._
  import ExecutionContext.Implicits.global

  Future {
    println(s"The future is here")
  }

  println(s"The future is coming")
}