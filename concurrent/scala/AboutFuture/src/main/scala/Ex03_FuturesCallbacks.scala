import Ex04_FuturesFailure.urlSpec

object Ex03_FuturesCallbacks extends App{
  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import scala.io.Source

  def getUrlSpec(): Future[Seq[String]] = Future{
    val f = Source.fromURL("http://www.w3.org/Addressing/URL/url-spec.txt")
    try f.getLines.toList finally f.close()
  }


  val urlSpec : Future[Seq[String]] = getUrlSpec()

  def find(lines: Seq[String], word: String) = lines.zipWithIndex collect {
    case(line, n) if line.contains(word) => (n, line)
  } mkString("\n")

  urlSpec foreach {
    lines => println(s"Found occureences of 'telnet'\n${find(lines, "telnet")}")
  }

  urlSpec foreach {
    lines => println(s"Found occureences of 'password'\n${find(lines, "password")}")
  }

  urlSpec.failed foreach{
    case t => println(s"exception occurred - $t")
  }

  println(s"callbacks installed, continuing with other work")
  Thread.sleep(1000)

}
