object LearnScala{
  def main(args: Array[String]): Unit = {
    val num = -5
    val numAbs = num.abs  // 절대값
    val max5or7 = numAbs.max(7) // numAbs와 7 사이의 최대값
    val min5or7 = numAbs.min(7) // numAbs와 7 사이의 최소값

    println(numAbs)
    println(max5or7)
    println(min5or7)
  }
}