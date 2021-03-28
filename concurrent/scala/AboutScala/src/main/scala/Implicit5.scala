// 암시적 변환

object Implicit5 extends App{
  case class Paper(content: String)
  case class Book(name: String, code: Int)

  // book 객체를 paper 객체로 바꿈
  implicit def bookToPaper(book: Book): Paper = Paper(s"${book.code} - ${book.name}")

  val book: Book = Book("Scala", 211)
  val paper: Paper = book // implicit bookToPaper 함수를 이용해 Paper 객체로 변환

  println(paper)

  Thread.sleep(1000)
}
