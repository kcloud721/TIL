object PatternMatching1 extends App{
  val bools = Seq(true, false)

  for (bool <- bools) {
    bool match {
      case true => println("Got heads")
      case false => println("Got tails")
    }
  }

  println()

  for { x <- Seq(1, 2, 2.7, "one", "two", "four") } {
    val str = x match {
      case 1 => "int 1"
      case i: Int => "other int: " + i
      case d: Double => "a double: " + x
      case "one" => "string one"
      case s:String => "other string: " + s
      case unexpected => "unexpected value" + unexpected
    }
    println(str)
  }

  println()

  def checkY(y: Int) = {
    for{ x <- Seq(99, 100, 101) } {
      val str = x match {
        case `y` => "found y!"  // `y` 'y' y 일 때 결과가 다 다름
        case i:Int => "int: " + i
      }
      println(str)
    }
  }
  checkY(100)
}
