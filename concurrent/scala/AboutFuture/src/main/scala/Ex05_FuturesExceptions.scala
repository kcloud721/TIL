
object Ex05_FuturesExceptions extends App{
  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import scala.io.Source
  import scala.util.{Try, Failure, Success}

  val file = Future{ Source.fromFile(".gitignore-SAMPLE").getLines.mkString("\n")}

  file foreach {
    text => println(text)
  }

  file.failed foreach {
    case fnfe : java.io.FileNotFoundException => println(s"[.failed] $fnfe")
    case t => println(s" Failed due to  $t")
  }

  file onComplete {
    case Success(text) => println(text)
    case Failure(exception) => println(s"[onComplete] $exception")
  }

  Thread.sleep(1000)
}
