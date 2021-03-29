class applyTest {
  def apply(n: Int) = {
    println("hello")
  }
}

class applyTest2 {
  // `=>` : 입력인자가 없고 리턴이 Int형 > 람다식?
  def apply(f: => Int) = {
    val n = f + 3
    println("n = %d".format(n))
  }
}

object Apply1 extends App {
  val at = new applyTest
  at{10}

  val at2 = new applyTest2
  at{
    println("applyTest2")
    10
  }
}
