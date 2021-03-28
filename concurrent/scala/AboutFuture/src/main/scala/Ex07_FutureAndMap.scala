object Ex07_FutureAndMap extends App {
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.Future
  import scala.io.Source
  import scala.util.{Success, Failure}

  val buildFile = Future { Source.fromFile("build.sbt").getLines }

  // map: 기존 퓨처에 있는 값을 사용하여 새 퓨처를 만듦
  val longestBuildLine = buildFile.map(lines => lines.maxBy(_.length))

  // for 문으로 할 수도 있음
  val shortestBuildLine = for(lines <- buildFile) yield lines.minBy(_.length)

  longestBuildLine onComplete {
    case Success(line) => println(s"the longest line is '$line'")
    case t => println(s"hello? $t")
    case Failure(error) => println(s"There should be no $error here.")
  }

  shortestBuildLine onComplete {
    case Success(line) => println(s"the shortest line is '$line'")
    case Failure(error) => println(s"There should be no $error here.")
  }

  Thread.sleep(1000)
}
