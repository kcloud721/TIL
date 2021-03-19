import scala.collection.mutable

object LearnScala{
  def main(args: Array[String]): Unit = {
    // 1. 배열로 구현되는 ArrayBuffer
    val arrayBuffer = mutable.ArrayBuffer(1, 2, 3)
    arrayBuffer += 4
    arrayBuffer -= 1
    arrayBuffer ++= List(5, 6, 7)
    println(s"1. $arrayBuffer")

    // 2. LinkedList로 구현되는 ListBuffer
    val listBuffer = mutable.ListBuffer("a", "b", "c")
    println(s"2. listBuffer")

    // 3. Mutable Set
    val hashSet = mutable.Set(0.1, 0.2, 0.3)
    hashSet ++= mutable.Set(5)
    println(s"3. $hashSet")

    // 4. Mutable Map
    val hashMap = mutable.Map("one" -> 1, "two" -> 2)
    hashMap ++= Map("five" -> 5, "six" -> 6)
    println(s"4. $hashMap")
  }
}