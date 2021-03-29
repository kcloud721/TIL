object Lambda extends App {
  // Int 를 받아서 String 을 반환하는 람다식
  def test = (x: Int) => x + 1
  println(test(3).toString)

  def test2 (f: Int => String): Unit = {
    println(f(3))
  }

  def logging (x: Int):String = {
    x.toString
  }

//  test(logging(3: Int)
}
