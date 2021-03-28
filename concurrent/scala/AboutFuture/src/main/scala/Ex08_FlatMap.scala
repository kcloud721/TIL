object Ex08_FlatMap extends App {
  val strings = Seq("1", "2", "foo", "3", "bar")

  def toInt(s: String): Option[Int] = {
    try{
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  println(strings)
  println(strings.map(toInt))
  println(strings.flatMap(toInt))
  println(strings.flatMap(toInt).sum)
}
