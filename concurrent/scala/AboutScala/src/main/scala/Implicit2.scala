import java.util.concurrent.TimeUnit
//import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Implicit2 extends App {
//  val result: Future[String] = Future {
//    TimeUnit.SECONDS.sleep(2L)
//    "Hello-world"
//  }

  val result: Future[String] = Future {
    TimeUnit.SECONDS.sleep(2L)
    "Hello-world"
  }(scala.concurrent.ExecutionContext.Implicits.global)

  result.onComplete{
    case Success(str) => println(str)
    case Failure(exception) => exception.printStackTrace()
  }(scala.concurrent.ExecutionContext.Implicits.global)

  Thread.sleep(3000)
}
