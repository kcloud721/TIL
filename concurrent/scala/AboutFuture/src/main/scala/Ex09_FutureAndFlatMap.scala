import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.io.Source

object Ex09_FutureAndFlatMap extends App {
  val netiquette = Future { Source.fromURL("http://www.ietf.org/rfc/rfc1855.txt").mkString }
  val urlSpec = Future { Source.fromURL("http://www.w3.org/Addressing/URL/url-spec.txt").mkString }
  val answer = netiquette.flatMap { nettext =>
    urlSpec.map { urltext =>
      "First, read this: " + nettext + ". Now try this " + urltext
    }
  }

  answer foreach {
    case contents => println(contents)
    case t => println(s"hihi $t")
  }

  Thread.sleep(2000)
}
