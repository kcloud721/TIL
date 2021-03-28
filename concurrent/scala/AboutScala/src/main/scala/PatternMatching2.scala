// 시퀀스에 일치시키기 (Sequence: 순서가 정해진 열)
// Seq 는 정해진 순서대로 원소를 순회할 수 있는 List, Vector 등의 모든 구체적인 컬렉션 타입의 부모 타입
object PatternMatching2 extends App {
  val nonEmptySeq = Seq(1,2,3,4,5)
  val emptySeq = Seq.empty[Int]
  val nonEmptyList = List(5,6,7,8,9)
  val emptyList = Nil
  val nonEmptyVector = Vector(1,2,3,4,5)
  val emptyVector = Vector.empty [Int]
  val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3)
  val emptyMap = Map.empty[String, Int]

  def seqToString[T] (seq: Seq[T]): String = seq match {
    case head +: tail => s"$head +:" + seqToString(tail)
    case Nil => "Nil"
  }

  for (seq <- Seq(
    nonEmptySeq, emptySeq, nonEmptyList, emptyList,
    nonEmptyVector, emptyVector, nonEmptyMap.toSeq, emptyMap.toSeq)) {
    println(seqToString(seq))
  }

  // Map에 toSeq 한 이유: Map은 Seq의 서브타입이 아님(순서를 보장하지 않음)
  // toSeq을 호출해 키-값 튜플의 시퀀스를 만들어 줌



}
