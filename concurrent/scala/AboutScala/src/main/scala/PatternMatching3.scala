
object PatternMatching3 extends App {
  // 튜플에 일치시키기
  val langs = Seq(
    ("Scala", "Martin", "Odersky"),
    ("Clojure", "Rich", "Hickey"),
    ("Lisp", "John", "McCarthy")
  )

  for (tuple <- langs) {
    tuple match {
      case ("Scala",_,_) => println("Found Scala")
      case (lang, first, last) => println(s"Found other language: $first ($lang, $last)")
    }
  }

  println()

  // 케이스 클래스에 일치시키기
  case class Address(street: String, city: String, country: String)
  case class Person(name: String, age: Int, address: Address)

  val alice = Person("Alice", 25, Address("1 Lane", "Chicago", "USA"))
  val bob = Person("Bob", 29, Address("2 Ave", "Miami", "USA"))
  val charlie = Person("Charlie", 32, Address("3 city", "Boston", "UST"))

  for (person <- Seq(alice, bob, charlie)) {
    person match {
      case Person("Alice", 25, Address(_, "Chicago", _)) => println("Alice!")
      case Person("Bob", _, Address("2 Ave", "Miami", "USA")) => println("hi bob!")
      case Person(name, age, _) => println(s"Who are you, $age year-old person named $name?")
    }
  }
}
