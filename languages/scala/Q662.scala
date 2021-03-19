import scala.collection.mutable

object LearnScala{
  def main(args: Array[String]): Unit = {
    // 1. 변경할 수 없는 Collection이 var로 선언된 경우
    var immutableSet = Set(1, 2, 3)
    immutableSet += 4
    // 위 코드는 새로운 Set을 만들어서 immutableSet에 저장하는 아래 코드와 같음

    immutableSet = immutableSet + 4
    println(s"1. $immutableSet")

    // 2. 변경할 수 있는 Collection이라면 추가하는 메소드를 호출하는 것과 같다
    val mutableSet = mutable.Set(1, 2, 3)
    mutableSet += 4
    // 위 코드는 mutalbeSet 자체의 메소드(+=)를 호출하는 아래 코드와 같음

    mutableSet.+=(4)
    println(s"2. $mutableSet")
  }
}