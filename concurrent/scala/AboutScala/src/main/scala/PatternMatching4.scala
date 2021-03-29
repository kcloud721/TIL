import PatternMatching4.patternMatching2.Test

object PatternMatching4 extends App {
  object patternMatching2 {
    object Test {
      def unapply(a: Int): Boolean = {
        if(a < 10) true
        else false
      }
    }
  }

  object Test2 {
    def unapply(a: Int): Option[(Int, String)] = {
      if (a > 30) Some(a/10, "from Test2")
      else None
    }
  }

  class Example {
    def method(target: Int): Unit = {
      target match {
        case Test() => println("matched to Test")
        case Test2(n @ Test(), m) => println("result: " + n + " " + m)
        case 120 => println("matched to 120")
        case 11 => println("noneMatching")
      }
    }
  }

  val t = new Example
  t.method(11)
  t.method(40)
  t.method(120)

}
